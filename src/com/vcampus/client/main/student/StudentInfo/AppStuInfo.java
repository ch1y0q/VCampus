package com.vcampus.client.main.student.StudentInfo;

import com.vcampus.util.imageIO.ByteArray;
import com.vcampus.util.imageIO.Client;
import com.vcampus.util.imageIO.MessageForImage;
import com.vcampus.client.main.App;
import com.vcampus.client.main.student.AppStudent;
import com.vcampus.client.main.student.StuCategory;
import com.vcampus.util.StringUtils;
import com.vcampus.UI.TreeUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;


/**
 * 学生信息界面
 * @author Dong Ruojing
 * @date 2021/7/23
 */
public class AppStuInfo  extends JFrame {
    private JPanel contentPane;
    public AppStuInfo() {
        setResizable(true);//允许窗口大小更改
        setTitle("个人信息管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTree jt= new StuCategory().getJTree();
        jt.setBounds(0,0,200,d.height);
        jt.setOpaque(false);
        jt.setBackground(new Color(240, 255, 240));
        TreeUtils.expandTree(jt,true);
        //contentPane.add(jt);

        JButton returnButton = new JButton("← 返回");//返回按钮
        returnButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        returnButton.setBounds(220,5,80,30);
        returnButton.setForeground(new Color(33, 117, 206,100));
        contentPane.add(returnButton);


        JButton LogoutButton = new JButton("登出");//登出按钮
        LogoutButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LogoutButton.setBounds(1450,5,50,30);
        LogoutButton.setForeground(new Color(33, 117, 206,100));
        contentPane.add(LogoutButton);

        JButton EditButton = new JButton("启动编辑");//编辑按钮
        EditButton.setFont(new Font("微软雅黑", Font.BOLD, 17));
        EditButton.setBounds(1150,695,90,40);
        EditButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(EditButton);


        JButton btnLoadPortrait = new JButton("上传头像");//上传头像按钮
        btnLoadPortrait.setFont(new Font("微软雅黑", Font.BOLD, 14));
        btnLoadPortrait.setBounds(690,375,80,30);
        btnLoadPortrait.setForeground(new Color(58, 51, 168,100));
        contentPane.add(btnLoadPortrait);


        JButton SaveButton = new JButton("保存");//保存按钮
        SaveButton.setFont(new Font("微软雅黑", Font.BOLD, 17));
        SaveButton.setBounds(1270,695,60,40);
        SaveButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(SaveButton);

        String studentName = App.session.getStudent().getName();//获取姓名
        String studentCardNumber = App.session.getStudent().getCardNumber();//获取一卡通号
        String studentGender = App.session.getStudent().getGender();//获取性别
        String studentSchool = App.session.getStudent().getSchoolByNumber();//获取学院
        String studentEmail = App.session.getStudent().getEmail();//获取邮箱
        String studentPassword = App.session.getStudent().getPassword();//获取登录密码
        String studentPhoneNumber = App.session.getStudent().getPhoneNumber();//获取电话号码
        String studentNumber = App.session.getStudent().getStudentNumber();//获取学号
        String studentBankAccount = App.session.getStudent().getBankAccount();//获取银行账户
        BigDecimal studentBalance = App.session.getStudent().getBalance();//获取存款

        //输入框
        JTextField txt_1=new JTextField();
        txt_1.setBounds(1130,100,170,40);
        txt_1.setEditable(false);
        txt_1.setText(studentName);
        txt_1.setForeground(Color.GRAY);
        contentPane.add(txt_1);

        JTextField txt_2=new JTextField();
        txt_2.setBounds(1130,160,170,40);
        txt_2.setEditable(false);
        txt_2.setText(studentCardNumber);
        txt_2.setForeground(Color.GRAY);
        contentPane.add(txt_2);

        JTextField txt_3=new JTextField();
        txt_3.setBounds(1130,220,170,40);
        txt_3.setEditable(false);
        txt_3.setText(studentGender);
        txt_3.setForeground(Color.GRAY);
        contentPane.add(txt_3);

        JTextField txt_4=new JTextField();
        txt_4.setBounds(1130,280,170,40);
        txt_4.setEditable(false);
        txt_4.setText(studentSchool);
        txt_4.setForeground(Color.GRAY);
        contentPane.add(txt_4);

        JTextField txt_5=new JTextField();
        txt_5.setBounds(1130,340,170,40);
        txt_5.setEditable(false);
        txt_5.setText(studentNumber);
        txt_5.setForeground(Color.GRAY);
        contentPane.add(txt_5);

        JTextField txt_6=new JTextField();
        txt_6.setBounds(1130,400,170,40);
        txt_6.setEditable(false);
        txt_6.setText(studentBankAccount);
        txt_6.setForeground(Color.GRAY);
        contentPane.add(txt_6);

        JTextField txt_7=new JTextField();
        txt_7.setBounds(1130,460,170,40);
        txt_7.setEditable(false);
        txt_7.setText(String.valueOf(studentBalance));
        txt_7.setForeground(Color.GRAY);
        contentPane.add(txt_7);

        JTextField txt_8=new JTextField();
        txt_8.setBounds(1130,520,170,40);
        txt_8.setEditable(false);
        txt_8.setText(studentPhoneNumber);
        txt_8.setForeground(Color.GRAY);
        contentPane.add(txt_8);

        JTextField txt_9=new JTextField();
        txt_9.setBounds(1130,580,170,40);
        txt_9.setEditable(false);
        txt_9.setText(studentEmail);
        txt_9.setForeground(Color.GRAY);
        contentPane.add(txt_9);

        JTextField txt_10=new JTextField();
        txt_10.setBounds(1130,640,170,40);
        txt_10.setEditable(false);
        txt_10.setText("输入重置密码");
        txt_10.setForeground(Color.GRAY);
        contentPane.add(txt_10);


        JLabel label = new JLabel("姓名：");
        label.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label.setOpaque(true);
        label.setForeground(new Color(19, 188, 210));
        label.setBackground(new Color(255,255,255,80));
        label.setBounds(945, 100, 100, 40);
        contentPane.add(label);

        JLabel label_1 = new JLabel("一卡通号：");
        label_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_1.setOpaque(true);
        label_1.setForeground(new Color(19, 188, 210));
        label_1.setBackground(new Color(255,255,255,80));
        label_1.setBounds(945, 160, 100, 40);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("性别：");
        label_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_2.setOpaque(true);
        label_2.setForeground(new Color(19, 188, 210));
        label_2.setBackground(new Color(255,255,255,80));
        label_2.setBounds(945, 220, 100, 40);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("学院：");
        label_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_3.setOpaque(true);
        label_3.setForeground(new Color(19, 188, 210));
        label_3.setBackground(new Color(255,255,255,80));
        label_3.setBounds(945, 280, 100, 40);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("学号：");
        label_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_4.setOpaque(true);
        label_4.setForeground(new Color(19, 188, 210));
        label_4.setBackground(new Color(255,255,255,80));
        label_4.setBounds(945, 340, 100, 40);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("银行账户：");
        label_5.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_5.setOpaque(true);
        label_5.setForeground(new Color(19, 188, 210));
        label_5.setBackground(new Color(255,255,255,80));
        label_5.setBounds(945, 400, 100, 40);
        contentPane.add(label_5);

        JLabel label_6 = new JLabel("账户存款：");
        label_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_6.setOpaque(true);
        label_6.setForeground(new Color(19, 188, 210));
        label_6.setBackground(new Color(255,255,255,80));
        label_6.setBounds(945, 460, 100, 40);
        contentPane.add(label_6);

        JLabel label_7 = new JLabel("电话：");
        label_7.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_7.setOpaque(true);
        label_7.setForeground(new Color(19, 188, 210));
        label_7.setBackground(new Color(255,255,255,80));
        label_7.setBounds(945, 520, 100, 40);
        contentPane.add(label_7);

        JLabel label_8 = new JLabel("邮箱：");
        label_8.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_8.setOpaque(true);
        label_8.setForeground(new Color(19, 188, 210));
        label_8.setBackground(new Color(255,255,255,80));
        label_8.setBounds(945, 580, 100, 40);
        contentPane.add(label_8);

        JLabel label_9 = new JLabel("登录密码：");
        label_9.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_9.setOpaque(true);
        label_9.setForeground(new Color(19, 188, 210));
        label_9.setBackground(new Color(255,255,255,80));
        label_9.setBounds(945, 640, 100, 40);
        contentPane.add(label_9);

        JLabel HeadPortrait= new JLabel(new ImageIcon(getClass().getResource("/resources/assets/Student/StuInfo.jpg")));
        HeadPortrait.setOpaque(true);
        HeadPortrait.setBorder(BorderFactory.createMatteBorder(8,8,8,8,
                new Color(255, 255, 255, 255)));
        HeadPortrait.setBounds(500, 90, 280, 280);
        contentPane.add(HeadPortrait);

        JLabel TransLabel = new JLabel("");//半透明效果
        TransLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel.setOpaque(true);
        TransLabel.setBackground(new Color(255,255,255,120));
        TransLabel.setBounds(220, 50, 602, 700);
        contentPane.add(TransLabel);//先添加的label在最上层

        JLabel TransLabel2 = new JLabel("");//半透明效果
        TransLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel2.setOpaque(true);
        TransLabel2.setBackground(new Color(255,255,255,70));
        TransLabel2.setBounds(1100, 98, 230, 585);
        contentPane.add(TransLabel2);//先添加的label在最上层

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/Student/StuInfo.jpg")));
        bg.setOpaque(true);
        bg.setBounds(220, 50, 600, 700);
        contentPane.add(bg);//背景

        JLabel underLabel= new JLabel();
        underLabel.setOpaque(true);
        underLabel.setForeground(new Color(33, 117, 206));
        underLabel.setBackground(new Color(34, 189, 176,50));
        underLabel.setBounds(880, 50, 500, 700);
        contentPane.add(underLabel);//总在最底层，代码段写在最后


        //事件响应
        //返回
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==returnButton)
                {
                    setVisible(false);
                }
            }
        });


        //启动编辑
        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置可编辑
                txt_8.setForeground(Color.BLACK);
                txt_8.setEditable(true);//电话
                txt_9.setForeground(Color.BLACK);
                txt_9.setEditable(true);//邮箱
                txt_10.setForeground(Color.BLACK);
                txt_10.setText("");
                txt_10.setEditable(true);//密码


            }
        });

        //保存
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txtStudentPhoneNumber = txt_8.getText().trim();//获取修改后的电话
                String txtStudentEmail = txt_9.getText().trim();//获取修改后的邮箱
                String txtStudentPassword = txt_10.getText().trim();//获取修改后的密码
                HashMap<String,String>mapCardNum_StudentPhoneNumber = new HashMap<String, String>();
                mapCardNum_StudentPhoneNumber.put("cardNumber", studentCardNumber);
                mapCardNum_StudentPhoneNumber.put("phoneNumber",txtStudentPhoneNumber);
                AppStudentInfoHelper.resetPhoneNumber(mapCardNum_StudentPhoneNumber);

                HashMap<String,String>mapCardNum_StudentEmail = new HashMap<String, String>();
                mapCardNum_StudentEmail.put("cardNumber", studentCardNumber);
                mapCardNum_StudentEmail.put("email",txtStudentEmail );
                AppStudentInfoHelper.resetEmail(mapCardNum_StudentEmail);

                HashMap<String,String>mapCardNum_StudentPassword = new HashMap<String, String>();
                mapCardNum_StudentPassword.put("cardNumber", studentCardNumber);
                System.out.println(StringUtils.MD5EncodeSalted(txtStudentPassword, ""));
                String tempStudentPassword=StringUtils.MD5EncodeSalted(txtStudentPassword, "");
                mapCardNum_StudentPassword.put("password", tempStudentPassword);
                //AppStudentInfoHelper.resetPassword(mapCardNum_StudentPassword);//会超时，待解决

               // txt_8.setText(App.session.getStudent().getPhoneNumber());
                txt_8.setForeground(Color.GRAY);
                txt_8.setEditable(false);//电话
              //  txt_9.setText(App.session.getStudent().getEmail());
                txt_9.setForeground(Color.GRAY);
                txt_9.setEditable(false);//邮箱
                txt_10.setForeground(Color.GRAY);
                txt_10.setEditable(false);//密码
                txt_10.setText("输入重置密码");

                txt_8.repaint();
                txt_9.repaint();
                txt_10.repaint();

                JOptionPane.showMessageDialog(null, "保存成功");

            }
        });


        //上传头像
        btnLoadPortrait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //读取图片  修改类型
                JFileChooser chooser = new JFileChooser();
                chooser.setSize(510, 327);
                chooser.setFileFilter(new FileNameExtensionFilter("JPG","jpg"));
                String imgPath = null;
                int returnVal = chooser.showOpenDialog(contentPane);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    imgPath = chooser.getSelectedFile().getAbsolutePath();
                }
                ByteArray byteArray = new ByteArray();
                byte[] imageData = null;
                try {
                    BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(image, "jpg", baos);
                    imageData = baos.toByteArray();
                    byteArray.setImageData(imageData);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                //发送图片信息
                MessageForImage senderMessage = new MessageForImage(studentCardNumber);
                senderMessage.setByteArray(byteArray);

                try {
                    MessageForImage messageBack =  new Client().start(senderMessage);
                    //更新界面的图片
                    HeadPortrait.setIcon(new ImageIcon(imgPath));
                    TransLabel.setText("");
                    bg.setIcon(new ImageIcon(imgPath));
                 //validate();
                 contentPane.repaint();//重新绘制实现刷新


                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });

    }

}
