package com.vcampus.client.main;

import com.vcampus.client.main.manager.AppAdmin;
import com.vcampus.client.main.manager.ManCategory;
import com.vcampus.entity.RepairHistory;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author Y
 * @date 2021/7/22
 */

public class AppDormAdmin extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2;
    public List<RepairHistory> list=null;
    public DefaultTableModel defaultTableModel;
    public String[][] listData=null;
    public AppDormAdmin(){
        setResizable(false);
        setTitle("宿舍管理 - Vcampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        jp1=new JPanel();
        jp2=new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /*JTree jt=new ManCategory().getJTree();
        jt.setBackground(new Color(240, 255, 240));
        jt.setBounds(0,60,200,400);
        contentPane.add(jt);


         */
        jp1.setLayout(null);
        jp1.setBackground(new Color(240, 255, 240));
        jp2.setLayout(null);
        jp2.setBackground(new Color(240, 255, 240));

        tabbedPane = new JTabbedPane();
        tabbedPane.add("宿舍信息管理",jp1);
        tabbedPane.add("宿舍报修处理",jp2);
        tabbedPane.setBounds(0,0,2000,1100);
        this.add(tabbedPane);

        JButton btnBack = new JButton("返回");
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==btnBack)
                {
                    AppAdmin app=new AppAdmin();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack.setBounds(1250, 30, 100, 40);
        jp1.add(btnBack);

        JLabel lblDormHygieneMarkEntering = new JLabel("宿舍卫生分数录入");
        lblDormHygieneMarkEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneMarkEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneMarkEntering.setBounds(230, 120, 250, 40);
        jp1.add(lblDormHygieneMarkEntering);

        JComboBox cmbDormHygieneMarkWeek=new JComboBox();
        for(int i=1;i<17;i++) {
            cmbDormHygieneMarkWeek.addItem("第"+i+"周");
        }
        cmbDormHygieneMarkWeek.setBounds(450,117,100,30);
        jp1.add(cmbDormHygieneMarkWeek);

        JLabel lblDormHygieneMarkEnteringDormAddress = new JLabel("宿舍号");
        lblDormHygieneMarkEnteringDormAddress.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneMarkEnteringDormAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneMarkEnteringDormAddress.setBounds(230, 190, 250, 40);
        jp1.add(lblDormHygieneMarkEnteringDormAddress);

        JTextField txtDormHygieneRateEnteringDormAddress = new JTextField();
        txtDormHygieneRateEnteringDormAddress.setBounds(450, 196, 100, 30);
        jp1.add(txtDormHygieneRateEnteringDormAddress);

        JTable tblDormHygieneMark=new JTable(2,3);
        tblDormHygieneMark.setBounds(210,350,400,100);
        tblDormHygieneMark.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblDormHygieneMark.setRowHeight(50);
        tblDormHygieneMark.getModel().setValueAt("宿舍号",0,0);
        tblDormHygieneMark.getModel().setValueAt("分数",0,1);
        tblDormHygieneMark.getModel().setValueAt("周数",0,2);
        DefaultTableCellRenderer rHygieneMark =new DefaultTableCellRenderer();
        rHygieneMark.setHorizontalAlignment(JLabel.CENTER);
        tblDormHygieneMark.setDefaultRenderer(Object.class,rHygieneMark);
        jp1.add(tblDormHygieneMark);

        JButton btnDormHygieneRateLookUp = new JButton("查询");
        btnDormHygieneRateLookUp.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnDormHygieneRateLookUp.setBounds(370, 267, 100, 30);
        btnDormHygieneRateLookUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dormAddress = txtDormHygieneRateEnteringDormAddress.getText();
                String weekText=cmbDormHygieneMarkWeek.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",dormAddress);
                map.put("weekNo",weekNo);

                int hygieneMark;
                hygieneMark= ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getDormHygieneMark",
                                new Object[]{map}).send())
                        .getReturn(Integer.class);

                tblDormHygieneMark.getModel().setValueAt(dormAddress,1,0);
                tblDormHygieneMark.getModel().setValueAt(hygieneMark,1,1);
                tblDormHygieneMark.getModel().setValueAt(weekNo,1,2);
            }
        });
        jp1.add(btnDormHygieneRateLookUp);

        
        JLabel lblDormHygieneMarkEnteringMark = new JLabel("分数");
        lblDormHygieneMarkEnteringMark.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneMarkEnteringMark.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneMarkEnteringMark.setBounds(180, 510, 250, 40);
        jp1.add(lblDormHygieneMarkEnteringMark);

        JTextField txtDormHygieneRateEnteringMark = new JTextField();
        txtDormHygieneRateEnteringMark.setBounds(355, 516, 90, 30);
        jp1.add(txtDormHygieneRateEnteringMark);

        JButton btnDormHygieneRateEntering = new JButton("录入");
        btnDormHygieneRateEntering.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnDormHygieneRateEntering.setBounds(480, 516, 100, 30);
        btnDormHygieneRateEntering.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dormAddress = txtDormHygieneRateEnteringDormAddress.getText();
                String weekText=cmbDormHygieneMarkWeek.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));
                String dormHygieneMark = txtDormHygieneRateEnteringMark.getText();

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",dormAddress);
                map.put("weekNo",weekNo);
                map.put("hygieneMark",dormHygieneMark);

                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.setDormHygieneMark",
                                new Object[]{map}).send())
                        .getReturn(Boolean.class);
            }
        });
        jp1.add(btnDormHygieneRateEntering);







        JLabel lblDormBillEntering = new JLabel("宿舍水电费录入");
        lblDormBillEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormBillEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormBillEntering.setBounds(830, 120, 250, 40);
        jp1.add(lblDormBillEntering);

        JComboBox cmbDormBill=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormBill.addItem("第"+i+"月");
        }
        cmbDormBill.setBounds(1050,127,100,30);
        jp1.add(cmbDormBill);

        JLabel lblDormWaterElectricityRateEnteringDormAddress = new JLabel("宿舍号");
        lblDormWaterElectricityRateEnteringDormAddress.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormWaterElectricityRateEnteringDormAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterElectricityRateEnteringDormAddress.setBounds(830, 190, 250, 40);
        jp1.add(lblDormWaterElectricityRateEnteringDormAddress);

        JTextField txtDormWaterElectricityRateEnteringDormAddress = new JTextField();
        txtDormWaterElectricityRateEnteringDormAddress.setBounds(1050, 196, 100, 30);
        jp1.add(txtDormWaterElectricityRateEnteringDormAddress);

        JTable tblDormBill=new JTable(2,4);
        tblDormBill.setBounds(750,350,600,100);
        tblDormBill.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblDormBill.setRowHeight(50);
        tblDormBill.getModel().setValueAt("宿舍号",0,0);
        tblDormBill.getModel().setValueAt("水费",0,1);
        tblDormBill.getModel().setValueAt("电费",0,2);
        tblDormBill.getModel().setValueAt("月份",0,3);
        DefaultTableCellRenderer rDormBill =new DefaultTableCellRenderer();
        rDormBill.setHorizontalAlignment(JLabel.CENTER);
        tblDormBill.setDefaultRenderer(Object.class,rDormBill);
        jp1.add(tblDormBill);

        JButton btnDormWaterElectricityRateLookUp = new JButton("查询");
        btnDormWaterElectricityRateLookUp.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnDormWaterElectricityRateLookUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dormAddress = txtDormWaterElectricityRateEnteringDormAddress.getText();
                String weekText=cmbDormBill.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",dormAddress);
                map.put("weekNo",weekNo);

                BigDecimal waterRate;
                waterRate=ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getDormWaterRate",
                                new Object[]{map}).send())
                        .getReturn(BigDecimal.class);

                BigDecimal electricityRate;
                electricityRate=ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getDormElectricityRate",
                                new Object[]{map}).send())
                        .getReturn(BigDecimal.class);

                tblDormBill.getModel().setValueAt(dormAddress,1,0);
                tblDormBill.getModel().setValueAt(waterRate,1,1);
                tblDormBill.getModel().setValueAt(electricityRate,1,2);
                tblDormBill.getModel().setValueAt(weekNo,1,3);
            }
        });
        jp1.add(btnDormWaterElectricityRateLookUp);
        btnDormWaterElectricityRateLookUp.setBounds(970, 267, 100, 30);


        JLabel lblDormWaterRateEntering = new JLabel("水费");
        lblDormWaterRateEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormWaterRateEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterRateEntering.setBounds(780, 510, 250, 40);
        jp1.add(lblDormWaterRateEntering);

        JTextField txtDormWaterRateEntering = new JTextField();
        txtDormWaterRateEntering.setBounds(955, 516, 90, 30);
        jp1.add(txtDormWaterRateEntering);

        JButton btnDormWaterRateEntering = new JButton("录入");
        btnDormWaterRateEntering.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnDormWaterRateEntering.setBounds(1080, 516, 100, 30);
        btnDormWaterRateEntering.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dormAddress = txtDormWaterElectricityRateEnteringDormAddress.getText();
                String weekText=cmbDormBill.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));
                String waterRate=txtDormWaterRateEntering.getText();

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",dormAddress);
                map.put("weekNo",weekNo);
                map.put("waterCost",waterRate);

                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.setDormWaterRate",
                                new Object[]{map}).send())
                        .getReturn(Boolean.class);

            }
        });
        jp1.add(btnDormWaterRateEntering);

        JLabel lblDormElectricityRateEntering = new JLabel("电费");
        lblDormElectricityRateEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormElectricityRateEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormElectricityRateEntering.setBounds(780, 570, 250, 40);
        jp1.add(lblDormElectricityRateEntering);

        JTextField txtDormElectricityRateEntering = new JTextField();
        txtDormElectricityRateEntering.setBounds(955, 576, 90, 30);
        jp1.add(txtDormElectricityRateEntering);

        JButton btnDormElectricityRateEntering = new JButton("录入");
        btnDormElectricityRateEntering.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnDormElectricityRateEntering.setBounds(1080, 576, 100, 30);
        btnDormElectricityRateEntering.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dormAddress = txtDormWaterElectricityRateEnteringDormAddress.getText();
                String weekText=cmbDormBill.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));
                String electricityRate=txtDormElectricityRateEntering.getText();

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",dormAddress);
                map.put("weekNo",weekNo);
                map.put("electricityCost",electricityRate);

                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.setDormElectricityRate",
                                new Object[]{map}).send())
                        .getReturn(Boolean.class);

            }
        });
        jp1.add(btnDormElectricityRateEntering);


        //jp1结束

        JButton btnBack2 = new JButton("返回");
        btnBack2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==btnBack2)
                {
                    AppAdmin app=new AppAdmin();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        btnBack2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack2.setBounds(1250, 30, 100, 40);
        jp2.add(btnBack2);

        JLabel lblDormRepairStateUpdateDormAddress = new JLabel("宿舍号");
        lblDormRepairStateUpdateDormAddress.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairStateUpdateDormAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairStateUpdateDormAddress.setBounds(340, 100, 450, 40);
        jp2.add(lblDormRepairStateUpdateDormAddress);

        JTextField txtDormRepairStateUpdateDormAddress = new JTextField();
        txtDormRepairStateUpdateDormAddress.setBounds(645, 106, 90, 30);
        jp2.add(txtDormRepairStateUpdateDormAddress);

        String[] head={"宿舍号","报修时间","报修内容","报修状态"};
        defaultTableModel = new DefaultTableModel(null,head);

        JTable tblDormRepairState=new JTable(6,4);
        tblDormRepairState.setModel(defaultTableModel);
        tblDormRepairState.setBounds(340,200,800,300);
        tblDormRepairState.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblDormRepairState.setRowHeight(50);
        DefaultTableCellRenderer rDormRepairState =new DefaultTableCellRenderer();
        rDormRepairState.setHorizontalAlignment(JLabel.CENTER);
        tblDormRepairState.setDefaultRenderer(Object.class,rDormRepairState);
        jp2.add(tblDormRepairState);


        JButton btnDormRepairStatusLookUp = new JButton("查询");
        btnDormRepairStatusLookUp.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnDormRepairStatusLookUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getRepairHistory",
                                new Object[]{txtDormRepairStateUpdateDormAddress.getText()}).send())
                        .getListReturn(RepairHistory.class);

                defaultTableModel.setRowCount(0);
                if(list==null){
                    listData=new String[1][4];
                    listData[0][0]="无报修记录...";
                    listData[0][1]=listData[0][2]=listData[0][3]="";
                }
                else{
                    listData=new String[list.size()][4];
                    for(int i=0;i<list.size();i++)
                    {
                        listData[i][0]=txtDormRepairStateUpdateDormAddress.getText();
                        listData[i][1]=list.get(i).reportTime;
                        listData[i][2]=list.get(i).reportContent;
                        String repairStatusEnglish=list.get(i).repairStatus;
                        String repairStatusChinese="ERROR";
                        if(repairStatusEnglish.equals("TODO"))
                            repairStatusChinese="待修理";
                        else if (repairStatusEnglish.equals("DONE"))
                            repairStatusChinese="已修理";
                        listData[i][3]=repairStatusChinese;
                    }
                }
                defaultTableModel=new DefaultTableModel(listData,head){
                    @Override
                    public boolean isCellEditable(int a,int b){return false;}
                };
                tblDormRepairState.setModel(defaultTableModel);

            }
        });
        jp2.add(btnDormRepairStatusLookUp);
        btnDormRepairStatusLookUp.setBounds(870, 106, 100, 30);

        JLabel lblDormRepairStateUpdate = new JLabel("修改表中第                          条的报修状态为");
        lblDormRepairStateUpdate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairStateUpdate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairStateUpdate.setBounds(350, 570, 450, 40);
        jp2.add(lblDormRepairStateUpdate);

        JTextField txtDormRepairStateUpdateNoSelect = new JTextField();
        txtDormRepairStateUpdateNoSelect.setBounds(515, 576, 90, 30);
        jp2.add(txtDormRepairStateUpdateNoSelect);

        JComboBox cmbDormRepairStatus=new JComboBox();
        cmbDormRepairStatus.addItem("已修理");
        cmbDormRepairStatus.addItem("待修理");
        cmbDormRepairStatus.setBounds(790,576,100,30);
        jp2.add(cmbDormRepairStatus);

        JButton btnDormRepairStatusUpdate = new JButton("确认");
        btnDormRepairStatusUpdate.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnDormRepairStatusUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getRepairHistory",
                                new Object[]{txtDormRepairStateUpdateDormAddress.getText()}).send())
                        .getListReturn(RepairHistory.class);

                defaultTableModel.setRowCount(0);
                if(list==null){
                    listData=new String[1][4];
                    listData[0][0]="无报修记录...";
                    listData[0][1]=listData[0][2]=listData[0][3]="";
                }
                else{
                    listData=new String[list.size()][4];
                    for(int i=0;i<list.size();i++)
                    {
                        listData[i][0]=txtDormRepairStateUpdateDormAddress.getText();
                        listData[i][1]=list.get(i).reportTime;
                        listData[i][2]=list.get(i).reportContent;
                        String repairStatusEnglish=list.get(i).repairStatus;
                        String repairStatusChinese="ERROR";
                        if(repairStatusEnglish.equals("TODO"))
                            repairStatusChinese="待修理";
                        else if (repairStatusEnglish.equals("DONE"))
                            repairStatusChinese="已修理";
                        listData[i][3]=repairStatusChinese;
                    }
                }

                defaultTableModel=new DefaultTableModel(listData,head){
                    @Override
                    public boolean isCellEditable(int a,int b){return false;}
                };
                tblDormRepairState.setModel(defaultTableModel);

                int lineNo=Integer.valueOf(txtDormRepairStateUpdateNoSelect.getText());
                String reportTime=listData[lineNo-1][1];

                String statusToUpdate=cmbDormRepairStatus.getSelectedItem().toString();
                String statusToUpdateEng="ERROR";
                if(statusToUpdate.equals("待修理"))
                    statusToUpdateEng="TODO";
                else if(statusToUpdate.equals("已修理"))
                    statusToUpdateEng="DONE";

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("repairStatus",statusToUpdateEng);
                map.put("reportTime",reportTime);

                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.setRepairHistoryStatus",
                                new Object[]{map}).send())
                        .getListReturn(Boolean.class);

            }
        });
        jp2.add(btnDormRepairStatusUpdate);
        btnDormRepairStatusUpdate.setBounds(970, 576, 100, 30);
    }
}
