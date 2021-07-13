package com.vcampus.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.alibaba.fastjson.JSON;

import com.vcampus.server.App;

/**
 * 端口请求监听器
 *
 * @author Franklin Yang
 * @date 2021/7/9
 */
public class RequestListener extends Thread{
    private int port;//端口
    private ServerSocket serverSocket;

    public RequestListener(){

    }
    public RequestListener(int port) {this.port=port;}

    @Override
    public void run(){
        try{
            serverSocket = new ServerSocket(this.port);
            //处理连接请求
            while(true){
                Socket socket= serverSocket.accept();
                if (socket!=null){
                    ConnectionToClient connectionToThisClient=new ConnectionToClient(socket);
                    //建立专门用来处理该用户请求的线程
                    App.appendLog("连接已建立，标识码为：" + connectionToThisClient.hashCode());
                    new Thread() {
                        @Override
                        public void run() {
                            String line;
                            while ((line = connectionToThisClient.readLine()) != null) {
                                Request req = JSON.parseObject(line, Request.class);
                                // 设置响应回送位置
                                req.setConnectionToClient(connectionToThisClient);
                                // 将请求放入消息队列，等待消费
                                App.requestQueue.produce(req);
                            }
                        }
                    }.start();
                }
            }
        }catch (SocketException se){
            System.err.println("有Socket连接被重置");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
