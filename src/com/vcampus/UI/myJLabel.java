package com.vcampus.UI;

import javax.swing.*;
import java.awt.*;
import com.vcampus.UI.DropShadowBorder;
/**
 * 自定义label，可设置shadow
 * @author Dong Ruojing
 * @date 2021/7/24
 */
public class myJLabel extends JLabel {
    public  myJLabel(){
        DropShadowBorder shadow = new DropShadowBorder();
        shadow.setShadowSize(20);
        //shadow.setShadowColor(Color.BLACK);
       shadow.setShowLeftShadow(true);
        shadow.setShowRightShadow(true);
        shadow.setShowBottomShadow(true);
        shadow.setShowTopShadow(true);
       shadow.setShadowColor(new Color(0, 0, 0));
       shadow.setCornerSize(10);//默认12
       shadow.setShadowOpacity((float) 0.85);//透明度为0-1的浮点数
        System.out.println(shadow.getShadowOpacity());
        System.out.println(shadow.getCornerSize());
        this.setBorder(shadow);
    }
}
