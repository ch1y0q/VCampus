package com.vcampus.client.administrator.main;

//import com.mysql.cj.xdevapi.Client;
import com.vcampus.client.main.manager.ManCategory;

        import javax.swing.*;
import javax.swing.border.EmptyBorder;
        import java.awt.*;
        import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 管理员个人信息界面
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class AppAdminInfo  extends JFrame {
    private JPanel contentPane;

    public AppAdminInfo() {
        setResizable(true);//允许窗口大小更改，建议不更改
        setTitle("个人信息管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(400, 200, 800, 550);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTree jt=new ManCategory().getJTree();
        jt.setBounds(0,60,200,400);
        contentPane.add(jt);

        JButton returnButton = new JButton("← 返回");
        returnButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        returnButton.setBounds(220,5,80,30);
        returnButton.setForeground(new Color(33, 117, 206,100));
        contentPane.add(returnButton);
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==returnButton)
                {
                    AppAdmin app=new AppAdmin();
                    //setVisible(false);
                    app.setVisible(true);
                }
            }
        });

        JButton LogoutButton = new JButton("登出");
        LogoutButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LogoutButton.setBounds(1450,5,50,30);
        LogoutButton.setForeground(new Color(33, 117, 206,100));
        contentPane.add(LogoutButton);

        JButton EditButton = new JButton("启动编辑");
        EditButton.setFont(new Font("微软雅黑", Font.BOLD, 17));
        EditButton.setBounds(1150,670,90,40);
        EditButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(EditButton);

        JButton btnLoadPortrait = new JButton("上传头像");
        btnLoadPortrait.setFont(new Font("微软雅黑", Font.BOLD, 14));
        btnLoadPortrait.setBounds(690,375,80,30);
        btnLoadPortrait.setForeground(new Color(58, 51, 168,100));
        contentPane.add(btnLoadPortrait);

//        btnLoadPortrait.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                //读取图片  修改类型
//                JFileChooser chooser = new JFileChooser();
//                chooser.setLocation(71, 36);
//                chooser.setSize(510, 327);
//
//                chooser.setFileFilter(new FileNameExtensionFilter("JPG","jpg"));
//                String imgPath = null;
//                int returnVal = chooser.showOpenDialog(contentPane);
//                if (returnVal == OnlyFileChooser.APPROVE_OPTION) {
//                    imgPath = chooser.getSelectedFile().getAbsolutePath();
//                }
//                ByteArray byteArray = new ByteArray();
//                byte[] imageData = null;
//                try {
//                    BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    ImageIO.write(image, "jpg", baos);
//                    imageData = baos.toByteArray();
//                    byteArray.setImageData(imageData);
//                } catch (FileNotFoundException e1) {
//                    e1.printStackTrace();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//                //发送图片信息
//                Message senderMessage = new Message(Card);
//                senderMessage.setByteArray(byteArray);
//                senderMessage.setType(1303);//上传照片
//                try {
//                    Message messageBack =  new Client().start(senderMessage);
//                    if (messageBack.getType() == 1101) {
//                        //更新界面的图片
//                        _image.setIcon(new ImageIcon(imgPath));
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Error：上传失败！〒_〒");
//                    }
//                } catch (ClassNotFoundException e1) {
//                    e1.printStackTrace();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });


        JButton SaveButton = new JButton("保存");
        SaveButton.setFont(new Font("微软雅黑", Font.BOLD, 17));
        SaveButton.setBounds(1270,670,60,40);
        SaveButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(SaveButton);

        //输入框
        JTextField txt_1=new JTextField();
        txt_1.setBounds(1130,100,170,40);
        contentPane.add(txt_1);
        JTextField txt_2=new JTextField();
        txt_2.setBounds(1130,160,170,40);
        contentPane.add(txt_2);
        JTextField txt_3=new JTextField();
        txt_3.setBounds(1130,220,170,40);
        contentPane.add(txt_3);
        JTextField txt_4=new JTextField();
        txt_4.setBounds(1130,280,170,40);
        contentPane.add(txt_4);
        JTextField txt_5=new JTextField();
        txt_5.setBounds(1130,340,170,40);
        contentPane.add(txt_5);
        JTextField txt_6=new JTextField();
        txt_6.setBounds(1130,400,170,40);
        contentPane.add(txt_6);
        JTextField txt_7=new JTextField();
        txt_7.setBounds(1130,460,170,40);
        contentPane.add(txt_7);

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

        JLabel label_3 = new JLabel("电子邮箱：");
        label_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_3.setOpaque(true);
        label_3.setForeground(new Color(19, 188, 210));
        label_3.setBackground(new Color(255,255,255,80));
        label_3.setBounds(945, 280, 100, 40);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("电话：");
        label_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_4.setOpaque(true);
        label_4.setForeground(new Color(19, 188, 210));
        label_4.setBackground(new Color(255,255,255,80));
        label_4.setBounds(945, 340, 100, 40);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("身份证号：");
        label_5.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_5.setOpaque(true);
        label_5.setForeground(new Color(19, 188, 210));
        label_5.setBackground(new Color(255,255,255,80));
        label_5.setBounds(945, 400, 100, 40);
        contentPane.add(label_5);

        JLabel label_6 = new JLabel("地址：");
        label_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_6.setOpaque(true);
        label_6.setForeground(new Color(19, 188, 210));
        label_6.setBackground(new Color(255,255,255,80));
        label_6.setBounds(945, 460, 100, 40);
        contentPane.add(label_6);

        JLabel HeadPortrait= new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/adminInfo1.jpg")));
        HeadPortrait.setOpaque(true);
        HeadPortrait.setBorder(BorderFactory.createMatteBorder(8,8,8,8,
                new Color(255, 255, 255, 255)));
        HeadPortrait.setBounds(500, 90, 280, 280);
        contentPane.add(HeadPortrait);

        JLabel TransLabel = new JLabel("");//半透明效果
        TransLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel.setOpaque(true);
        TransLabel.setBackground(new Color(255,255,255,100));
        TransLabel.setBounds(220, 50, 602, 700);
        contentPane.add(TransLabel);//先添加的label在最上层

        JLabel TransLabel2 = new JLabel("");//半透明效果
        TransLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel2.setOpaque(true);
        TransLabel2.setBackground(new Color(255,255,255,70));
        TransLabel2.setBounds(1100, 98, 230, 405);
        contentPane.add(TransLabel2);//先添加的label在最上层

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/adminInfo1.jpg")));
        bg.setOpaque(true);
        //bg.setForeground(new Color(255, 255, 255,100));
        bg.setBounds(220, 50, 600, 700);
        contentPane.add(bg);//背景

        JLabel underLabel= new JLabel();
        underLabel.setOpaque(true);
        underLabel.setForeground(new Color(33, 117, 206));
        //underLabel.setBackground(new Color(227, 145, 145,50));//这个颜色也很好看
        underLabel.setBackground(new Color(34, 189, 176,50));
        underLabel.setBounds(880, 50, 500, 700);
        contentPane.add(underLabel);//总在最底层，代码段写在最后


    }

}
