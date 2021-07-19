package com.vcampus.test;

import com.vcampus.client.main.ManLibrary;

import java.awt.*;

public class ManLibraryEntry {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ManLibrary app = new ManLibrary();
                app.setVisible(true);
            }
        });
    }
}
