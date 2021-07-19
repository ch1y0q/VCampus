package com.vcampus.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 服务器工具
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public final class ServerUtils {
    final static String CONFIG_PATH = "/resources/server.properties";

    //返回服务器地址
    public static String getServerHost() {
        Properties prop = new Properties();
        try {
            prop.load(ServerUtils.class.getResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty("server_host");
    }

    //返回主端口号
    public static String getMainPort() {
        Properties prop = new Properties();
        try {
            prop.load(ServerUtils.class.getResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty("mainport");
    }

    //返回对话端口号
    public static String getChatPort() {
        Properties prop = new Properties();
        try {
            prop.load(ServerUtils.class.getResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty("chatport");
    }
}
