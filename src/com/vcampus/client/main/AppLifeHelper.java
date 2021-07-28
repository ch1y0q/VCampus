package com.vcampus.client.main;

import com.alee.api.annotations.NotNull;
import com.vcampus.entity.DealHistory;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 生活服务需要用到的工具类。
 *
 * @author Huang Qiyue
 * @date 2021-07-24
 */
public class AppLifeHelper {
    @NotNull
    public static BigDecimal chargeCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.bank.BankServer.chargeStudentCard",
                        new Object[]{map}).send())
                .getReturn(BigDecimal.class);
    }

    public static BigDecimal setBalance(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.bank.BankServer.setStudentBalance",
                        new Object[]{map}).send())
                .getReturn(BigDecimal.class);
    }
    public static String lossJudge(String string){
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.lossJudge",
                        new Object[]{string}).send())
                .getReturn(String.class);
    }

    public static String foundJudge(String string){
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.foundJudge",
                        new Object[]{string}).send())
                .getReturn(String.class);
    }

    public static Boolean insertDealHistory(String cardNumber,BigDecimal dealAmount,String dealType) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.bank.BankServer.insertDealHistory",
                        new Object[]{new DealHistory(cardNumber,dealAmount,dealType)}).send())
                .getReturn(Boolean.class);

    }

}
