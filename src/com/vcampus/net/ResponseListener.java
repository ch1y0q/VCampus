package com.vcampus.net;

import com.alibaba.fastjson.JSON;
import com.vcampus.client.main.*;

import com.vcampus.client.main.App;

/**
 * 响应监听器
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class ResponseListener extends Thread {
    private ConnectionToServer connectionToServer;

    public ResponseListener() {
    }

    public ResponseListener(ConnectionToServer connectionToServer) {
        this.connectionToServer = connectionToServer;
    }

    @Override
    public void run() {
        String line;
        while ((line = connectionToServer.readLine()) != null) {
            Response response = JSON.parseObject(line, Response.class);
            App.responseQueue.produce(response);
        }
    }
}
