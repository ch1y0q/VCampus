package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
/**
 * @author Xiao Kaijie
 * @date 2021-07-13
 */
public class TeaCategory extends JTree {
    public JTree init(){
        DefaultMutableTreeNode nodLogin= new DefaultMutableTreeNode("教师登陆");
        DefaultMutableTreeNode nodPersonalInfo = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode nodChooseCourses = new DefaultMutableTreeNode("课程管理");
        DefaultMutableTreeNode nodGrades = new DefaultMutableTreeNode("成绩录入");
        DefaultMutableTreeNode nodLibrary = new DefaultMutableTreeNode("图书馆");
        DefaultMutableTreeNode nodCard = new DefaultMutableTreeNode("生活管理");
        DefaultMutableTreeNode nodShop = new DefaultMutableTreeNode(   "网上商店");
        nodLogin.add(nodPersonalInfo);nodLogin.add(nodChooseCourses);nodLogin.add(nodGrades);
        nodLogin.add(nodLibrary);nodLogin.add(nodCard);nodLogin.add(nodShop);


        DefaultMutableTreeNode nodGoods = new DefaultMutableTreeNode("商品列表");
        DefaultMutableTreeNode nodCart = new DefaultMutableTreeNode("购物车");
        DefaultMutableTreeNode nodShoppingHistoty = new DefaultMutableTreeNode("购买历史");
        nodShop.add(nodGoods); nodShop.add(nodCart); nodShop.add(nodShoppingHistoty);

        JTree jt = new JTree(nodLogin);

        TreeSelectionModel treeSelectionModel;
        treeSelectionModel=jt.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!jt.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                    if(node==nodPersonalInfo){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppTeaInfo")
                        {
                            AppTeaInfo app=new AppTeaInfo();
                            setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodLibrary){
                        if(this.getClass().getName()!="com.vcampus.client.main.StuLibrary") {
                            StuLibrary app = new StuLibrary();
                            setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodGrades||node==nodChooseCourses){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppStuCourse") {
                            AppTeaCourse app = new AppTeaCourse();
                            setVisible(false);
                        }
                    }
                    else if(node==nodCard){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppLife") {
                            AppLife app = new AppLife();
                            setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodShop||node==nodGoods||node==nodCart||node==nodShoppingHistoty){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppShopTeacher") {
                            AppShopTeacher app = new AppShopTeacher();
                            setVisible(false);
                            app.setVisible(true);
                        }
                    }
                }
                }
        });
        return jt;
    }

}
