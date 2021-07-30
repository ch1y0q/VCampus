package com.vcampus.client.main.shop;

import com.vcampus.client.main.App;
import com.vcampus.entity.Student;
import com.vcampus.entity.UserType;
import com.vcampus.entity.GoodsHistory;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.math.BigDecimal;

/**
 * 商店相关的助手类
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
                        .getReturn(Integer.class);
            case TEACHER:
                return ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.shop.ShopServer.teacherCheckout",
                                new Object[]{cardNumber, se}).send())
                        .getReturn(Integer.class);
            default:
                return -1;
        }

    }

    public static boolean insertPurchaseHistory(GoodsHistory goodsHistory)
    {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,null,"com.vcampus.server.shop.ShopServer.insertGoodsHistory",
                        new Object[]{goodsHistory}).send())
                .getReturn(Boolean.class);
    }

    public static int getMonthSum(int month)
    {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,null,"com.vcampus.server.shop.ShopAdminServer.getMonthSum",
                        new Object[]{month}).send())
                .getReturn(Integer.class);
    }

    public static BigDecimal getMonthSaleMoney(int month)
    {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,null,"com.vcampus.server.shop.ShopAdminServer.getMonthSaleMoney",
                        new Object[]{month}).send())
                .getReturn(BigDecimal.class);
    }
}