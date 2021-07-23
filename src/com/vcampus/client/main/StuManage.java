package com.vcampus.client.main;

import com.vcampus.client.administrator.main.AppAdmin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

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

        DefaultMutableTreeNode nodLogin= new DefaultMutableTreeNode("管理员登陆");
        DefaultMutableTreeNode nodInfor = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode nodClassManage = new DefaultMutableTreeNode("课程管理");
        DefaultMutableTreeNode nodLibrary = new DefaultMutableTreeNode("图书馆");
        DefaultMutableTreeNode nodDorm = new DefaultMutableTreeNode("一卡通");
        DefaultMutableTreeNode nodShop = new DefaultMutableTreeNode(   "网上商店");
        nodLogin.add(nodInfor);nodLogin.add(nodClassManage);nodLogin.add(nodLibrary);nodLogin.add(nodDorm);nodLogin.add(nodShop);

        DefaultMutableTreeNode nodGoods = new DefaultMutableTreeNode("商品列表");
        DefaultMutableTreeNode nodShopCart = new DefaultMutableTreeNode("购物车");
        DefaultMutableTreeNode nodBuyHistory = new DefaultMutableTreeNode("购买历史");
        nodShop.add(nodGoods);nodShop.add(nodShopCart);nodShop.add(nodBuyHistory);

        JTree jt = new JTree(nodLogin);
        jt.setBounds(0,50,200,600);
        contentPane.add(jt);

        TreeSelectionModel treeSelectionModel;
        treeSelectionModel=jt.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!jt.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                    String name = node.toString();
                    System.out.println(name);
                }
            }
        });

        JButton back = new JButton("返回");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==back)
                {
                    AppAdmin app=new AppAdmin();
                    //setVisible(false);
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
            }
        });
        logout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        logout.setBounds(1330, 20, 60, 30);
        contentPane.add(logout);

        JTextField txtfield1=new JTextField();    //创建文本框
        txtfield1.setText("输入教师一卡通号或姓名");
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

        JPanel Studetail=new JPanel();
        Studetail.setBackground(new Color(255, 255, 255));
        Studetail.setBounds(210,610,800,180);
        Studetail.setLayout(null);
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


        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(0, 0, 80, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(detail);

        JLabel detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon());
        detailicon.setBounds(0,40,80,100);
        Studetail.add(detailicon);

        JLabel Teaname=new JLabel("姓名");
        Teaname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaname.setBounds(100, 10, 80, 30);
        Teaname.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(Teaname);
        JTextField txtname = new JTextField();    //创建文本框
        txtname.setText("姓名");
        txtname.setBounds(190, 10, 100, 30);
        Studetail.add(txtname);
        JLabel cardnumber=new JLabel("一卡通号");
        cardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        cardnumber.setBounds(100, 40, 80, 30);
        cardnumber.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(cardnumber);
        JTextField txtcard = new JTextField();    //创建文本框
        txtcard.setText("一卡通号");
        txtcard.setBounds(190, 40, 100, 30);
        Studetail.add(txtcard);
        JLabel Sex=new JLabel("性别");
        Sex.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Sex.setBounds(100,70 , 80, 30);
        Sex.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(Sex);
        JTextField txtSex = new JTextField();    //创建文本框
        txtSex.setText("性别");
        txtSex.setBounds(190, 70, 100, 30);
        Studetail.add(txtSex);
        JLabel Teaacademy=new JLabel("学院");
        Teaacademy.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaacademy.setBounds(100, 100, 80, 30);
        Teaacademy.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(Teaacademy);
        JTextField txtacademy = new JTextField();    //创建文本框
        txtacademy.setText("学院");
        txtacademy.setBounds(190, 100, 100, 30);
        Studetail.add(txtacademy);
        JLabel Stunumber=new JLabel("学号");
        Stunumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Stunumber.setBounds(100, 130, 90, 30);
        Stunumber.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(Stunumber);
        JTextField Stunum = new JTextField();    //创建文本框
        Stunum.setText("学号");
        Stunum.setBounds(190, 130, 100, 30);
        Studetail.add(Stunum);
        JLabel StuClass=new JLabel("班级");
        StuClass.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        StuClass.setBounds(100, 160, 90, 30);
        StuClass.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(StuClass);
        JTextField StuClass1 = new JTextField();    //创建文本框
        StuClass1.setText("班级");
        StuClass1.setBounds(190, 160, 100, 30);
        Studetail.add(StuClass1);
        JLabel bodynumber=new JLabel("身份证号");
        bodynumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bodynumber.setBounds(300, 10, 150, 30);
        bodynumber.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(bodynumber);
        JTextField txtbodynumber = new JTextField();    //创建文本框
        txtbodynumber.setText("身份证号");
        txtbodynumber.setBounds(460, 10, 100, 30);
        Studetail.add(txtbodynumber);
        JLabel TeaBirth=new JLabel("出生日期");
        TeaBirth.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        TeaBirth.setBounds(300, 40, 150, 30);
        TeaBirth.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(TeaBirth);
        JTextField txtBirth = new JTextField();    //创建文本框
        txtBirth.setText("出生日期");
        txtBirth.setBounds(460, 40, 100, 30);
        Studetail.add(txtBirth);
        JLabel Teaemail=new JLabel("邮箱");
        Teaemail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaemail.setBounds(300, 70, 150, 30);
        Teaemail.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(Teaemail);
        JTextField txtemail = new JTextField();    //创建文本框
        txtemail.setText("邮箱");
        txtemail.setBounds(460, 70, 100, 30);
        Studetail.add(txtemail);
        JLabel zhuanye=new JLabel("专业");
        zhuanye.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        zhuanye.setBounds(300, 100, 150, 30);
        zhuanye.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(zhuanye);
        JTextField txtEntry = new JTextField();    //创建文本框
        txtEntry.setText("专业");
        txtEntry.setBounds(460, 100, 100, 30);
        Studetail.add(txtEntry);
        JLabel phone=new JLabel("电话");
        phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        phone.setBounds(300, 130, 150, 30);
        phone.setBorder(new EmptyBorder(0,0,0,0));
        Studetail.add(phone);
        JTextField txtphone = new JTextField();    //创建文本框
        txtphone.setText("电话");
        txtphone.setBounds(460, 130, 100, 30);
        Studetail.add(txtphone);

        JButton edit = new JButton("启动编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(600, 10, 200, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Studetail.add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(600, 50, 200, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        Studetail.add(save);

        JButton Teadelete = new JButton("删除该条教师信息");
        Teadelete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teadelete.setBounds(600, 90, 200, 30);
        Teadelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        Studetail.add(Teadelete);
    }
}
