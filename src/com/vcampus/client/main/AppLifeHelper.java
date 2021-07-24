package com.vcampus.client.main;

import com.vcampus.entity.Student;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.util.HashMap;

public class AppLifeHelper {
    public static float chargeCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.chargeCard",
                        new Object[]{map}).send())
                .getReturn(float.class);
    }
}
