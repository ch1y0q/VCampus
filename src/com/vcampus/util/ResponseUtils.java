package com.vcampus.util;

import java.util.Date;

import com.vcampus.client.messageQueue.ResponseQueue;
import com.vcampus.net.Response;

/**
 * 响应工具
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public final class ResponseUtils {
    static final long TIMEOUT_MS = 5000;

    @Deprecated
    /**
     * 阻塞并等待响应
     * @see `getResponseByHash` might be better
     */
    public final static void blockAndWaitResponse(String hash) {
        while (!ResponseQueue.getInstance().contain(hash)) {
            if (ResponseQueue.getInstance().contain(hash)) {
                break;
            }
        }
    }

    /**
     * 阻塞并获取具体响应，支持超时中断
     */

    public static Response getResponseByHash(String hash) {
        // support timeout
        long shouldEnd = new Date().getTime() + TIMEOUT_MS;
        boolean hasResponse = false;
        while (!hasResponse) {
            hasResponse = ResponseQueue.getInstance().contain(hash);
            if (new Date().getTime() >= shouldEnd) {
                if (hasResponse = ResponseQueue.getInstance().contain(hash)) {
                    break;
                }

                SwingUtils.showError(null, "请求超时！Hash=" + hash, "错误");
                return null;
            }
        }
        return ResponseQueue.getInstance().consume(hash);

    }
}
