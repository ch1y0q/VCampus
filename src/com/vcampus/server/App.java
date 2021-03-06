package com.vcampus.server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vcampus.server.chat.ChatService;
import com.vcampus.server.chat.ClientManager;
import com.vcampus.util.Utf8ResourceBundle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vcampus.net.RequestListener;
import com.vcampus.server.messageQueue.*;
import com.vcampus.util.ServerUtils;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.Student;

/**
 * 服务端主对象
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class App extends JFrame implements ChatService.OnSocketAcceptListener {

    private JPanel contentPane;
    private Locale locale;
    private ResourceBundle res;

    private RequestListener requestListener; // 请求监听器
    public static RequestQueue requestQueue; // 服务器端全局请求消息队列
    public static RequestHandler requestHandler; // 请求处理器
    public static SqlSessionFactory sqlSessionFactory; // MyBatis连接工厂
    public static SqlSession foreverSqlSession; // 永久公有MyBatis连接会话，该会话仅一份，可能出现资源争抢，严禁关闭
    // 如非大量连续请求场景，请使用工厂自行创建SqlSession

    private ChatService chatService;

    public static JTextPane paneLog;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Create the frame.
     */
    public App() {
        locale = Locale.getDefault();
        res = Utf8ResourceBundle.getBundle("com.vcampus.server.AppResource", locale);

        setResizable(false);
        setTitle(res.getString("title"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 718, 493);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);

        JLabel label = new JLabel(res.getString("server_log"));
        label.setBounds(302, 13, 75, 18);
        panel_1.add(label);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 38, 662, 385);
        panel_1.add(scrollPane);
        App.paneLog = new JTextPane();
        App.paneLog.setEditable(false);
        scrollPane.setViewportView(paneLog);
        App.paneLog.setFont(new Font("宋体", Font.PLAIN, 14));

        /* 新增部分 */
        // 初始化全局消息队列
        App.requestQueue = RequestQueue.getInstance();
        // 初始化MyBatis的SqlSession工厂
        String resource = "resources/mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            App.paneLog.setText(res.getString("db_config_success"));
        } catch (IOException e) {
            App.paneLog.setText(res.getString("db_config_failure") + e);
            e.printStackTrace();
        }

        // 尝试连接数据库
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            //boolean verifyResult = studentMapper.verifyStudent(new Student(null, null));
            Student verifyResult = studentMapper.getStudentDetailByCardNumber("");

            sqlSession.commit();
            App.paneLog.setText(res.getString("db_connection_success"));
        } catch (Exception e) {
            App.paneLog.setText(res.getString("db_connection_failure"));
            e.printStackTrace();
        }

        // 启动服务器端侦听
        requestListener = new RequestListener(Integer.parseInt(ServerUtils.getMainPort()));
        requestListener.start();

        // 启动请求处理器
        App.requestHandler = new RequestHandler();
        App.requestHandler.start();
        App.paneLog.setText(
                paneLog.getText() + (paneLog.getText().equals("") ? "" : "\n") + String.format(res.getString("start_listening_on"), ServerUtils.getMainPort()));
        foreverSqlSession = sqlSessionFactory.openSession();

        /* 启动聊天服务 */
        ClientManager clientManager = new ClientManager();
        chatService = new ChatService(clientManager);
        this.chatService.setOnAcceptListener(this);
        chatService.startup();

        App.paneLog.setText(
                paneLog.getText() + (paneLog.getText().equals("") ? "" : "\n") + String.format(res.getString("start_chat_listening_on"), ServerUtils.getChatPort()));
    }

    public static void appendLog(String msg) {
        App.paneLog.setText(App.paneLog.getText() + "\n" + msg);
    }

    @Override
    public void onSocketAccept(Socket socket) {
        App.appendLog(String.format(res.getString("client_joined"), socket.getInetAddress()));
    }
}
