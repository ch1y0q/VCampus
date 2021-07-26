package com.vcampus.client.main.Manager;

import com.vcampus.client.LoginUI;
import com.vcampus.client.administrator.main.AppAdmin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Xiao Kaijie
 * @date 2021-07-13
 */

public class StuManage extends JFrame{
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

    public StuManage(){
        setResizable(true);
        setTitle("学生信息管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTree jt=new ManCategory().init();
        jt.setBounds(0,60,200,400);
        contentPane.add(jt);

        JButton back = new JButton("返回");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==back)
                {
                    AppAdmin app=new AppAdmin();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        back.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        back.setBounds(0, 20, 60, 30);
        contentPane.add(back);


        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + "XXX");
        tf.setBounds(1000, 20, 200, 30);
        tf.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(tf);

        JButton logout = new JButton(res.getString("logout"));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==logout)
                {
                    LoginUI app=new LoginUI();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        logout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        logout.setBounds(1330, 20, 60, 30);
        contentPane.add(logout);

        JTextField txtfield1=new JTextField();    //创建文本框
        txtfield1.setText("输入学生一卡通号或姓名");
        txtfield1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        txtfield1.setBounds(210,50,300,30);
        contentPane.add(txtfield1);

        JButton addStu=new JButton("学生信息录入");
        addStu.setBounds(210,130,150,30);
        addStu.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        addStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(addStu);

        JPanel Stuinforselect=new JPanel();
        Stuinforselect.setBounds(600,50,500,200);
        Stuinforselect.setLayout(null);
        contentPane.add(Stuinforselect);
        JLabel Stuse=new JLabel("学生信息筛选");
        Stuse.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Stuse.setBounds(0,0,300,30);
        Stuinforselect.add(Stuse);

        JButton Stuserch=new JButton("学生信息查询");
        Stuserch.setBounds(1100,80,150,30);
        Stuserch.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Stuserch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(Stuserch);

        JLabel academylabel=new JLabel("学院");
        academylabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        academylabel.setBounds(250, 40, 50, 30);
        academylabel.setBorder(new EmptyBorder(0,0,0,0));
        Stuinforselect.add(academylabel);
        JComboBox academy=new JComboBox();
        String[] recalltxt1={"","计算机科学与工程学院","网络安全学院","软件学院"};
        for(String s :recalltxt1){
            academy.addItem(s);
        }
        academy.setBounds(300,40,150,30);
        Stuinforselect.add(academy);

        JLabel classlabel=new JLabel("班级");
        classlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        classlabel.setBounds(250, 90, 50, 30);
        classlabel.setBorder(new EmptyBorder(0,0,0,0));
        Stuinforselect.add(classlabel);
        JComboBox Stuclass=new JComboBox();
        String[] recalltxt2={"","0901921","090192","090193"};
        for(String s :recalltxt2){
            Stuclass.addItem(s);
        }
        Stuclass.setBounds(300,90,150,30);
        Stuinforselect.add(Stuclass);

        JLabel sexlabel=new JLabel("性别");
        sexlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        sexlabel.setBounds(250, 140, 50, 30);
        sexlabel.setBorder(new EmptyBorder(0,0,0,0));
        Stuinforselect.add(sexlabel);
        JComboBox sex=new JComboBox();
        String[] recalltxt3={"","男","女"};
        for(String s :recalltxt3){
            sex.addItem(s);
        }
        sex.setBounds(300,140,150,30);
        Stuinforselect.add(sex);

        StudetailInfo Studetail=new StudetailInfo();
        Studetail.setBounds(210,610,800,180);
        Studetail.setVisible(false);
        contentPane.add(Studetail);

        JLabel Stuinfor=new JLabel("学生信息：");
        Stuinfor.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Stuinfor.setBounds(210,260,100,30);
        contentPane.add(Stuinfor);

        String[] header = {"一卡通号", "姓名","性别","学院","班级","选择"};
        String[][] data = {{"", "","","","",""}};
        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable table = new JTable(model)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                /**需增加
                 * 判断逻辑
                 */
                if (column == 5) {
                    table.setValueAt("<html><font color='rgb(110,110,110)'>已选</font></html>", row, column);
                    Studetail.setVisible(true);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setBounds(210, 300, 980, 300);
        contentPane.add(jScrollPane);

    }
}
