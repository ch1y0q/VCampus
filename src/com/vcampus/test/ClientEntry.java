package com.vcampus.test;


import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.App;

import java.awt.*;
import java.io.IOException;

/**
 * 客户端主入口
 * 注意：需要先启动服务器
 *
 * @author Huang Qiyue
 * @date 2021-07-13
 */
public class ClientEntry {
    public static void main(String args[]) throws IOException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    WebLookAndFeel.install();
                    App app = new App();
                    //app.setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
