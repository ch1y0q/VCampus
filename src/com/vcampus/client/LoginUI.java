package com.vcampus.client;

import com.vcampus.client.main.App;
import com.vcampus.entity.Student;
import com.vcampus.entity.Teacher;
import com.vcampus.entity.Admin;
import com.vcampus.entity.UserType;
import com.vcampus.net.Session;
import com.vcampus.util.SwingUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 登陆界面的GUI
 *
 * @author Huang Qiyue
 * @date 2021-07-07
 */

public class LoginUI extends JFrame {
    private JPanel loginPanel;
    private JButton btnLogin;
    private JRadioButton rdbStudent;
    private JRadioButton rdbTeacher;
    private JRadioButton rdbAdmin;
    private JTextField txtCardNumber;
    private JPasswordField txtPassword;

    private Locale locale;
    private ResourceBundle res;


    public void login() {
        /* check if all fields are filled */
        if (SwingUtils.isEmpty(txtCardNumber) || SwingUtils.isEmpty(txtPassword)) {
            JOptionPane.showMessageDialog(null, res.getString("empty_field"), res.getString("error"), JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserType type = null;
        if (rdbStudent.isSelected()) {
            type = UserType.STUDENT;
            Student student = Verifier.checkStudent(txtCardNumber.getText(), new String(txtPassword.getPassword()));
            if (student != null) {
                SwingUtils.showMessage(null, res.getString("student_login_success"), res.getString("info"));
                // 填充App.session
                App.hasLogon = true;
                App.session = new Session(student);
                setVisible(false);
                // 要求界面路由
                App.requireRouting();
            } else {
                SwingUtils.showError(null, res.getString("wrong_password"), res.getString("error"));
                txtPassword.setText("");
            }
        } else if (rdbTeacher.isSelected()) {
            type = UserType.TEACHER;
            Teacher teacher = Verifier.checkTeacher(txtCardNumber.getText(), new String(txtPassword.getPassword()));
            if (teacher != null) {
                SwingUtils.showMessage(null, res.getString("teacher_login_success"), res.getString("info"));
                // 填充App.session
                App.hasLogon = true;
                App.session = new Session(teacher);
                setVisible(false);
                // 要求界面路由
                App.requireRouting();
            } else {
                SwingUtils.showError(null, res.getString("wrong_password"), res.getString("error"));
                txtPassword.setText("");
            }
        } else if (rdbAdmin.isSelected()) {
            type = UserType.ADMIN;
            System.out.println(txtPassword.getPassword()+"TEST1");
            Admin admin = Verifier.checkAdmin(txtCardNumber.getText(), new String(txtPassword.getPassword()));
            if (admin != null) {
                SwingUtils.showMessage(null, res.getString("admin_login_success"), res.getString("info"));
                // 填充App.session
                App.hasLogon = true;
                App.session = new Session(admin);
                setVisible(false);
                // 要求界面路由
                App.requireRouting();
            } else {
                SwingUtils.showError(null, res.getString("wrong_password"), res.getString("error"));
                txtPassword.setText("");
            }
        }
    }

    public LoginUI() {
        locale = Locale.getDefault();
        res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 800, 520);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/assets/icon/fav2.png")));
        setTitle(res.getString("window_title"));

        loginPanel = new JPanel();
        loginPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
        loginPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(loginPanel);

        JPanel pBody = new JPanel();
        loginPanel.add(pBody, BorderLayout.CENTER);
        pBody.setLayout(null);

        JLabel lblUsername = new JLabel(res.getString("card_number"));
        lblUsername.setBounds(500, 215, 60, 18);
        pBody.add(lblUsername);

        txtCardNumber = new JTextField();
        txtCardNumber.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        txtCardNumber.setBounds(555, 214, 180, 24);
        pBody.add(txtCardNumber);
        txtCardNumber.setColumns(8);

        JLabel lblPassword = new JLabel(res.getString("password"));
        lblPassword.setBounds(506, 268, 40, 18);
        pBody.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        txtPassword.setBounds(555, 266, 180, 24);
        pBody.add(txtPassword);

        rdbStudent = new JRadioButton(res.getString("student"));
        rdbTeacher = new JRadioButton(res.getString("teacher"));
        rdbAdmin = new JRadioButton(res.getString("admin"));

        rdbStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdbStudent.isSelected()) {
                    rdbTeacher.setSelected(false);
                    rdbAdmin.setSelected(false);
                } else {
                    rdbStudent.setSelected(true);
                }
            }
        });

        rdbTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdbTeacher.isSelected()) {
                    rdbStudent.setSelected(false);
                    rdbAdmin.setSelected(false);
                } else {
                    rdbTeacher.setSelected(true);
                }
            }
        });

        rdbAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdbAdmin.isSelected()) {
                    rdbStudent.setSelected(false);
                    rdbTeacher.setSelected(false);
                } else {
                    rdbAdmin.setSelected(true);
                }
            }
        });

        rdbStudent.setBounds(560, 320, 59, 27);
        pBody.add(rdbStudent);
        rdbTeacher.setBounds(620, 320, 59, 27);
        pBody.add(rdbTeacher);
        rdbAdmin.setBounds(680, 320, 73, 27);
        pBody.add(rdbAdmin);
        rdbStudent.setSelected(true);

        /* 按下回车登录 */
        KeyAdapter loginKeyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        };

        txtCardNumber.addKeyListener(loginKeyAdapter);
        txtPassword.addKeyListener(loginKeyAdapter);
        //rdbStudent.addKeyListener(loginKeyAdapter);
        //rdbTeacher.addKeyListener(loginKeyAdapter);
        //rdbAdmin.addKeyListener(loginKeyAdapter);

        JLabel label = new JLabel(res.getString("dialog_title"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 35));
        label.setBounds(507, 120, 233, 80);
        pBody.add(label);

        JLabel icon = new JLabel("");
        icon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/fav2.png")));
        icon.setBounds(500, 28, 248, 97);
        pBody.add(icon);

        btnLogin = new JButton(res.getString("login"));
        btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        //btnLogin.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/right-circle.png")));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        btnLogin.setBounds(555, 372, 140, 75);
        pBody.add(btnLogin);

        JLabel lblUserType = new JLabel(res.getString("usertype"));
        lblUserType.setBounds(495, 323, 75, 18);
        pBody.add(lblUserType);

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/bg/bg3.jpg")));
        pBody.add(bg);
        bg.setBounds(0, 0, 470, 525);
    }
}
