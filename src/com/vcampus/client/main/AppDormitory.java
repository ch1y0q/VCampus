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
    }
}
