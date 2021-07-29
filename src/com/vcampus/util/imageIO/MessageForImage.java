package com.vcampus.util.imageIO;

/**
 * @author Dong Ruojing
 * @date 2021/7/27
 */

public class MessageForImage implements java.io.Serializable{
    private String cardNumber;
    private ByteArray byteArray;
    static public String IP;
    public MessageForImage(String _cardNumber) {
        cardNumber = _cardNumber;
        setByteArray(new ByteArray());
    }
    public void setByteArray(ByteArray _byteArray) {
        this.byteArray = _byteArray;
    }
    public String getIP() {
        return IP;
    }
}
