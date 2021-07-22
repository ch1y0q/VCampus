package com.vcampus.client.main;

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

/**
 * @author Xiao Kaijie
 * @date 2021-07-22
 */
public class TeaManage extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

    public TeaManage(){
        setResizable(true);
        setTitle("教师信息管理");
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
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back)
                {
                    setVisible(false);
                    //app.setVisible(true);
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

        JButton addTea=new JButton("教师信息录入");
        addTea.setBounds(210,130,150,30);
        addTea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        addTea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(addTea);

        JPanel Teainforselect=new JPanel();
        Teainforselect.setBounds(600,50,500,200);
        Teainforselect.setLayout(null);
        contentPane.add(Teainforselect);
        JLabel Tease=new JLabel("教师信息筛选");
        Tease.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Tease.setBounds(0,0,300,30);
        Teainforselect.add(Tease);

        JButton Teaserch=new JButton("教师信息查询");
        Teaserch.setBounds(1100,80,150,30);
        Teaserch.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaserch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(Teaserch);

        JLabel academylabel=new JLabel("学院");
        academylabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        academylabel.setBounds(250, 40, 50, 30);
        academylabel.setBorder(new EmptyBorder(0,0,0,0));
        Teainforselect.add(academylabel);
        JComboBox academy=new JComboBox();
        String[] recalltxt1={"","计算机科学与工程学院","网络安全学院","软件学院"};
        for(String s :recalltxt1){
            academy.addItem(s);
        }
        academy.setBounds(300,40,150,30);
        Teainforselect.add(academy);

        JLabel levellabel=new JLabel("职称");
        levellabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        levellabel.setBounds(250, 90, 50, 30);
        levellabel.setBorder(new EmptyBorder(0,0,0,0));
        Teainforselect.add(levellabel);
        JComboBox level=new JComboBox();
        String[] recalltxt2={"","讲师","副教授","教授"};
        for(String s :recalltxt2){
            level.addItem(s);
        }
        level.setBounds(300,90,150,30);
        Teainforselect.add(level);

        JLabel sexlabel=new JLabel("性别");
        sexlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        sexlabel.setBounds(250, 140, 50, 30);
        sexlabel.setBorder(new EmptyBorder(0,0,0,0));
        Teainforselect.add(sexlabel);
        JComboBox sex=new JComboBox();
        String[] recalltxt3={"","男","女"};
        for(String s :recalltxt3){
            sex.addItem(s);
        }
        sex.setBounds(300,140,150,30);
        Teainforselect.add(sex);

        JPanel Teadetail=new JPanel();
        Teadetail.setBackground(new Color(255, 255, 255));
        Teadetail.setBounds(210,610,800,180);
        Teadetail.setLayout(null);
        Teadetail.setVisible(false);
        contentPane.add(Teadetail);

        JLabel Teainfor=new JLabel("教师信息：");
        Teainfor.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teainfor.setBounds(210,260,100,30);
        contentPane.add(Teainfor);

        String[] header = {"一卡通号", "姓名","性别","学院","职称","选择"};
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
                    Teadetail.setVisible(true);
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
        Teadetail.add(detail);

        JLabel detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon());
        detailicon.setBounds(0,40,80,100);
        Teadetail.add(detailicon);

        JLabel Teaname=new JLabel("姓名");
        Teaname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaname.setBounds(100, 10, 80, 30);
        Teaname.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Teaname);
        JTextField txtname = new JTextField();    //创建文本框
        txtname.setText("姓名");
        txtname.setBounds(190, 10, 100, 30);
        Teadetail.add(txtname);
        JLabel cardnumber=new JLabel("一卡通号");
        cardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        cardnumber.setBounds(100, 40, 80, 30);
        cardnumber.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(cardnumber);
        JTextField txtcard = new JTextField();    //创建文本框
        txtcard.setText("一卡通号");
        txtcard.setBounds(190, 40, 100, 30);
        Teadetail.add(txtcard);
        JLabel Sex=new JLabel("性别");
        Sex.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Sex.setBounds(100,70 , 80, 30);
        Sex.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Sex);
        JTextField txtSex = new JTextField();    //创建文本框
        txtSex.setText("性别");
        txtSex.setBounds(190, 70, 100, 30);
        Teadetail.add(txtSex);
        JLabel Teaacademy=new JLabel("学院");
        Teaacademy.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaacademy.setBounds(100, 100, 80, 30);
        Teaacademy.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Teaacademy);
        JTextField txtacademy = new JTextField();    //创建文本框
        txtacademy.setText("学院");
        txtacademy.setBounds(190, 100, 100, 30);
        Teadetail.add(txtacademy);
        JLabel Tealevel=new JLabel("职称");
        Tealevel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Tealevel.setBounds(100, 130, 90, 30);
        Tealevel.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Tealevel);
        JTextField txtlevel = new JTextField();    //创建文本框
        txtlevel.setText("职称");
        txtlevel.setBounds(190, 130, 100, 30);
        Teadetail.add(txtlevel);
        JLabel bodynumber=new JLabel("身份证号");
        bodynumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bodynumber.setBounds(300, 10, 150, 30);
        bodynumber.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(bodynumber);
        JTextField txtbodynumber = new JTextField();    //创建文本框
        txtbodynumber.setText("身份证号");
        txtbodynumber.setBounds(460, 10, 100, 30);
        Teadetail.add(txtbodynumber);
        JLabel TeaBirth=new JLabel("出生日期");
        TeaBirth.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        TeaBirth.setBounds(300, 40, 150, 30);
        TeaBirth.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(TeaBirth);
        JTextField txtBirth = new JTextField();    //创建文本框
        txtBirth.setText("出生日期");
        txtBirth.setBounds(460, 40, 100, 30);
        Teadetail.add(txtBirth);
        JLabel Teaemail=new JLabel("邮箱");
        Teaemail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaemail.setBounds(300, 70, 150, 30);
        Teaemail.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Teaemail);
        JTextField txtemail = new JTextField();    //创建文本框
        txtemail.setText("邮箱");
        txtemail.setBounds(460, 70, 100, 30);
        Teadetail.add(txtemail);
        JLabel selfEntry=new JLabel("个人主页链接");
        selfEntry.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        selfEntry.setBounds(300, 100, 150, 30);
        selfEntry.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(selfEntry);
        JTextField txtEntry = new JTextField();    //创建文本框
        txtEntry.setText("个人主页链接");
        txtEntry.setBounds(460, 100, 100, 30);
        Teadetail.add(txtEntry);
        JLabel phone=new JLabel("电话");
        phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        phone.setBounds(300, 130, 150, 30);
        phone.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(phone);
        JTextField txtphone = new JTextField();    //创建文本框
        txtphone.setText("电话");
        txtphone.setBounds(460, 130, 100, 30);
        Teadetail.add(txtphone);

        JButton edit = new JButton("启动编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(600, 10, 200, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Teadetail.add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(600, 50, 200, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Teadetail.add(save);

        JButton Teadelete = new JButton("删除该条教师信息");
        Teadelete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teadelete.setBounds(600, 90, 200, 30);
        Teadelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Teadetail.add(Teadelete);
    }
}
