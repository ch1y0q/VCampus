package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
/**
 * @author Xiao Kaijie
 * @date 2021-07-20
 */
public class StuCategory extends JTree{
    public JTree jt;
    public JTree init () {
        DefaultMutableTreeNode nodLogin= new DefaultMutableTreeNode("学生登陆");
        jt=new JTree(nodLogin);
        DefaultMutableTreeNode nodPersonalInfo = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode nodLibrary = new DefaultMutableTreeNode("图书馆");
        DefaultMutableTreeNode nodCourses = new DefaultMutableTreeNode("课程管理");
        DefaultMutableTreeNode nodLivingServices = new DefaultMutableTreeNode(   "生活服务");
        DefaultMutableTreeNode nodShop = new DefaultMutableTreeNode(   "网上商店");
        nodLogin.add(nodPersonalInfo);
        nodLogin.add(nodCourses);
        nodLogin.add(nodLibrary);
        nodLogin.add(nodLivingServices);
        nodLogin.add(nodShop);

        DefaultMutableTreeNode nodInfoLookup = new DefaultMutableTreeNode("个人信息查询");
        DefaultMutableTreeNode nodInfoManage = new DefaultMutableTreeNode("个人信息维护");
        nodPersonalInfo.add(nodInfoLookup);
        nodPersonalInfo.add(nodInfoManage);
        DefaultMutableTreeNode nodBorrowLookup = new DefaultMutableTreeNode("借阅查询");
        DefaultMutableTreeNode nodBookLookup = new DefaultMutableTreeNode("书籍查询");
        DefaultMutableTreeNode nodBorrowHistory = new DefaultMutableTreeNode("借阅历史");
        nodLibrary.add(nodBorrowLookup);
        nodLibrary.add(nodBookLookup);
        nodLibrary.add(nodBorrowHistory);
        DefaultMutableTreeNode nodTimetable = new DefaultMutableTreeNode("课表");
        DefaultMutableTreeNode nodGrades = new DefaultMutableTreeNode("成绩查询");
        DefaultMutableTreeNode nodChooseCourses = new DefaultMutableTreeNode("选课");
        nodCourses.add(nodTimetable);
        nodCourses.add(nodGrades);
        nodCourses.add(nodChooseCourses);
        DefaultMutableTreeNode nodCard = new DefaultMutableTreeNode("一卡通");
        DefaultMutableTreeNode nodDormManage = new DefaultMutableTreeNode("宿舍管理");
        nodLivingServices.add(nodCard);
        nodLivingServices.add(nodDormManage);
        DefaultMutableTreeNode nodGoods = new DefaultMutableTreeNode("商品列表");
        DefaultMutableTreeNode nodCart = new DefaultMutableTreeNode("购物车");
        DefaultMutableTreeNode nodShoppingHistoty = new DefaultMutableTreeNode("购买历史");
        nodShop.add(nodGoods);
        nodShop.add(nodCart);
        nodShop.add(nodShoppingHistoty);

        TreeSelectionModel treeSelectionModel;
        treeSelectionModel=jt.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!jt.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                    if(node==nodPersonalInfo||node==nodInfoLookup||node==nodInfoManage){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppStuInfo")
                        {
                            AppStuInfo app=new AppStuInfo();
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodLibrary||node==nodBorrowLookup||node==nodBookLookup||node==nodBorrowHistory){
                        if(this.getClass().getName()!="com.vcampus.client.main.StuLibrary") {
                            StuLibrary app = new StuLibrary();
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodCourses||node==nodTimetable||node==nodGrades||node==nodChooseCourses){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppStuCourse") {
                            AppStuCourse app = new AppStuCourse();
                            //setVisible(false);
                        }
                    }
                    else if(node==nodLivingServices||node==nodCard||node==nodDormManage){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppLife") {
                            AppLife app = new AppLife();
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodShop||node==nodGoods||node==nodCart||node==nodShoppingHistoty){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppShop") {
                            AppShop app = new AppShop();
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                }
            }
        });
        return jt;
}
}

