package com.vcampus.client.main.imageIO;

/**
 * @author Dong Ruojing
 * @date 2021/7/27
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    /*	public static void main(String[] args) throws ClassNotFoundException {
            Person person = new Person();
            new TestClient().start(1101, person);
        }
    */
    @SuppressWarnings("finally")
    public MessageForImage start(MessageForImage clientobj)
            throws ClassNotFoundException {
        Object obj = null;
        try {
            Socket socket = new Socket(clientobj.getIP(), 7775);
            ObjectOutputStream oos = new ObjectOutputStream(
                    socket.getOutputStream());// 建立输出流，向服务器端输出
            ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(socket.getInputStream()));// 建立输入流，接收服务器端发送的信息

            // 输入对象, 一定要flush（）
            oos.writeObject((MessageForImage) clientobj);// 用输出流把对象传递到服务器
            oos.flush();
            obj = ois.readObject();// 读取输入流所接收的对象

            ois.close();
            oos.close();
            socket.close();
        } catch (UnknownHostException e) {
            //JOptionPane.showMessageDialog(null, "Error:登入失败，请查看网络是否正常！");
            e.printStackTrace();
        } catch (IOException e) {
           // JOptionPane.showMessageDialog(null, "Error:登入失败，请查看网络是否正常！");
            e.printStackTrace();
        } finally {
            return (MessageForImage) obj;
        }
    }
}

