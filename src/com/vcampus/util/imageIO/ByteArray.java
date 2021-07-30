package com.vcampus.util.imageIO;

/**
 *
 * 实现图像传输
 * @author Dong Ruojing
 * @date 2021/7/26
 */
public class ByteArray implements java.io.Serializable{


    private static final long serialVersionUID = 1L;
    private byte[] imageData;

    public ByteArray(){
        imageData = null;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

}