package com.vcampus.UI.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.UI.test.ShadowTest;

import java.awt.*;

/**
 * 测试带阴影的label 入口
 * @author Dong Ruojing
 * @date 2021/7/24
 */
public class shadowTestEntry {
    public static void main(String args[]){
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            WebLookAndFeel.install ();
            ShadowTest app = new ShadowTest();
            app.setVisible(true);
        }
    });
}
}
