package com.vcampus.client;

import com.vcampus.entity.*;
import com.vcampus.net.Request;
import com.vcampus.util.StringUtils;
import com.vcampus.client.main.App;
import com.vcampus.util.ResponseUtils;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * 向服务器发送验证请求所需的工具类
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class Verifier {
    public static Student checkStudent(String cardNumber, String password) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.Auth.studentLoginChecker",
                        new Object[] { new Student(cardNumber, password) }).send())
                .getReturn(Student.class);
    }

    public static Teacher checkTeacher(String cardNumber, String password) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.Auth.teacherLoginChecker",
                        new Object[] { new Teacher(cardNumber, password) }).send())
                .getReturn(Teacher.class);
    }

    public static Admin checkAdmin(String cardNumber, String password) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.Auth.adminLoginChecker",
                        new Object[] { new Student(cardNumber,password) }).send())
                .getReturn(Admin.class);
    }

}
