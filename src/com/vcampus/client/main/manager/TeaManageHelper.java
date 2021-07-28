package com.vcampus.client.main.manager;

import com.vcampus.client.main.App;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.util.HashMap;

public class TeaManageHelper {
    public static Boolean resetTeacherNumberByCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.TeacherManage.resetTeacherNumberByCard",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    public static Boolean resetSchoolByCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.TeacherManage.resetSchoolByCard",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    public static Boolean resetTeacherRankByCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.TeacherManage.resetTeacherRankByCard",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
}
