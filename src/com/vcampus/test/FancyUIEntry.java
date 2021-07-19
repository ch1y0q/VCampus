package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.App;

import java.awt.*;
import java.io.IOException;

/**
 * @author Huang Qiyue
 * @date 2021-07-19
 */
public class FancyUIEntry {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install();
                FancyUITest fancy = new FancyUITest();
                FancyUITest.getInstance()
                .setVisible(true);
            }
        });

    }
}
