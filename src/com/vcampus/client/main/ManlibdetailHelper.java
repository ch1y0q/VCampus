package com.vcampus.client.main;

import com.vcampus.entity.Book;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import java.util.HashMap;

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
