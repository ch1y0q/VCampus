package com.vcampus.client.main;

import org.apache.ibatis.jdbc.Null;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Y
 * @date 2021/7/14
 */

public class AppLife extends JFrame{
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2,jp3;
    public AppLife(){
        setResizable(false);
        setTitle("生活服务 - Vcampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
        jp1.setBackground(new Color(240, 255, 240));
        jp2.setLayout(null);
        jp2.setBackground(new Color(240, 255, 240));
        jp3.setLayout(null);
        jp3.setBackground(new Color(240, 255, 240));

        tabbedPane = new JTabbedPane();
        tabbedPane.add("一卡通",jp1);
        tabbedPane.add("宿舍",jp2);
        tabbedPane.add("商店",jp3);
        tabbedPane.setBounds(0,0,2000,1100);
        this.add(tabbedPane);


        //一卡通部分开始 - jp1

        JLabel lblCardNum = new JLabel("一卡通号");
        lblCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardNum.setBounds(205, 5, 100, 40);
        jp1.add(lblCardNum);

        JLabel lblCurCardNum = new JLabel("213191111");
        lblCurCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardNum.setBounds(285, 5, 100, 40);
        jp1.add(lblCurCardNum);

        JLabel lblCardStatus = new JLabel("一卡通状态");
        lblCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardStatus.setBounds(400, 5, 100, 40);
        jp1.add(lblCardStatus);

        JLabel lblCurCardStatus = new JLabel("正常");
        lblCurCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCurCardStatus.setBounds(460, 5, 100, 40);
        jp1.add(lblCurCardStatus);

        JLabel lblCardBalance = new JLabel("一卡通余额");
        lblCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardBalance.setBounds(560, 5, 100, 40);
        jp1.add(lblCardBalance);

        JLabel lblCurCardBalance = new JLabel("230.58");
        lblCurCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCurCardBalance.setBounds(630, 5, 100, 40);
        jp1.add(lblCurCardBalance);

        JLabel lblCardOp = new JLabel("一卡通业务");
        lblCardOp.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardOp.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardOp.setBounds(235, 55, 100, 40);
        jp1.add(lblCardOp);

        JLabel lblCardRecharge = new JLabel("一卡通充值");
        lblCardRecharge.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRecharge.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRecharge.setBounds(235, 85, 100, 40);
        jp1.add(lblCardRecharge);

        JLabel lblCardRechargeBankAccount = new JLabel("绑定的银行账号");
        lblCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRechargeBankAccount.setBounds(310, 85, 150, 40);
        jp1.add(lblCardRechargeBankAccount);

        JLabel lblCurCardRechargeBankAccount = new JLabel("6216631200002070838");
        lblCurCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCurCardRechargeBankAccount.setBounds(430, 85, 200, 40);
        jp1.add(lblCurCardRechargeBankAccount);

        JLabel lblCardRechargeBankAccountPassword = new JLabel("银行账号密码");
        lblCardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRechargeBankAccountPassword.setBounds(310, 115, 150, 40);
        jp1.add(lblCardRechargeBankAccountPassword);

        JPasswordField txtPassword=new JPasswordField();
        txtPassword.setText("");
        txtPassword.setBounds(450,122,160,30);
        jp1.add(txtPassword);

        /*JLabel CardRechargeBankAccountPassword = new JLabel("●●●●●●");
        CardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeBankAccountPassword.setBounds(230, 115, 200, 40);
        contentPane.add(CardRechargeBankAccountPassword);
*/

        JLabel lblCardRechargeAmount = new JLabel("充值金额");
        lblCardRechargeAmount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRechargeAmount.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRechargeAmount.setBounds(310, 145, 150, 40);
        jp1.add(lblCardRechargeAmount);

        JTextField txtAmount=new JTextField();
        txtAmount.setText("请输入充值金额");
        txtAmount.setBounds(450,152,160,30);
        jp1.add(txtAmount);

        JButton btnCardRecharge=new JButton("确认充值");
        jp1.add(btnCardRecharge);
        btnCardRecharge.setBounds(420,190,90,25);

        JLabel lblCardLossReport = new JLabel("一卡通挂失");
        lblCardLossReport.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardLossReport.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardLossReport.setBounds(235, 235, 100, 40);
        jp1.add(lblCardLossReport);

        JTextField txtLossReport=new JTextField();
        txtLossReport.setText("挂失说明（非必要）");
        txtLossReport.setBounds(345,242,160,30);
        jp1.add(txtLossReport);

        JButton btnCardLossReport=new JButton("确认挂失");
        jp1.add(btnCardLossReport);
        btnCardLossReport.setBounds(520,245,90,25);

        JLabel CardFoundReportLabel = new JLabel("一卡通解挂");
        CardFoundReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardFoundReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardFoundReportLabel.setBounds(235, 285, 100, 40);
        jp1.add(CardFoundReportLabel);

        JTextField txtFoundReport=new JTextField();
        txtFoundReport.setText("挂失说明（非必要）");
        txtFoundReport.setBounds(345,292,160,30);
        jp1.add(txtFoundReport);

        JButton btnCardFoundReport=new JButton("确认解挂");
        jp1.add(btnCardFoundReport);
        btnCardFoundReport.setBounds(520,295,90,25);

        JLabel lblWaterBillTable = new JLabel("一卡通交易记录");
        lblWaterBillTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblWaterBillTable.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblWaterBillTable.setBounds(720, 80, 150, 40);
        jp1.add(lblWaterBillTable);

        JTable tblWaterBill=new JTable(10,3);
        tblWaterBill.setBounds(700,120,200,200);
        tblWaterBill.setRowHeight(20);
        tblWaterBill.getModel().setValueAt("时间",0,0);
        tblWaterBill.getModel().setValueAt("金额",0,1);
        tblWaterBill.getModel().setValueAt("属性",0,2);
        jp1.add(tblWaterBill);

        //一卡通部分结束

        //宿舍部分开始 - jp2

        JLabel lblDormNum = new JLabel("宿舍号");
        lblDormNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormNum.setBounds(5, 5, 100, 40);
        jp2.add(lblDormNum);

        JLabel lblCurDormNum = new JLabel("M5C2412");
        lblCurDormNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurDormNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurDormNum.setBounds(75, 5, 100, 40);
        jp2.add(lblCurDormNum);

        JLabel lblDormInfo = new JLabel("宿舍信息查询");
        lblDormInfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormInfo.setBounds(40, 60, 100, 40);
        jp2.add(lblDormInfo);

        JLabel lblDormHygieneRate = new JLabel("卫生分数查询");
        lblDormHygieneRate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormHygieneRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneRate.setBounds(40, 105, 100, 40);
        jp2.add(lblDormHygieneRate);

        JComboBox cmbDormHygieneRateWeek=new JComboBox();
        for(int i=1;i<17;i++) {
            cmbDormHygieneRateWeek.addItem("第"+i+"周");
        }
        cmbDormHygieneRateWeek.setBounds(150,111,100,30);
        jp2.add(cmbDormHygieneRateWeek);

        JTextField txtDormHygieneRate=new JTextField();
        txtDormHygieneRate.setBounds(265,111,60,30);
        jp2.add(txtDormHygieneRate);

        JLabel lblDormWaterRate = new JLabel("水费查询");
        lblDormWaterRate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormWaterRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterRate.setBounds(40, 150, 100, 40);
        jp2.add(lblDormWaterRate);

        JComboBox cmbDormWaterRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormWaterRateMonth.addItem("第"+i+"月");
        }
        cmbDormWaterRateMonth.setBounds(150,156,100,30);
        jp2.add(cmbDormWaterRateMonth);

        JTextField txtDormWaterRate=new JTextField();
        txtDormWaterRate.setBounds(265,156,60,30);
        jp2.add(txtDormWaterRate);

        JLabel lblDormElectricityRate = new JLabel("电费查询");
        lblDormElectricityRate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormElectricityRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormElectricityRate.setBounds(40, 195, 100, 40);
        jp2.add(lblDormElectricityRate);

        JComboBox cmbDormElectricityRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormElectricityRateMonth.addItem("第"+i+"月");
        }
        cmbDormElectricityRateMonth.setBounds(150,201,100,30);
        jp2.add(cmbDormElectricityRateMonth);

        JTextField txtDormElectricityRate=new JTextField();
        txtDormElectricityRate.setBounds(265,201,60,30);
        jp2.add(txtDormElectricityRate);

        JLabel lblDormRepairReport = new JLabel("宿舍报修");
        lblDormRepairReport.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReport.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReport.setBounds(390, 60, 100, 40);
        jp2.add(lblDormRepairReport);

        JLabel lblDormRepairReportThing = new JLabel("报修内容");
        lblDormRepairReportThing.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportThing.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportThing.setBounds(390, 100, 100, 40);
        jp2.add(lblDormRepairReportThing);

        JTextField txtDormRepairReport=new JTextField();
        txtDormRepairReport.setBounds(500,106,150,30);
        jp2.add(txtDormRepairReport);

        JLabel lblDormRepairReportDate = new JLabel("报修日期");
        lblDormRepairReportDate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportDate.setBounds(390, 140, 100, 40);
        jp2.add(lblDormRepairReportDate);

        JTextField txtDormRepairReportDate=new JTextField();
        txtDormRepairReportDate.setBounds(500,146,150,30);
        jp2.add(txtDormRepairReportDate);

        JLabel lblDormRepairReportDetail = new JLabel("具体信息");
        lblDormRepairReportDetail.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportDetail.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportDetail.setBounds(390, 180, 100, 40);
        jp2.add(lblDormRepairReportDetail);

        JTextField txtDormRepairReportDetail=new JTextField();
        txtDormRepairReportDetail.setBounds(500,186,150,30);
        jp2.add(txtDormRepairReportDetail);

        JButton btnDormRepairReport=new JButton("确认报修");
        jp2.add(btnDormRepairReport);
        btnDormRepairReport.setBounds(490,230,90,25);

        JLabel lblDormRepairReportHistory = new JLabel("报修历史");
        lblDormRepairReportHistory.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportHistory.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportHistory.setBounds(390, 260, 100, 40);
        jp2.add(lblDormRepairReportHistory);

        JTable tblDormRepairHistory=new JTable(6,3);
        tblDormRepairHistory.setBounds(430,300,300,120);
        tblDormRepairHistory.setRowHeight(20);
        tblDormRepairHistory.getModel().setValueAt("时间",0,0);
        tblDormRepairHistory.getModel().setValueAt("内容",0,1);
        tblDormRepairHistory.getModel().setValueAt("状态",0,2);
        jp2.add(tblDormRepairHistory);

        //宿舍部分结束

        //商店部分开始 -jp3
        JLabel lblCommoditySearch = new JLabel("商品查询");
        lblCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommoditySearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySearch.setBounds(15, 15, 100, 40);
        jp3.add(lblCommoditySearch);

        JTextField txtCommoditySearch=new JTextField();
        txtCommoditySearch.setBounds(110,21,160,30);
        jp3.add(txtCommoditySearch);

        JLabel lblCommodityKind = new JLabel("商品种类");
        lblCommodityKind.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityKind.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityKind.setBounds(300, 15, 100, 40);
        jp3.add(lblCommodityKind);

        JComboBox cmbCommodityKind=new JComboBox();
        cmbCommodityKind.addItem("食品");
        cmbCommodityKind.addItem("日化");
        cmbCommodityKind.addItem("文具");
        cmbCommodityKind.setBounds(400,21,100,30);
        jp3.add(cmbCommodityKind);

        JTable tblCommodityList=new JTable(10,2);
        tblCommodityList.setBounds(50,100,200,200);
        tblCommodityList.setRowHeight(20);
        tblCommodityList.getModel().setValueAt("商品名称",0,0);
        tblCommodityList.getModel().setValueAt("价格",0,1);
        tblCommodityList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        JScrollPane scrollPane=new JScrollPane(tblCommodityList);
        jp3.add(tblCommodityList);

        JLabel lblCommodityPic = new JLabel("商品图片");
        lblCommodityPic.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityPic.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityPic.setBounds(300, 80, 100, 40);
        jp3.add(lblCommodityPic);

        JLabel commodityPic = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/bg/bg3.jpg")));
        jp3.add(commodityPic);
        commodityPic.setBounds(500, 120, 100, 100);

        JLabel lblCommodityInfo = new JLabel("商品信息");
        lblCommodityInfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfo.setBounds(300, 225, 100, 40);
        jp3.add(lblCommodityInfo);

        JLabel lblCommoditySpInfo = new JLabel("商品详细信息");
        lblCommoditySpInfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommoditySpInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySpInfo.setBounds(350, 255, 100, 40);
        jp3.add(lblCommoditySpInfo);

        JTextArea commodityDetail= new JTextArea("这里应该是商品详细信息",8,30);
        commodityDetail.setLineWrap(true);
        commodityDetail.setFont(new Font("微软雅黑",Font.PLAIN,14));
        commodityDetail.setBounds(475,265,150,75);
        jp3.add(commodityDetail);

        JLabel lblCommodityNum = new JLabel("购买数量");
        lblCommodityNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityNum.setBounds(350, 350, 100, 40);
        jp3.add(lblCommodityNum);

        JTextField txtCommodityNum=new JTextField();
        txtCommodityNum.setBounds(470,355,160,30);
        jp3.add(txtCommodityNum);

        JButton btnAddToCart=new JButton("确认购买");
        jp3.add(btnAddToCart);
        btnAddToCart.setBounds(500,400,90,25);
    }
}
