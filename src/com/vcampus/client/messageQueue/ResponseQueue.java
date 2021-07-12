package com.vcampus.client.messageQueue;

import com.vcampus.net.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户端的请求消息队列
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class ResponseQueue {

    private static ResponseQueue responseQueue = new ResponseQueue();
    public static ResponseQueue getInstance() {
        return responseQueue;
    }

    private Map<String, Response> mp; // Map: Hash -> Response

    protected ResponseQueue() {
        mp = new HashMap<>();
    }

    public void produce(Response response) {
        mp.put(response.getHash(), response);
    }

    public Response consume(String hashCode) {
        Response response = mp.get(hashCode);
        mp.remove(hashCode);
        return response;
    }

    public boolean contain(String hash) {
        return mp.containsKey(hash);
    }

}
