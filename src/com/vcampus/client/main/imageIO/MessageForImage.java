package com.vcampus.client.main.imageIO;

/**
 * @author Dong Ruojing
 * @date 2021/7/27
 */
public class MessageForImage implements java.io.Serializable{
    private String _cardNumber;
    private ByteArray _byteArray;
    static public String _IP;
    public MessageForImage(String Ecard) {
        _cardNumber = Ecard;
        setByteArray(new ByteArray());
    }
    public void setByteArray(ByteArray _byteArray) {
        this._byteArray = _byteArray;
    }
    public String getIP() {
        return _IP;
    }
}
