package com.vcampus.client.main;

//import com.vcampus.client.main.student.AppStudent;
import com.vcampus.client.main.student.StuCategory;
import com.vcampus.client.main.teacher.AppTeacher;
import com.vcampus.entity.DealHistory;
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
 * 参见AppLife
 * 该Java类是去掉AppLife中部分功能实现的。
 * @author Y
 * @date 2021/7/21
 */

public class AppLifeTeacher extends JFrame {
    private static JPanel contentPane;
    public List<DealHistory> listDealHistory =null;
    public DefaultTableModel modelDealHistory;

    public AppLifeTeacher() {

        String teacherCardNumber;
        teacherCardNumber = App.session.getTeacher().getCardNumber();

        String teacherBankAccount;
        teacherBankAccount = App.session.getTeacher().getBankAccount();

        String lossJudge;
        lossJudge=ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLifeTeacherServer.getCardStatus",
                        new Object[]{teacherCardNumber}).send())
                .getReturn(String.class);
        String lossJudgeChinese="ERROR";
        if(lossJudge.equals("LOST"))
            lossJudgeChinese="挂失";
        else if(lossJudge.equals("NORMAL"))
            lossJudgeChinese="正常";

        String teacherBankAccountPassword=
                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLifeTeacherServer.getBankAccountPassword",
                                new Object[]{teacherCardNumber}).send())
                        .getReturn(String.class);

        String teacherBankAccountPasswordSalt=
                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLifeTeacherServer.getBankAccountPasswordSalt",
                                new Object[]{teacherCardNumber}).send())
                        .getReturn(String.class);


        setResizable(true);
        setTitle("生活服务 - Vcampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /*
        JTree jt = new StuCategory().getJTree();
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
                    setVisible(false);
                }
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack.setBounds(1250, 30, 100, 40);
        contentPane.add(btnBack);

        JLabel lblCardNum = new JLabel("一卡通号");
        lblCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardNum.setBounds(155, 30, 100, 40);
        contentPane.add(lblCardNum);

        JLabel lblCurCardNum = new JLabel(teacherCardNumber);
        lblCurCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardNum.setBounds(255, 30, 100, 40);
        contentPane.add(lblCurCardNum);

        JLabel lblCardStatus = new JLabel("一卡通状态");
        lblCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardStatus.setBounds(370, 30, 100, 40);
        contentPane.add(lblCardStatus);

        JLabel lblCurCardStatus = new JLabel(lossJudgeChinese);
        lblCurCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardStatus.setBounds(450, 30, 100, 40);
        contentPane.add(lblCurCardStatus);

        JLabel lblCardBalance = new JLabel("一卡通余额");
        lblCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardBalance.setBounds(560, 30, 100, 40);
        contentPane.add(lblCardBalance);

        JLabel lblCurCardBalance = new JLabel(App.session.getTeacher().getBalance().toString());
        lblCurCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardBalance.setBounds(650, 30, 100, 40);
        contentPane.add(lblCurCardBalance);

        JLabel lblCardOp = new JLabel("一卡通业务");
        lblCardOp.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardOp.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardOp.setBounds(400, 130, 100, 40);
        contentPane.add(lblCardOp);


        JLabel lblCardRecharge = new JLabel("一卡通充值");
        lblCardRecharge.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRecharge.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRecharge.setBounds(185, 210, 100, 40);
        contentPane.add(lblCardRecharge);

        JLabel lblCardRechargeBankAccount = new JLabel("绑定的银行账号");
        lblCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeBankAccount.setBounds(290, 210, 150, 40);
        contentPane.add(lblCardRechargeBankAccount);

        JLabel lblCurCardRechargeBankAccount = new JLabel(teacherBankAccount);
        lblCurCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardRechargeBankAccount.setBounds(450, 210, 200, 40);
        contentPane.add(lblCurCardRechargeBankAccount);

        JLabel lblCardRechargeBankAccountPassword = new JLabel("银行账号密码");
        lblCardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeBankAccountPassword.setBounds(290, 260, 150, 40);
        contentPane.add(lblCardRechargeBankAccountPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setText("");
        txtPassword.setBounds(465, 267, 160, 30);
        contentPane.add(txtPassword);

        JLabel lblCardRechargeAmount = new JLabel("充值金额");
        lblCardRechargeAmount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeAmount.setBounds(290, 310, 150, 40);
        contentPane.add(lblCardRechargeAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setText("");
        txtAmount.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        txtAmount.setBounds(465, 317, 160, 30);
        contentPane.add(txtAmount);



        JLabel lblCardLossReport = new JLabel("一卡通挂失");
        lblCardLossReport.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardLossReport.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardLossReport.setBounds(185, 500, 100, 40);
        contentPane.add(lblCardLossReport);

        JTextField txtLossReport = new JTextField();
        txtLossReport.setText("挂失说明（非必要）");
        txtLossReport.setFont((new Font("微软雅黑", Font.PLAIN, 14)));
        txtLossReport.setBounds(315, 507, 160, 30);
        contentPane.add(txtLossReport);

        JButton btnCardLossReport = new JButton("确认挂失");
        btnCardLossReport.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnCardLossReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLifeTeacherServer.setLossStatusLost",
                                new Object[]{teacherCardNumber}).send())
                        .getReturn(Boolean.class);
                lblCurCardStatus.setText("挂失");
                JOptionPane.showMessageDialog(null, "挂失成功");
            }
        });
        contentPane.add(btnCardLossReport);
        btnCardLossReport.setBounds(510, 507, 110, 30);

        JLabel CardFoundReportLabel = new JLabel("一卡通解挂");
        CardFoundReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        CardFoundReportLabel.setHorizontalAlignment(SwingConstants.CENTER);

        CardFoundReportLabel.setBounds(185, 550, 100, 40);
        contentPane.add(CardFoundReportLabel);

        JTextField txtFoundReport = new JTextField();
        txtFoundReport.setText("解挂说明（非必要）");
        txtFoundReport.setFont((new Font("微软雅黑", Font.PLAIN, 14)));
        txtFoundReport.setBounds(315, 557, 160, 30);
        contentPane.add(txtFoundReport);

        JButton btnCardFoundReport = new JButton("确认解挂");
        btnCardFoundReport.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnCardFoundReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLifeTeacherServer.setLossStatusNormal",
                                new Object[]{teacherCardNumber}).send())
                        .getReturn(Boolean.class);
                lblCurCardStatus.setText("正常");
                JOptionPane.showMessageDialog(null, "解挂成功");
            }
        });
        contentPane.add(btnCardFoundReport);
        btnCardFoundReport.setBounds(510, 557, 110, 30);

        JLabel lblWaterBillTable = new JLabel("一卡通交易记录");
        lblWaterBillTable.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblWaterBillTable.setHorizontalAlignment(SwingConstants.CENTER);
        lblWaterBillTable.setBounds(1020, 130, 150, 40);
        contentPane.add(lblWaterBillTable);

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
        contentPane.add(tblWaterBill);


        listDealHistory = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,null,"com.vcampus.server.bank.BankServer.getDealHistory",
                new Object[]{teacherCardNumber}).send()).getListReturn(DealHistory.class);

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
        modelDealHistory =new DefaultTableModel(listDataDealHistory,headModelDealHistory){
            @Override
            public boolean isCellEditable(int a,int b){return false;}
        };
        tblWaterBill.setModel(modelDealHistory);


        JButton btnCardRecharge = new JButton("确认充值");
        btnCardRecharge.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        btnCardRecharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Boolean verifyResult =
                        StringUtils.MD5EncodeSalted(String.valueOf(txtPassword.getPassword()),teacherBankAccountPasswordSalt)
                                .equalsIgnoreCase(teacherBankAccountPassword);

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
                        mapCardNum_BalanceAdded.put("cardNumber", teacherCardNumber);
                        BigDecimal _balance = ResponseUtils
                                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLifeTeacherServer.getCardBalance",
                                        new Object[]{teacherCardNumber}).send())
                                .getReturn(BigDecimal.class);

                        BigDecimal result=_balance.add(balanceAdded);
                        mapCardNum_BalanceAdded.put("money", result);
                        ResponseUtils
                                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLifeTeacherServer.setCardBalance",
                                        new Object[]{mapCardNum_BalanceAdded}).send())
                                .getReturn(Boolean.class);
                        JOptionPane.showMessageDialog(null, "充值成功");
                        lblCurCardBalance.setText(String.valueOf(result));
                    }

                    Boolean flag = AppLifeHelper.insertDealHistory(teacherCardNumber, balanceAdded, "INCOME");


                    listDealHistory = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.bank.BankServer.getDealHistory",
                            new Object[]{teacherCardNumber}).send()).getListReturn(DealHistory.class);

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


                }
            }
        });

        contentPane.add(btnCardRecharge);
        btnCardRecharge.setBounds(460, 380, 110, 35);

        //一卡通部分结束
    }
}
