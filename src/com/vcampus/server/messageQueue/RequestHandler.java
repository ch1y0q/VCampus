package com.vcampus.server.messageQueue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Method;

import com.vcampus.net.Request;
import com.vcampus.net.Response;
import com.vcampus.server.App;
import com.vcampus.util.JSONUtils;

/**
 * 使用反射来处理消息队列中的请求
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */

public class RequestHandler extends Thread{
    @Override
    public void run() {
        while (true) {
            if (App.requestQueue.hasNext()) {
                // 消费顶端请求
                Request req = App.requestQueue.consume();
                // 获取请求处理函数
                String targetApi = req.getTargetApi();
                // 取出方法名和全类名
                String[] parts = targetApi.split("\\.");
                String methodName = parts[parts.length - 1];
                String fullClassName = targetApi.substring(0, targetApi.length() - methodName.length() - 1);
                // 调用函数
                Class<?> clazz;
                try {
                    clazz = Class.forName(fullClassName);
                    // 获取参数类型
                    Class<?>[] paramTypes = null;
                    Method[] methods = clazz.getMethods();
                    // 扫描所有方法
                    for (int i = 0; i < methods.length; i++) {
                        if (methods[i].getName().equals(methodName)) {
                            Class<?>[] params = methods[i].getParameterTypes();
                            paramTypes = new Class[params.length];
                            for (int j = 0; j < params.length; j++) {
                                paramTypes[j] = Class.forName(params[j].getName());
                            }
                            break;
                        }
                    }
                    // 调用方法（接口），获取返回值。接口必须是静态的
                    Method method = clazz.getMethod(methodName, paramTypes);
                    Object ret = null;
                    if (req.getParams() == null) {
                        ret = method.invoke(null);
                    } else {
                        Object[] processedParams = new Object[paramTypes.length];
                        for (int i = 0; i < req.getParams().length; i++) {
                            if (JSONUtils.isBasicClass(paramTypes[i])) {
                                processedParams[i] = paramTypes[i].cast(req.getParams()[i]);
                            } else {
                                JSONObject temp = (JSONObject) req.getParams()[i];
                                processedParams[i] = JSON.parseObject(temp.toJSONString(), paramTypes[i]);
                            }
                        }
                        if(processedParams == null) ret = method.invoke(null);  // no params passed
                        else ret = method.invoke(null, processedParams);
                    }
                    App.appendLog("调用了接口：" + methodName);
                    // 组织并发送响应
                    new Response(
                            req.getConnectionToClient(), req.getHash(), req.getTargetApi(), ret
                    ).send();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
