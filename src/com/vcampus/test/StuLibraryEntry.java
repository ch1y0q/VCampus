package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
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
                WebLookAndFeel.install ();
                StuLibrary app = new StuLibrary();
                app.setVisible(true);
            }
        });
    }
}
