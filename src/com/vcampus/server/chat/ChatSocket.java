package com.vcampus.server.chat;

/**
 * @author Huang Qiyue
 * @date 2021-07-29
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 在线聊天所需的Socket网络服务类
 */
public class ChatSocket{
    public interface Callback {
        void onReadSocket(ChatSocket chatSocket, String msg);
        void onError(ChatSocket chatSocket, String error);
    }

    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;
    private Callback callback;

    public DataInputStream getInputStream() {
        return inputStream;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }

    public ChatSocket(Socket socket, Callback callback) {
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.callback = callback;
    }

    /**
     *  向客户端发送数据
     * @param send 要发送的数据
     */
    public void send(String send) {
        try {
            outputStream.writeUTF(send);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Thread thread = new Thread(() -> {
            String accept;
            while (true) {
                try {
                    accept = inputStream.readUTF();
                    if (callback != null) {
                        callback.onReadSocket(ChatSocket.this, accept);
                    }
                } catch (IOException e) {
                    if (callback != null) {
                        callback.onError(ChatSocket.this, e.getMessage());
                    }
                }
            }
        });
        thread.start();
    }

    public void close() throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
    }

}
