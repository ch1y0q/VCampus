package com.vcampus.UI.test;

import com.vcampus.UI.myJLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * * 测试带阴影的label
 * @author Dong Ruojing
 * @date 2021/7/23
 */
public class ShadowTest extends JFrame{
    private JPanel contentPane;
    public ShadowTest(){
        setResizable(true);
        setTitle("shadow test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Icon icon =new ImageIcon(getClass().getResource("/resources/assets/bg/bg4.jpg"));
        myJLabel bg7 = new myJLabel();
        bg7.setIcon(icon);
        contentPane.add(bg7);
        bg7.setBounds(50, 50, 500, 500);
        bg7.setForeground(new Color(255,255,255,255));
    }


}
