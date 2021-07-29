package com.vcampus.server.chat;


import com.vcampus.util.ServerUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器聊天相关的接口。
 *
 * @author Huang Qiyue
 * @date 2021-07-29
 */

public class ChatService {

    public interface OnSocketAcceptListener {
        void onSocketAccept(Socket socket);
    }

    private ClientManager clientManager = null;
    private OnSocketAcceptListener onAcceptListener = null;
    private ServerSocket serverSocket = null;

    public ChatService(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public void setOnAcceptListener(OnSocketAcceptListener listener) {
        onAcceptListener = listener;
    }

    public void startup() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runStartup();
            }

        });
        thread.start();
    }

    public void shutdown() {
        try {
            clientManager.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runStartup() {
        try {
            serverSocket = new ServerSocket(Integer.parseInt(ServerUtils.getChatPort()));
            while (true) {
                Socket socket = serverSocket.accept();
                if (onAcceptListener != null) {
                    onAcceptListener.onSocketAccept(socket);
                }

                clientManager.addClientSocket(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
