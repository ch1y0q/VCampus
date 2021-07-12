package com.vcampus.net;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端到服务端的连接类
 *
 * @author Franklin Yang
 * @date 2021/7/9
 */
public class ConnectionToServer extends Connection {
    public ConnectionToServer(Socket socket) {
        super(socket);
    }

    @Override
    public void write(String content) {
        synchronized (ConnectionToServer.class) {
            this.pWriter.write(content + "\n");
            this.pWriter.flush();
        }
    }

    @Override
    public synchronized String readLine() {
        // readLine本身就是阻塞的，无需同步
        try {
            return this.bReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
