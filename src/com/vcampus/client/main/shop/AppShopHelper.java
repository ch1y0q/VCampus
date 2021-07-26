package com.vcampus.client.main.shop;

import com.vcampus.client.main.App;
import com.vcampus.entity.Student;
import com.vcampus.entity.UserType;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.math.BigDecimal;

/**
 * @author Huang Qiyue
 * @date 2021-07-26
 */
public class AppShopHelper {
    public static BigDecimal getBalance(String cardNumber, UserType userType) {
        switch (userType) {
            case STUDENT:
                return ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.bank.BankServer.getStudentBalance",
                                new Object[]{cardNumber}).send())
                        .getReturn(BigDecimal.class);
            case TEACHER:
                return ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.bank.BankServer.getTeacherBalance",
                                new Object[]{cardNumber}).send())
                        .getReturn(BigDecimal.class);
            default:
                return new BigDecimal(0);
        }
    }

    public static int submitPurchase(String cardNumber, UserType userType, String se) {
        switch (userType) {
            case STUDENT:
                return ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.shop.ShopServer.studentCheckout",
                                new Object[]{cardNumber, se}).send())
                        .getReturn(int.class);
            case TEACHER:
                return ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.shop.ShopServer.teacherCheckout",
                                new Object[]{cardNumber, se}).send())
                        .getReturn(int.class);
            default:
                return -1;
        }

    }
}