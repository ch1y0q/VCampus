package com.vcampus.client.main.library.ManagerLibrary;

import com.vcampus.client.main.App;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.util.HashMap;
/**
 * @author Xiao Kaijie
 * @date 2021-07-19
 */
public class ManlibdetailHelper {
    public static Boolean resetTabsByISBN(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.library.BookServer.resetTabsByISBN",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    public static Boolean resetNumByISBN(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.library.BookServer.resetNumByISBN",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
    public static Boolean resetPlaceByISBN(HashMap map) {
        return ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer,
                        null, "com.vcampus.server.library.BookServer.resetPlaceByISBN",
                        new Object[]{map}).send())
                .getReturn(Boolean.class);
    }
}
