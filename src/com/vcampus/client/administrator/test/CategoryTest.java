package com.vcampus.client.administrator.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.administrator.main.Category;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dong Ruojing
 * @date 2021/7/20
 */
public class CategoryTest {

    public static void main(String[] agrs)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                JFrame frame=new JFrame("VCampus");
                frame.setBounds(400, 200, 800, 550);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Category().createComponent(), BorderLayout.WEST);
                frame.setVisible(true);
            }
        });
    }
}
