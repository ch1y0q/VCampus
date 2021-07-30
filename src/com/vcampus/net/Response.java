package com.vcampus.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.vcampus.util.JSONUtils;

/**
 * 响应类
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class Response {

    private ConnectionToClient connectionToClient; // 服务器到客户端的连接
    private String hash; // 与请求对应的哈希码
    private String fromApi; // 响应的Api
    private Object param; // 响应内容（业务数据）

    public Response() {
    }

    /**
     * 完整的构造函数
     * @param connectionToClient 通向客户端的连接
     * @param hash 标识码
     * @param fromApi 来源接口
     * @param param 参数
     */
    public Response(ConnectionToClient connectionToClient, String hash, String fromApi, Object param) {
        super();
        this.connectionToClient = connectionToClient;
        this.hash = hash;
        this.fromApi = fromApi;
        this.param = param;
    }

    // 获取单体业务数据
    public <T> T getReturn(Class<T> clazz) {

        // 该方法不处理List和Map型Clazz
        if (clazz == List.class || clazz == Map.class) {
            System.err.println("[Response.getReturn] List and/or Map class type can't be used in getReturn(Class<T> clazz).");
        }

        if (this.param == null) {
            System.err.println("No param passed...");
            return null;
        }

        if (JSONUtils.isBasicClass(clazz)) {
            // 基本类型，不解析
            return clazz.cast(this.param);
        } else {
            // 自定义类，嵌套解析
            JSONObject temp = (JSONObject) this.param;
            return JSON.parseObject(temp.toJSONString(), clazz);
        }

    }

    /**
     * 获取列表型业务数据
     * @param elementClazz 欲获取响应数据的类型对应的类
     * @return 列表型业务数据
     */
    public <T> List<T> getListReturn(Class<T> elementClazz) {

        if (this.param == null) {
            return null;
        }

        JSONArray tempParam = (JSONArray) this.param;

        List<Object> unparsedList = JSON.parseArray(tempParam.toJSONString());
        List<T> processedList = new ArrayList<T>();

        // 基本类型，不解析
        if (JSONUtils.isBasicClass(elementClazz)) {
            for (int i = 0; i < unparsedList.size(); i++) {
                processedList.add(elementClazz.cast(unparsedList.get(i)));
            }
        } else {
            // 处理嵌套类型
            for (int i = 0; i < unparsedList.size(); i++) {
                JSONObject jsonObject = (JSONObject) unparsedList.get(i);
                processedList.add((T) JSON.parseObject(jsonObject.toJSONString(), elementClazz));
            }
        }

        return processedList;

    }

    /**
     * 获取Map型业务数据
     * @param valueClazz 欲获取的业务数据相应的类
     * @return Map型的响应对象
      */
    public <T> Map<String, T> getMapReturn(Class<T> valueClazz) {

        if (this.param == null) {
            return null;
        }

        JSONObject tempParam = (JSONObject) this.param;
        Map<String, Object> unparsedMap = JSON.parseObject(tempParam.toJSONString());
        Map<String, T> processedMap = new HashMap<>();

        // 基本类型，不解析
        if (JSONUtils.isBasicClass(valueClazz)) {
            for (String key : unparsedMap.keySet()) {
                processedMap.put(key, valueClazz.cast(unparsedMap.get(key)));
            }
        } else {
            // 处理嵌套类型
            for (String key : unparsedMap.keySet()) {
                JSONObject jsonObject = (JSONObject) unparsedMap.get(key);
                processedMap.put(key, (T) JSON.parseObject(jsonObject.toJSONString(), valueClazz));
            }
        }

        return processedMap;

    }


    // 组装JSON发送到客户端
    public void send() {
        String json = JSON.toJSONString(this);
        this.connectionToClient.write(json);
    }

    public ConnectionToClient getConnectionToClient() {
        return connectionToClient;
    }

    public void setConnectionToClient(ConnectionToClient connectionToClient) {
        this.connectionToClient = connectionToClient;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFromApi() {
        return fromApi;
    }

    public void setFromApi(String fromApi) {
        this.fromApi = fromApi;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Response [connectionToClient=" + connectionToClient + ", hash=" + hash + ", fromApi=" + fromApi + ", param="
                + param + "]";
    }
}
