package com.vcampus.client.main;

import com.alee.api.annotations.NotNull;
import com.vcampus.entity.Student;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.math.BigDecimal;
import java.util.HashMap;

public class AppLifeHelper {
    @NotNull
    public static BigDecimal chargeCard(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null, "com.vcampus.server.AppLife.chargeCard",
                        new Object[]{map}).send())
                .getReturn(BigDecimal.class);
    }
}
