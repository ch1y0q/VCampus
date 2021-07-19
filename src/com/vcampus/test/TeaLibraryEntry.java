package com.vcampus.test;

import com.vcampus.client.main.TeaLibrary;

import java.awt.*;

/**
 * @author Xiao Kaijie
 * @date 2021-07-16
 */

public class TeaLibraryEntry {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TeaLibrary app = new TeaLibrary();
                app.setVisible(true);
            }
        });
    }
}