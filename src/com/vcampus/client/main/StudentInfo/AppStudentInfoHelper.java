package com.vcampus.client.main.StudentInfo;

import com.alee.api.annotations.NotNull;
import com.vcampus.client.main.App;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 将哈希表和学生信息连接起来
 * @author Dong Ruojing
 * @date 2021/7/26
 */
public class AppStudentInfoHelper {
    @NotNull
    //修改电话
    public static Boolean resetPhoneNumber(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppStuInfo.resetPhoneNumber",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }

    //修改邮箱
    public static Boolean resetEmail(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppStuInfo.resetEmail",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    //修改密码
    public static Boolean resetPassword(HashMap map){
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppStuInfo.resetPassword",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
}
