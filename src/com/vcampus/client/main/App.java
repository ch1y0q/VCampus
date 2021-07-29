package com.vcampus.client.main;

import com.vcampus.client.LoginUI;
import com.vcampus.client.main.manager.AppAdmin;
import com.vcampus.client.main.teacher.AppTeacher;
import com.vcampus.client.messageQueue.ResponseQueue;
import com.vcampus.net.ConnectionToServer;
import com.vcampus.net.ResponseListener;
import com.vcampus.net.Session;
import com.vcampus.util.ConnectionUtils;
import com.vcampus.util.SwingUtils;
import com.vcampus.entity.UserType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class App extends JFrame {
    public static boolean hasLogon = false; // 登录状态
    public static Session session; // 登陆Session
    public static ConnectionToServer connectionToServer; // 到服务器的连接
    public static ResponseQueue responseQueue; // 前端响应队列
    private ResponseListener responseListener; // 前端响应监听器

    private JPanel contentPane;

    private static Locale locale;
    private static ResourceBundle res;

    /**
     * 要求进行界面路由
     */
    public static void requireRouting() {
        JFrame target = null;
        UserType userType = App.session.getUserType();
        //ManagerType managerType = (userType == UserType.MANAGER ? App.session.getManager().getManagerType() : null);
        target = userType == UserType.STUDENT ? new StudentFancyUI()
                : userType == userType.TEACHER ? new TeacherFancyUI()
                : userType == userType.ADMIN ? new AppAdmin()
                /*
                ? (managerType == ManagerType.LIBRARY ? new AppLibraryManager()
                : managerType == ManagerType.OPENCOURSE ? new AppOpencourseManager()
                : managerType == ManagerType.SHOP ? new AppShopManager()
                : managerType == ManagerType.TEACHING ? new AppTeachingManager() : null)

                 */
                : null;


        if (target == null) {
            SwingUtils.showError(null, res.getString("routing_failure"), res.getString("error"));
            System.exit(1);
        }
        target.setVisible(true);
    }

    public App() throws IOException {
        locale = Locale.getDefault();
        res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

        // 连接到服务器
        App.connectionToServer = ConnectionUtils.formConnection();
        // 报错，结束运行
        if (App.connectionToServer == null) {
            SwingUtils.showError(null, String.format(res.getString("connection_to_server_failure") , ConnectionUtils.getServerHost() , ConnectionUtils.getMainPort()), res.getString("error"));
            System.exit(0);
        }
        // 初始化响应队列
        App.responseQueue = ResponseQueue.getInstance();
        // 开始侦听响应
        this.responseListener = new ResponseListener(App.connectionToServer);
        this.responseListener.start();
        // 要求登录
        if (!App.hasLogon) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        LoginUI frame = new LoginUI();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 61, 69);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }

}
