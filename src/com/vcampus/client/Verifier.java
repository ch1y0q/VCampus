package com.vcampus.client;

import com.vcampus.entity.*;
import com.vcampus.net.Request;
import com.vcampus.util.StringUtils;
import com.vcampus.client.main.App;
import com.vcampus.util.ResponseUtils;

/**
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class Verifier {
    public static Student verifyStudent(String cardNumber, String password) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.auth.Auth.studentLoginChecker",
                        new Object[] { new Student(cardNumber, password) }).send())
                .getReturn(Student.class);
    }
/*
    public static Teacher verifyTeacher(String cardNumber, String password) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.auth.Auth.teacherLoginChecker",
                        new Object[] { new Student(cardNumber, null, OtherUtils.getMD5(password), null) }).send())
                .getReturn(Teacher.class);
    }

    public static Manager verifyManager(String cardNumber, String password) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.auth.Auth.managerLoginChecker",
                        new Object[] { new Student(cardNumber, null, OtherUtils.getMD5(password), null) }).send())
                .getReturn(Manager.class);
    }
*/
}
