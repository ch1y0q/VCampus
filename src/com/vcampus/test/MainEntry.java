package com.vcampus.test;

import com.vcampus.client.LoginUI;
import com.vcampus.util.*;

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

        LoginUI _login = new LoginUI();
        _login.setVisible(true);
    }
}
