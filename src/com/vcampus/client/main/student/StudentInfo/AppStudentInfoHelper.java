package com.vcampus.client.main.student.StudentInfo;

import com.alee.api.annotations.NotNull;
import com.vcampus.client.main.App;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.util.HashMap;

/**
 * 将哈希表和学生信息连接起来
 * @author Dong Ruojing
 * @date 2021/7/26
 */
public class AppStudentInfoHelper {

    /**
     * 修改学生手机号码
     * @param map {cardNumber, phoneNumber}
     * @return 操作的结果
     */
    @NotNull
    public static Boolean resetPhoneNumber(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppStuInfo.resetPhoneNumber",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }

    /**
     * 修改学生邮箱
     * @param map {cardNumber, email}
     * @return 操作的结果
     */
    public static Boolean resetEmail(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppStuInfo.resetEmail",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }

    /**
     * 修改学生手机号码
     * @param map {cardNumber, password}
     * @return 操作的结果
     */
    public static Boolean resetPassword(HashMap map){
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.AppStuInfo.resetPassword",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
}
