package com.vcampus.client.main.manager;

import com.vcampus.client.LoginUI;
import com.vcampus.client.administrator.main.AppAdmin;
import com.vcampus.client.main.App;
import com.vcampus.entity.Student;
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
 * @date 2021-07-13
 */

public class StuManage extends JFrame{
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    private List<Student> list = null;
    private DefaultTableModel model;
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

        JTree jt=new ManCategory().getJTree();
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

        StudetailInfo Studetail=new StudetailInfo();
        Studetail.setBounds(210,610,800,200);
        Studetail.setVisible(false);
        contentPane.add(Studetail);

        JTextField txtfield1=new JTextField();    //创建文本框
        txtfield1.setText("输入学生姓名");
        txtfield1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        txtfield1.setBounds(210,50,300,30);
        contentPane.add(txtfield1);

        JButton addStu=new JButton("学生信息录入");
        addStu.setBounds(210,130,150,30);
        addStu.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        addStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studetail.initnow();
                Studetail.setVisible(true);
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
        contentPane.add(Stuserch);

        JLabel academylabel=new JLabel("Card");
        academylabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        academylabel.setBounds(250, 40, 50, 30);
        academylabel.setBorder(new EmptyBorder(0,0,0,0));
        Stuinforselect.add(academylabel);
        JTextField txtfield2=new JTextField();    //创建文本框
        txtfield2.setText("");
        txtfield2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        txtfield2.setBounds(300,40,150,30);
        Stuinforselect.add(txtfield2);

        JLabel classlabel=new JLabel("学院");
        classlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        classlabel.setBounds(250, 90, 50, 30);
        classlabel.setBorder(new EmptyBorder(0,0,0,0));
        Stuinforselect.add(classlabel);
        String[] recalltxt2={"","computer","ruanjian","science"};
        JComboBox Stuclass=new JComboBox(recalltxt2);
        Stuclass.setBounds(300,90,150,30);
        Stuinforselect.add(Stuclass);

        JLabel sexlabel=new JLabel("性别");
        sexlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        sexlabel.setBounds(250, 140, 50, 30);
        sexlabel.setBorder(new EmptyBorder(0,0,0,0));
        Stuinforselect.add(sexlabel);
        JComboBox sex=new JComboBox();
        String[] recalltxt3={"","man","woman"};
        for(String s :recalltxt3){
            sex.addItem(s);
        }
        sex.setBounds(300,140,150,30);
        Stuinforselect.add(sex);


        JLabel Stuinfor=new JLabel("学生信息：");
        Stuinfor.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Stuinfor.setBounds(210,260,100,30);
        contentPane.add(Stuinfor);

        String[] header = {"一卡通号", "姓名","性别","学院","学号","选择"};
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
        Stuserch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studetail.initnow();
                String txt1=txtfield1.getText();
                String txt2=txtfield2.getText();
                String txt3=Stuclass.getSelectedItem().toString();
                String txt4=sex.getSelectedItem().toString();
                list = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null,
                                "com.vcampus.server.StudentManage.ByNameAndCardAndSchoolAndGender",
                                new Object[] {txt1,txt2,txt3,txt4}).send())
                        .getListReturn(Student.class);
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
                        listData[i][4]=list.get(i).getStudentNumber();
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
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (column == 5) {
                    table.setValueAt("<html><font color='rgb(110,110,110)'>已选</font></html>", row, column);
                    Studetail.changeedit();
                    Studetail.init(table.getValueAt(row,0).toString());
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
