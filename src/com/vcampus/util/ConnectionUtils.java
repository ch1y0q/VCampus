package com.vcampus.util;

import java.io.IOException;
import java.net.Socket;
import com.vcampus.net.*;

/**
 * 建立连接所需的工具
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class ConnectionUtils {
    public static String getServerHost() {
        return ServerUtils.getServerHost();
    }

    public static int getMainPort() {
        return Integer.parseInt(ServerUtils.getMainPort());
    }

    public static int getChatPort() {
        return Integer.parseInt(ServerUtils.getChatPort());
    }

    /**
     * 只应该被调用一次，connectionToServer作为长连接，在客户端整个生命周期内流动
     */
    public static ConnectionToServer formConnection() throws IOException {
        ConnectionToServer connectionToServer = null;

        connectionToServer = new ConnectionToServer(new Socket(ConnectionUtils.getServerHost(), ConnectionUtils.getMainPort()));
        /*
        try {
            connectionToServer = new ConnectionToServer(new Socket(Utils.getServerHost(), Utils.getMainPort()));
        } catch (Exception e) {
            return null;
        }
        */

        return connectionToServer;
    }
}

