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

    /**
     * 获取ResponseQueue实例
     * @return ResponseQueue实例
     */
    public static ResponseQueue getInstance() {
        return responseQueue;
    }

    /**
     * Map: Hash -> Response
     */
    private Map<String, Response> mp;

    /**
     * 构造函数
     */
    protected ResponseQueue() {
        mp = new HashMap<>();
    }

    /**
     * 向队列加入一个请求
     * @param response 要加入的请求
     */
    public void produce(Response response) {
        mp.put(response.getHash(), response);
    }

    /**
     * 从队列取出一个请求
     * @param hashCode 请求对应的HashCode
     */
    public Response consume(String hashCode) {
        Response response = mp.get(hashCode);
        mp.remove(hashCode);
        return response;
    }

    /**
     * 检查队列是否含有某个请求
     * @param hash 请求对应的HashCode
     * @return 是否包含该请求
     */
    public boolean contain(String hash) {
        return mp.containsKey(hash);
    }

    @Override
    public String toString(){
        return mp.toString();
    }
}
