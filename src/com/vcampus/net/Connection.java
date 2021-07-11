package com.vcampus.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 数据传输通道
 *
 * @author Franklin Yang
 * @date 2021/7/9
 */

public abstract class Connection {
    protected Socket socket;
    protected PrintWriter pWriter;
    protected BufferedReader bReader;

    //连接的初始化
    public Connection(Socket socket){
        super();
        this.socket=socket;

        if (this.socket==null||!this.socket.isConnected())
        {
            return;
        }
        try {
            this.pWriter = new PrintWriter
                    (new OutputStreamWriter(this.socket.getOutputStream(), "UTF-8"));
            this.bReader = new BufferedReader
                    (new InputStreamReader(this.socket.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //写一段数据到socket上
    public abstract void write(String content);

    //从socket读取一段数据
    public abstract String readLine();

    //连接的销毁
    public void destroy(){
        try{
            pWriter.close();
            bReader.close();
            socket.close();
            pWriter=null;
            bReader=null;
            socket=null;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Connection [socket="+socket+", pWriter="+pWriter+", bReader="+bReader+"]";
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getpWriter() {
        return pWriter;
    }

    public void setpWriter(PrintWriter Writer) {
        this.pWriter = pWriter;
    }

    public BufferedReader getbReader() {
        return bReader;
    }

    public void setbReader(BufferedReader bReader) {
        this.bReader = bReader;
    }
}
