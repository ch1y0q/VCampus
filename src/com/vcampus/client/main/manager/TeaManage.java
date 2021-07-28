package com.vcampus.client.main.manager;

import com.vcampus.client.LoginUI;
import com.vcampus.client.administrator.main.AppAdmin;
import com.vcampus.client.main.App;
import com.vcampus.entity.Teacher;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Xiao Kaijie
 * @date 2021-07-22
 */
public class TeaManage extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    private List<Teacher> list = null;
    private DefaultTableModel model;
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
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        back.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        back.setBounds(0, 20, 60, 30);
        contentPane.add(back);


        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + App.session.getAdmin().getName());
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
        txtfield1.setText("输入教师姓名");
        txtfield1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        txtfield1.setBounds(210,50,300,30);
        contentPane.add(txtfield1);

        JButton addTea=new JButton("教师信息录入");
        addTea.setBounds(210,130,150,30);
        addTea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        TeaMandetailPanel Teadetail=new TeaMandetailPanel();
        addTea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addTea)
                {
                    Teadetail.initnow();
                    Teadetail.setVisible(true);
                }
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
        contentPane.add(Teaserch);

        JLabel academylabel=new JLabel("学院");
        academylabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        academylabel.setBounds(250, 40, 50, 30);
        academylabel.setBorder(new EmptyBorder(0,0,0,0));
        Teainforselect.add(academylabel);
        JComboBox academy=new JComboBox();
        String[] recalltxt1={"","computer","ruanjian","ai"};
        for(String s :recalltxt1){
            academy.addItem(s);
        }
        academy.setBounds(300,40,150,30);
        Teainforselect.add(academy);

        JLabel cardlabel=new JLabel("Card");
        cardlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        cardlabel.setBounds(250, 90, 50, 30);
        cardlabel.setBorder(new EmptyBorder(0,0,0,0));
        Teainforselect.add(cardlabel);
        JTextField cardNum=new JTextField();
        cardNum.setBounds(300,90,150,30);
        Teainforselect.add(cardNum);

        JLabel sexlabel=new JLabel("性别");
        sexlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        sexlabel.setBounds(250, 140, 50, 30);
        sexlabel.setBorder(new EmptyBorder(0,0,0,0));
        Teainforselect.add(sexlabel);
        JComboBox sex=new JComboBox();
        String[] recalltxt3={"","man","woman"};
        for(String s :recalltxt3){
            sex.addItem(s);
        }
        sex.setBounds(300,140,150,30);
        Teainforselect.add(sex);

        Teadetail.setBackground(new Color(255, 255, 255));
        Teadetail.setBounds(210,610,800,180);
        Teadetail.setVisible(false);
        contentPane.add(Teadetail);

        JLabel Teainfor=new JLabel("教师信息：");
        Teainfor.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teainfor.setBounds(210,260,100,30);
        contentPane.add(Teainfor);

        String[] header = {"一卡通号", "姓名","性别","学院","职称","选择"};
        model = new DefaultTableModel(null,header);
        JTable table = new JTable(model)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        Teaserch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Teaserch)
                {
                    Teadetail.initnow();
                    String txt1=txtfield1.getText();
                    String txt2=cardNum.getText();
                    String txt3=academy.getSelectedItem().toString();
                    String txt4=sex.getSelectedItem().toString();
                    list = ResponseUtils
                            .getResponseByHash(new Request(App.connectionToServer, null,
                                    "com.vcampus.server.TeacherManage.ByNameAndCardAndSchoolAndGender",
                                    new Object[] {txt1,txt2,txt3,txt4}).send())
                            .getListReturn(Teacher.class);
                    String[][] listData = new String[list.size()][6];
                    if (list == null || list.size() == 0) {
                        System.out.println("error");
                        model.setRowCount(0);
                        table.setModel(model);
                    } else {
                        model.setRowCount(0);
                        int len = list.size();
                        for (int i = 0; i < len; i++) {
                            listData[i][0]=list.get(i).getCardNumber();
                            listData[i][1]=list.get(i).getName();
                            listData[i][2]=list.get(i).getGender();
                            listData[i][3]=list.get(i).getSchool();
                            listData[i][4]=list.get(i).getTeacherRank();
                            listData[i][5]="<html><font color='rgb(110,110,110)'>查看</font></html>";
                        }
                        model = new DefaultTableModel(listData, header){
                            public boolean isCellEditable(int a, int b) {
                                return false;
                            }
                        };
                        table.setModel(model);
                    }
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (column == 5) {
                    table.setValueAt("<html><font color='rgb(110,110,110)'>已选</font></html>", row, column);
                    Teadetail.changeedit();
                    Teadetail.init(table.getValueAt(row,0).toString());
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
    }
}
