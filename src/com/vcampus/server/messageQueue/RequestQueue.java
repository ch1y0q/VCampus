package com.vcampus.server.messageQueue;

import java.util.Vector;
import com.vcampus.net.Request;
import com.vcampus.server.App;

/**
 * 以生产者——消费者方式实现服务器端请求消息队列
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class RequestQueue {
    private static RequestQueue requestQueue = new RequestQueue();

    public static RequestQueue getInstance() {
        return requestQueue;
    }

    private Vector<Request> vec;

    protected RequestQueue() {
        vec = new Vector<>();
    }

    //生产
    public void produce(Request request) {
        vec.add(request);
        App.appendLog("生产了一个请求, hash=" + request.getHash());
    }

    //消费
    public Request consume() {
        Request request = vec.get(0);
        vec.remove(0);
        App.appendLog("消费了一个请求，hash=" + request.getHash());
        return request;
    }

    public boolean hasNext() {
        return vec.size() > 0;
    }
}
