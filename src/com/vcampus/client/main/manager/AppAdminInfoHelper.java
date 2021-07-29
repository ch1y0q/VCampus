package com.vcampus.client.main.manager;

import com.alee.api.annotations.NotNull;
import com.vcampus.client.main.App;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.util.HashMap;

/**
 * @author Dong Ruojing
 * @date 2021/7/29
 */
public class AppAdminInfoHelper {
    @NotNull
    //修改电话
    public static Boolean resetPhoneNumber(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppAdminInfo.resetPhoneNumber",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }

    //修改邮箱
    public static Boolean resetEmail(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppAdminInfo.resetEmail",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    //修改密码
    public static Boolean resetPassword(HashMap map){
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppAdminInfo.resetPassword",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
}
