package com.vcampus.UI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dong Ruojing
 * @date 2021/7/28
 */
public class myJLabel3 extends JLabel {
    public  myJLabel3(){
        DropShadowBorder shadow = new DropShadowBorder();
        shadow.setShadowSize(10);
        //shadow.setShadowColor(Color.BLACK);
        shadow.setShowLeftShadow(true);
        shadow.setShowRightShadow(true);
        shadow.setShowBottomShadow(true);
        shadow.setShowTopShadow(true);
        shadow.setShadowColor(new Color(243, 238, 188, 230));
        shadow.setCornerSize(10);//默认12
        shadow.setShadowOpacity((float) 0.55);//透明度为0-1的浮点数
        //System.out.println(shadow.getShadowOpacity());
        //System.out.println(shadow.getCornerSize());
        this.setBorder(shadow);
    }
}