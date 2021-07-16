package com.vcampus.test;

import com.vcampus.client.main.StuLibrary;

import java.awt.*;

/**
 * @author Xiao Kaijie
 * @date 2021-07-14
 */

public class StuLibraryEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StuLibrary app = new StuLibrary();
                app.setVisible(true);
            }
        });
    }
}
