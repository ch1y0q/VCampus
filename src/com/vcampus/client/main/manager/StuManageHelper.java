package com.vcampus.client.main.manager;

import com.vcampus.client.main.App;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.util.HashMap;
/**
 * 学生信息管理相关助手类
 * @author Xiao Kaijie
 * @date 2021-07-19
 */
public class StuManageHelper {
    public static Boolean resetStudentNumberByCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.StudentManage.resetStudentNumberByCard",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    public static Boolean resetSchoolByCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.StudentManage.resetSchoolByCard",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    public static Boolean resetDormByCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.StudentManage.resetDormByCard",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
}
