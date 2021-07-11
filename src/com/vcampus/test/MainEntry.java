package com.vcampus.test;

import com.vcampus.client.LoginUI;
import com.vcampus.entity.Student;

import java.util.ArrayList;

/**
 * @Author: Huang Qiyue
 * @Date: 2021-07-07
 * @Description:
 */
public class MainEntry {
    public static void main(String[] args) {
        /* AES encryption and decryption
        try {
            AES128 _AES128 = new AES128();
            _AES128.main(args);
        }
        catch (Exception e){
            //Do nothing
        }
         */

        Student me = new Student("my_name", "1234", "213191111", "09019111", 0, new ArrayList<String>());
        System.out.println(me.getSchool());
        LoginUI _login = new LoginUI();
        _login.setVisible(true);
    }
}
