package com.vcampus.client.main.chat;

import com.vcampus.client.main.App;
import com.vcampus.util.ServerUtils;
import com.vcampus.util.SwingUtils;

import javax.swing.*;
import java.awt.event.*;

public class AppChatDiag extends JDialog {
    private JPanel contentPane;
    private JButton buttonSend;
    private JButton buttonCancel;
    private JTextArea textAreaSay;
    private JTextArea textAreaHear;

    private NetworkService networkService;

    private void initNetworkService() {
        networkService = new NetworkService();
        networkService.setCallback(new NetworkService.Callback() {
            @Override
            public void onConnected(String host, int port) {
                // 连接成功时，弹对话框提示
                // SwingUtils.showMessage(null,"成功连接到[" + host + ":" + port + "]","连接");
            }

            @Override
            public void onConnectFailed(String host, int port) {
                // 连接失败时，弹对话框提示，并将按钮文字设为“连接”
                SwingUtils.showError(null, "无法连接到[" + host + ":" + port + "]","连接");
            }

            @Override
            public void onDisconnected() {
                SwingUtils.showMessage(null, "连接已断开","连接");
            }

            @Override
            public void onMessageSent(String name, String msg) {
                // 发出消息时，清空消息输入框，并将消息显示在消息区
                textAreaSay.setText("");
                textAreaHear.append("我(" + name + "):\r\n" + msg + "\r\n\r\n");
            }

            @Override
            public void onMessageReceived(String name, String msg) {
                // 收到消息时，将消息显示在消息区
                textAreaHear.append(name + ":\r\n" + msg + "\r\n\r\n");
            }
        });
    }

    private void sendMessage() {
        // 响应发送按钮
        String name = null;
        if(App.session != null) {
            name = switch (App.session.getUserType()) {
                case STUDENT -> App.session.getStudent().getName();
                case TEACHER -> App.session.getTeacher().getName();
                case ADMIN -> App.session.getAdmin().getName();
            };
        }
        if (name == null) {
            name = "匿名用户";
        }

        String msg = textAreaSay.getText();

        // 检查参数合法性
        if (name == null || msg == null || "".equals(name) || "".equals(msg)) {
            return;
        }
        // 发送消息
        networkService.sendMessage(name, msg);
    }

    /* constructor */
    public AppChatDiag() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonSend);

        /* Initialize network services */
        initNetworkService();

        /* connect to chat server */
        if (!networkService.isConnected()) {
            // 未连接状态下，执行连接服务器操作
            String host = ServerUtils.getServerHost();
            int port = Integer.parseInt(ServerUtils.getChatPort());
            networkService.connect(host, port);
        } else {
            // 已连接状态下，执行断开连接操作
            networkService.disconnect();
        }

        buttonSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSend();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        textAreaSay.addKeyListener(new KeyListener() {
            // http://www.uxys.com/html/JavaScript/20160809/42930.html
            @Override
            public void keyTyped(KeyEvent e) {
                // nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    sendMessage();
                    textAreaSay.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // nothing
            }
        });
    }

    private void onSend() {
        // add your code here
        sendMessage();
        textAreaSay.setText("");
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        networkService.disconnect();
        dispose();
    }

    public static void main(String[] args) {
        AppChatDiag dialog = new AppChatDiag();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
