package com.vcampus.client.main;

//import com.vcampus.client.main.student.AppStudent;
import com.vcampus.client.main.student.AppStudent;
import com.vcampus.client.main.student.StuCategory;
import com.vcampus.entity.DealHistory;
import com.vcampus.entity.RepairHistory;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;
import com.vcampus.util.StringUtils;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

/**
 * @author Y
 * @date 2021/7/21
 * 学生生活服务界面
 */

public class AppLife extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1, jp2;
    public List<DealHistory> listDealHistory =null;
    public DefaultTableModel modelDealHistory;

    public List<RepairHistory> listRepairHistory =null;
    public DefaultTableModel modelRepairHistory;

    public AppLife() {

        /**
         * 以下是获取必要参数方便使用
         * 使用AppLifeHelper和直接使用ResponseUtils.效果实际相同
         */

        String studentCardNumber;
        studentCardNumber = App.session.getStudent().getCardNumber();

        String studentBankAccount;
        studentBankAccount = App.session.getStudent().getBankAccount();

        String studentDormAddress;
        studentDormAddress = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getDormAddress",
                        new Object[]{studentCardNumber}).send())
                .getReturn(String.class);


        String lossJudge;
        lossJudge=App.session.getStudent().getLossStatus();
        String lossJudgeChinese="ERROR";
        if(lossJudge.equals("LOST"))
            lossJudgeChinese="挂失";
        else if(lossJudge.equals("NORMAL"))
            lossJudgeChinese="正常";

        String studentBankAccountPassword=
                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getBankAccountPassword",
                                new Object[]{studentCardNumber}).send())
                        .getReturn(String.class);

        String studentBankAccountPasswordSalt=
                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getBankAccountPasswordSalt",
                                new Object[]{studentCardNumber}).send())
                        .getReturn(String.class);


        /**
         * 获取参数结束
         * 以下是面板设置
         */

        setResizable(true);
        setTitle("生活服务 - Vcampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
        jp1.setBackground(new Color(240, 255, 240));
        jp2.setLayout(null);
        jp2.setBackground(new Color(240, 255, 240));

        tabbedPane = new JTabbedPane();
        tabbedPane.add("一卡通", jp1);
        tabbedPane.add("宿舍", jp2);
        tabbedPane.setBounds(0, 0, 2000, 1100);
        this.add(tabbedPane);
        //选项卡面板

        /**
         * @deprecated 旧目录
         */
        /*JTree jt = new StuCategory().getJTree();
        jt.setBackground(new Color(240, 255, 240));
        jt.setBounds(0, 50, 200, 600);
        contentPane.add(jt);

         */

        //一卡通部分开始 - jp1

        JButton btnBack = new JButton("返回");
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==btnBack)
                {
                    AppStudent app=new AppStudent();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack.setBounds(1250, 30, 100, 40);
        jp1.add(btnBack);
        //返回按钮

        JLabel lblCardNum = new JLabel("一卡通号");
        lblCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardNum.setBounds(155, 30, 100, 40);
        jp1.add(lblCardNum);

        JLabel lblCurCardNum = new JLabel(studentCardNumber);
        lblCurCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardNum.setBounds(255, 30, 100, 40);
        jp1.add(lblCurCardNum);

        JLabel lblCardStatus = new JLabel("一卡通状态");
        lblCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardStatus.setBounds(370, 30, 100, 40);
        jp1.add(lblCardStatus);

        JLabel lblCurCardStatus = new JLabel(lossJudgeChinese);
        lblCurCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardStatus.setBounds(450, 30, 100, 40);
        jp1.add(lblCurCardStatus);

        JLabel lblCardBalance = new JLabel("一卡通余额");
        lblCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardBalance.setBounds(560, 30, 100, 40);
        jp1.add(lblCardBalance);

        JLabel lblCurCardBalance = new JLabel(App.session.getStudent().getBalance().toString());
        lblCurCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardBalance.setBounds(650, 30, 100, 40);
        jp1.add(lblCurCardBalance);

        JLabel lblCardOp = new JLabel("一卡通业务");
        lblCardOp.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardOp.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardOp.setBounds(400, 130, 100, 40);
        jp1.add(lblCardOp);

        //基础信息显示


        JLabel lblCardRecharge = new JLabel("一卡通充值");
        lblCardRecharge.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRecharge.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRecharge.setBounds(185, 210, 100, 40);
        jp1.add(lblCardRecharge);

        JLabel lblCardRechargeBankAccount = new JLabel("绑定的银行账号");
        lblCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeBankAccount.setBounds(290, 210, 150, 40);
        jp1.add(lblCardRechargeBankAccount);

        JLabel lblCurCardRechargeBankAccount = new JLabel(studentBankAccount);
        lblCurCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardRechargeBankAccount.setBounds(450, 210, 200, 40);
        jp1.add(lblCurCardRechargeBankAccount);

        JLabel lblCardRechargeBankAccountPassword = new JLabel("银行账号密码");
        lblCardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeBankAccountPassword.setBounds(290, 260, 150, 40);
        jp1.add(lblCardRechargeBankAccountPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setText("");
        txtPassword.setBounds(465, 267, 160, 30);
        jp1.add(txtPassword);

        JLabel lblCardRechargeAmount = new JLabel("充值金额");
        lblCardRechargeAmount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeAmount.setBounds(290, 310, 150, 40);
        jp1.add(lblCardRechargeAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setText("");
        txtAmount.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        txtAmount.setBounds(465, 317, 160, 30);
        jp1.add(txtAmount);

        //充值相关的部件布局。由于充值功能需要刷新交易记录表格，故实现功能的按钮放于后部分。



        JLabel lblCardLossReport = new JLabel("一卡通挂失");
        lblCardLossReport.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardLossReport.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardLossReport.setBounds(185, 500, 100, 40);
        jp1.add(lblCardLossReport);

        JTextField txtLossReport = new JTextField();
        txtLossReport.setText("挂失说明（非必要）");
        txtLossReport.setFont((new Font("微软雅黑", Font.PLAIN, 14)));
        txtLossReport.setBounds(315, 507, 160, 30);
        jp1.add(txtLossReport);

        JButton btnCardLossReport = new JButton("确认挂失");
        btnCardLossReport.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnCardLossReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppLifeHelper.lossJudge(studentCardNumber);
                lblCurCardStatus.setText("挂失");
                JOptionPane.showMessageDialog(null, "挂失成功");
                //调用了AppLifeHelper中的.lossJudge功能实现通信。这个功能是将卡状态改为挂失。紧下有将卡状态改为正常，不再重复。
            }
        });
        jp1.add(btnCardLossReport);
        btnCardLossReport.setBounds(510, 507, 110, 30);
        //挂失

        JLabel CardFoundReportLabel = new JLabel("一卡通解挂");
        CardFoundReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        CardFoundReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardFoundReportLabel.setBounds(185, 550, 100, 40);
        jp1.add(CardFoundReportLabel);

        JTextField txtFoundReport = new JTextField();
        txtFoundReport.setText("解挂说明（非必要）");
        txtFoundReport.setFont((new Font("微软雅黑", Font.PLAIN, 14)));
        txtFoundReport.setBounds(315, 557, 160, 30);
        jp1.add(txtFoundReport);

        JButton btnCardFoundReport = new JButton("确认解挂");
        btnCardFoundReport.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnCardFoundReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppLifeHelper.foundJudge(studentCardNumber);
                lblCurCardStatus.setText("正常");
                JOptionPane.showMessageDialog(null, "解挂成功");
            }
        });
        jp1.add(btnCardFoundReport);
        btnCardFoundReport.setBounds(510, 557, 110, 30);
        //解冻
        //卡状态的相关实现结束

        JLabel lblWaterBillTable = new JLabel("一卡通交易记录");
        lblWaterBillTable.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblWaterBillTable.setHorizontalAlignment(SwingConstants.CENTER);
        lblWaterBillTable.setBounds(1020, 130, 150, 40);
        jp1.add(lblWaterBillTable);

        String[] headModelDealHistory ={"时间","金额","类型"};
        modelDealHistory =new DefaultTableModel(null,headModelDealHistory);

        JTable tblWaterBill = new JTable(10, 3);
        tblWaterBill.setModel(modelDealHistory);
        tblWaterBill.setBounds(800, 180, 600, 500);
        tblWaterBill.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblWaterBill.setRowHeight(50);
        DefaultTableCellRenderer rWaterBill = new DefaultTableCellRenderer();
        rWaterBill.setHorizontalAlignment(JLabel.CENTER);
        tblWaterBill.setDefaultRenderer(Object.class, rWaterBill);
        jp1.add(tblWaterBill);


        listDealHistory = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,null,"com.vcampus.server.bank.BankServer.getDealHistory",
                new Object[]{studentCardNumber}).send()).getListReturn(DealHistory.class);
        //从服务器得到List<DealHistory>的返回值

        modelDealHistory.setRowCount(0);
        String[][] listDataDealHistory =null;
        if(listDealHistory ==null){
            listDataDealHistory =new String[1][3];
            listDataDealHistory[0][0]="无交易记录..";
            listDataDealHistory[0][1]=listDataDealHistory[0][2]="";
        }
        else{
            listDataDealHistory = new String[listDealHistory.size()][3];
            for(int i = 0; i< listDealHistory.size(); i++){
                listDataDealHistory[i][0]= listDealHistory.get(i).dealTime;
                listDataDealHistory[i][1]=String.valueOf(listDealHistory.get(i).dealAmount);
                String dealTypeEnglish= listDealHistory.get(i).dealType;
                String dealTypeChinese=null;
                if(dealTypeEnglish.equals("INCOME"))
                    dealTypeChinese="收入";
                else if(dealTypeEnglish.equals("OUTCOME"))
                    dealTypeChinese="支出";
                else
                    dealTypeChinese="ERROR";
                listDataDealHistory[i][2]=dealTypeChinese;
            }
        }
        //返回不为空时按照数据的对应存储位置将数据映射在表格中。
        modelDealHistory =new DefaultTableModel(listDataDealHistory,headModelDealHistory){
            @Override
            public boolean isCellEditable(int a,int b){return false;}
        };
        //应用ListData到model
        tblWaterBill.setModel(modelDealHistory);
        //应用model到表格

        //交易记录表实现结束

        JButton btnCardRecharge = new JButton("确认充值");
        btnCardRecharge.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnCardRecharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Boolean verifyResult =
                        StringUtils.MD5EncodeSalted(String.valueOf(txtPassword.getPassword()),studentBankAccountPasswordSalt)
                        .equalsIgnoreCase(studentBankAccountPassword);

                if (!verifyResult) {
                    System.out.println("No result");
                    JOptionPane.showMessageDialog(null, "密码错误，请重试！");
                }
                else {

                    //TODO check here, 尤其检查api用得对不对
                    String balanceAddedText = txtAmount.getText().trim();
                    BigDecimal balanceAdded = new BigDecimal(balanceAddedText);
                    if (balanceAdded.compareTo(new BigDecimal(0)) == 1 // larger than 0
                            && balanceAdded.compareTo(new BigDecimal(1000)) == -1) // upper bound
                    {
                        HashMap<String, Object> mapCardNum_BalanceAdded = new HashMap<String, Object>();
                        mapCardNum_BalanceAdded.put("cardNumber", studentCardNumber);
                        BigDecimal _balance = App.session.getStudent().getBalance();
                        mapCardNum_BalanceAdded.put("money", _balance.add(balanceAdded));
                        BigDecimal result = AppLifeHelper.setBalance(mapCardNum_BalanceAdded);
                        if (result.compareTo(_balance.add(balanceAdded)) == 0) { // equals
                            JOptionPane.showMessageDialog(null, "充值成功");
                        }
                        lblCurCardBalance.setText(String.valueOf(result));
                        App.session.getStudent().setBalance(result);
                    }

                    Boolean flag = AppLifeHelper.insertDealHistory(studentCardNumber, balanceAdded, "INCOME");

                    //更改数据库部分，调用了AppLifeHelper.insertDealHistory实现与服务器通信。
                    //需要传递多个参数时封装为map

                    listDealHistory = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.bank.BankServer.getDealHistory",
                            new Object[]{studentCardNumber}).send()).getListReturn(DealHistory.class);

                    modelDealHistory.setRowCount(0);
                    String[][] listDataDealHistory = null;
                    if (listDealHistory == null) {
                        listDataDealHistory = new String[1][3];
                        listDataDealHistory[0][0] = "无交易记录..";
                        listDataDealHistory[0][1] = listDataDealHistory[0][2] = "";
                    } else {
                        listDataDealHistory = new String[listDealHistory.size()][3];
                        for (int i = 0; i < listDealHistory.size(); i++) {
                            listDataDealHistory[i][0] = listDealHistory.get(i).dealTime;
                            listDataDealHistory[i][1] = String.valueOf(listDealHistory.get(i).dealAmount);
                            String dealTypeEnglish = listDealHistory.get(i).dealType;
                            String dealTypeChinese = null;
                            if (dealTypeEnglish.equals("INCOME"))
                                dealTypeChinese = "收入";
                            else if (dealTypeEnglish.equals("OUTCOME"))
                                dealTypeChinese = "支出";
                            else
                                dealTypeChinese = "ERROR";
                            listDataDealHistory[i][2] = dealTypeChinese;
                        }
                    }
                    modelDealHistory = new DefaultTableModel(listDataDealHistory, headModelDealHistory) {
                        @Override
                        public boolean isCellEditable(int a, int b) {
                            return false;
                        }
                    };
                    tblWaterBill.setModel(modelDealHistory);

                    //复用代码实现即时刷新交易记录表。
                }
            }
        });
        jp1.add(btnCardRecharge);
        btnCardRecharge.setBounds(410, 380, 110, 35);

        //一卡通部分结束

        //宿舍部分开始 - jp2

        JButton btnBack2 = new JButton("返回");
        btnBack2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==btnBack2)
                {
                    AppStudent app=new AppStudent();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        //返回按钮

        btnBack2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack2.setBounds(1250, 30, 100, 40);
        jp2.add(btnBack2);

        JLabel lblDormNum = new JLabel("宿舍号");
        lblDormNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormNum.setBounds(175, 30, 100, 40);
        jp2.add(lblDormNum);

        JLabel lblCurDormNum = new JLabel(studentDormAddress);
        lblCurDormNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurDormNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurDormNum.setBounds(265, 30, 100, 40);
        jp2.add(lblCurDormNum);

        //基本信息显示

        JLabel lblDormInfo = new JLabel("宿舍信息查询");
        lblDormInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormInfo.setBounds(330, 100, 150, 40);
        jp2.add(lblDormInfo);

        JLabel lblDormHygieneRate = new JLabel("卫生分数查询");
        lblDormHygieneRate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneRate.setBounds(200, 160, 150, 40);
        jp2.add(lblDormHygieneRate);


        JTextField txtDormHygieneRate = new JTextField();
        txtDormHygieneRate.setBounds(510, 166, 70, 30);
        jp2.add(txtDormHygieneRate);

        JComboBox cmbDormHygieneRateWeek = new JComboBox();
        for (int i = 1; i < 17; i++) {
            cmbDormHygieneRateWeek.addItem("第" + i + "周");
        }
        cmbDormHygieneRateWeek.setBounds(370, 166, 100, 30);
        cmbDormHygieneRateWeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String weekText=cmbDormHygieneRateWeek.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",studentDormAddress);
                map.put("weekNo",weekNo);

                int hygieneMark;
                hygieneMark=ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getDormHygieneMark",
                                new Object[]{map}).send())
                        .getReturn(Integer.class);
                //唤起server的getDormHygieneMark函数得到数据
                txtDormHygieneRate.setText(String.valueOf(hygieneMark));
                //界面更新
                //查询卫生分数功能，查水电费功能类似，不表
            }
        });
        jp2.add(cmbDormHygieneRateWeek);



        JLabel lblDormWaterRate = new JLabel("水费查询");
        lblDormWaterRate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormWaterRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterRate.setBounds(225, 210, 100, 40);
        jp2.add(lblDormWaterRate);

        JTextField txtDormWaterRate = new JTextField();
        txtDormWaterRate.setBounds(510, 216, 70, 30);
        jp2.add(txtDormWaterRate);

        JComboBox cmbDormWaterRateMonth = new JComboBox();
        for (int i = 1; i < 13; i++) {
            cmbDormWaterRateMonth.addItem("第" + i + "月");
        }
        cmbDormWaterRateMonth.setBounds(370, 216, 100, 30);
        cmbDormWaterRateMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String weekText=cmbDormWaterRateMonth.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));
                System.out.println(weekNo);

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",studentDormAddress);
                map.put("weekNo",weekNo);

                BigDecimal waterRate;
                waterRate=ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getDormWaterRate",
                                new Object[]{map}).send())
                        .getReturn(BigDecimal.class);

                txtDormWaterRate.setText(String.valueOf(waterRate));
            }
        });
        jp2.add(cmbDormWaterRateMonth);
        //水费



        JLabel lblDormElectricityRate = new JLabel("电费查询");
        lblDormElectricityRate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormElectricityRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormElectricityRate.setBounds(225, 260, 100, 40);
        jp2.add(lblDormElectricityRate);

        JTextField txtDormElectricityRate = new JTextField();
        txtDormElectricityRate.setBounds(510, 266, 70, 30);
        jp2.add(txtDormElectricityRate);

        JComboBox cmbDormElectricityRateMonth = new JComboBox();
        for (int i = 1; i < 13; i++) {
            cmbDormElectricityRateMonth.addItem("第" + i + "月");
        }
        cmbDormElectricityRateMonth.setBounds(370, 266, 100, 30);
        cmbDormElectricityRateMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String weekText=cmbDormElectricityRateMonth.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));
                System.out.println(weekNo);

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dormAddress",studentDormAddress);
                map.put("weekNo",weekNo);

                BigDecimal electricityRate;
                electricityRate=ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getDormElectricityRate",
                                new Object[]{map}).send())
                        .getReturn(BigDecimal.class);

                txtDormElectricityRate.setText(String.valueOf(electricityRate));
            }
        });
        jp2.add(cmbDormElectricityRateMonth);
        //电费


        JLabel lblDormRepairReport = new JLabel("宿舍报修");
        lblDormRepairReport.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReport.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReport.setBounds(355, 350, 100, 40);
        jp2.add(lblDormRepairReport);

        JLabel lblDormRepairReportThing = new JLabel("报修内容");
        lblDormRepairReportThing.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReportThing.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportThing.setBounds(225, 470, 100, 40);
        jp2.add(lblDormRepairReportThing);

        JTextField txtDormRepairReport = new JTextField();
        txtDormRepairReport.setBounds(345, 476, 150, 30);
        jp2.add(txtDormRepairReport);

        JLabel lblDormRepairReportHistory = new JLabel("报修历史");
        lblDormRepairReportHistory.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReportHistory.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportHistory.setBounds(1000, 100, 100, 40);
        jp2.add(lblDormRepairReportHistory);

        String[] headModelRepairHistory={"时间","内容","状态"};
        modelRepairHistory=new DefaultTableModel(null,headModelRepairHistory);

        JTable tblDormRepairHistory = new JTable(9, 3);
        tblDormRepairHistory.setModel(modelRepairHistory);
        tblDormRepairHistory.setBounds(800, 150, 500, 450);
        tblDormRepairHistory.setRowHeight(50);
        tblDormRepairHistory.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        DefaultTableCellRenderer rDormRepairHistory = new DefaultTableCellRenderer();
        rDormRepairHistory.setHorizontalAlignment(JLabel.CENTER);
        tblDormRepairHistory.setDefaultRenderer(Object.class, rDormRepairHistory);
        jp2.add(tblDormRepairHistory);

        listRepairHistory = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getRepairHistory",
                        new Object[]{studentDormAddress}).send())
                .getListReturn(RepairHistory.class);

        modelRepairHistory.setRowCount(0);
        String[][] listDataRepairHistory = null;
        if(listRepairHistory == null){
            listDataRepairHistory=new String[1][3];
            listDataRepairHistory[0][0]="无报修记录...";
            listDataRepairHistory[0][1]=listDataRepairHistory[0][2]="";
        }
        else{
            listDataRepairHistory=new String[listRepairHistory.size()][3];
            for (int i=0;i<listRepairHistory.size();i++){
                listDataRepairHistory[i][0]=listRepairHistory.get(i).reportTime;
                listDataRepairHistory[i][1]=listRepairHistory.get(i).reportContent;
                String repairStatusEnglish= listRepairHistory.get(i).repairStatus;
                String repairStatusChinese="ERROR";
                if(repairStatusEnglish.equals("TODO"))
                    repairStatusChinese="待修理";
                else if (repairStatusEnglish.equals("DONE"))
                    repairStatusChinese="已修理";
                listDataRepairHistory[i][2]=repairStatusChinese;
            }
        }
        modelRepairHistory=new DefaultTableModel(listDataRepairHistory,headModelRepairHistory){
            @Override
            public boolean isCellEditable(int a,int b){return false;}
        };
        tblDormRepairHistory.setModel(modelRepairHistory);
        //宿舍报修历史显示，与交易记录类似。

        JButton btnDormRepairReport = new JButton("确认报修");
        btnDormRepairReport.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        btnDormRepairReport.setBounds(530, 474, 110, 35);
        btnDormRepairReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reportContent;
                reportContent=txtDormRepairReport.getText().trim();
                String repairStatus="TODO";
                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.insertRepairHistory",
                                new Object[]{new RepairHistory(studentDormAddress,reportContent,repairStatus)}).send())
                        .getReturn(Boolean.class);

                listRepairHistory = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.getRepairHistory",
                                new Object[]{studentDormAddress}).send())
                        .getListReturn(RepairHistory.class);

                modelRepairHistory.setRowCount(0);
                String[][] listDataRepairHistory = null;
                if(listRepairHistory == null){
                    listDataRepairHistory=new String[1][3];
                    listDataRepairHistory[0][0]="无报修记录...";
                    listDataRepairHistory[0][1]=listDataRepairHistory[0][2]="";
                }
                else{
                    listDataRepairHistory=new String[listRepairHistory.size()][3];
                    for (int i=0;i<listRepairHistory.size();i++){
                        listDataRepairHistory[i][0]=listRepairHistory.get(i).reportTime;
                        listDataRepairHistory[i][1]=listRepairHistory.get(i).reportContent;
                        String repairStatusEnglish= listRepairHistory.get(i).repairStatus;
                        String repairStatusChinese="ERROR";
                        if(repairStatusEnglish.equals("TODO"))
                            repairStatusChinese="待修理";
                        else if (repairStatusEnglish.equals("DONE"))
                            repairStatusChinese="已修理";
                        listDataRepairHistory[i][2]=repairStatusChinese;
                    }
                }
                modelRepairHistory=new DefaultTableModel(listDataRepairHistory,headModelRepairHistory){
                    @Override
                    public boolean isCellEditable(int a,int b){return false;}
                };
                tblDormRepairHistory.setModel(modelRepairHistory);
            }
        });
        jp2.add(btnDormRepairReport);
        //报修功能，与充值功能类似。

        //宿舍部分结束
    //
    }
}
