package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Y
 * @date 2021/7/14
 */
public class AppDormitory extends JFrame{
    private JPanel contentPane;
    public static JLabel lblBalance;
    public AppDormitory(){
        setResizable(true);
        setTitle("宿舍管理中心 - VCampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel CardNumLabel = new JLabel("宿舍号");
        CardNumLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CardNumLabel.setBounds(5, 5, 100, 40);
        contentPane.add(CardNumLabel);

        JLabel DormNum = new JLabel("M5C2412");
        DormNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        DormNum.setHorizontalAlignment(SwingConstants.CENTER);
        DormNum.setBounds(75, 5, 100, 40);
        contentPane.add(DormNum);

        JLabel DormInfoLabel = new JLabel("宿舍信息查询");
        DormInfoLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        DormInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DormInfoLabel.setBounds(40, 60, 100, 40);
        contentPane.add(DormInfoLabel);

        JLabel DormHygieneRateLabel = new JLabel("卫生分数查询");
        DormHygieneRateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        DormHygieneRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DormHygieneRateLabel.setBounds(40, 105, 100, 40);
        contentPane.add(DormHygieneRateLabel);

        JComboBox DormHygieneRateWeek=new JComboBox();
        for(int i=1;i<17;i++) {
            DormHygieneRateWeek.addItem("第"+i+"周");
        }
        DormHygieneRateWeek.setBounds(150,111,100,30);
        contentPane.add(DormHygieneRateWeek);

        JTextField DormHygieneRate=new JTextField();
        DormHygieneRate.setBounds(265,111,60,30);
        contentPane.add(DormHygieneRate);

        JLabel DormWaterRateLabel = new JLabel("水费查询");
        DormWaterRateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        DormWaterRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DormWaterRateLabel.setBounds(40, 150, 100, 40);
        contentPane.add(DormWaterRateLabel);

        JComboBox DormWaterRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            DormWaterRateMonth.addItem("第"+i+"月");
        }
        DormWaterRateMonth.setBounds(150,156,100,30);
        contentPane.add(DormWaterRateMonth);

        JTextField DormWaterRate=new JTextField();
        DormWaterRate.setBounds(265,156,60,30);
        contentPane.add(DormWaterRate);

        JLabel DormElectricityRateLabel = new JLabel("电费查询");
        DormElectricityRateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        DormElectricityRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DormElectricityRateLabel.setBounds(40, 195, 100, 40);
        contentPane.add(DormElectricityRateLabel);

        JComboBox DormElectricityRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            DormElectricityRateMonth.addItem("第"+i+"月");
        }
        DormElectricityRateMonth.setBounds(150,201,100,30);
        contentPane.add(DormElectricityRateMonth);

        JTextField DormElectricityRate=new JTextField();
        DormElectricityRate.setBounds(265,201,60,30);
        contentPane.add(DormElectricityRate);

        JLabel DormRepairReportLabel = new JLabel("宿舍报修");
        DormRepairReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        DormRepairReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DormRepairReportLabel.setBounds(40, 195, 100, 40);
        contentPane.add(DormRepairReportLabel);
    }
}
