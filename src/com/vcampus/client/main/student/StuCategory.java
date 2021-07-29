package com.vcampus.client.main.student;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppLife;
import com.vcampus.client.main.courseManage.AppStuCourse;
import com.vcampus.client.main.dailyReport.AppDailyReport;
import com.vcampus.client.main.student.StudentInfo.AppStuInfo;
import com.vcampus.client.main.library.StuLibrary;
import com.vcampus.client.main.shop.AppShop;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

/**
 * @author Xiao Kaijie
 * @date 2021-07-20
 */
public class StuCategory extends JTree{
    private JTree jt;
    private DefaultMutableTreeNode nodLogin;
    /* constructor */
    public StuCategory() {
        init();
    }

    /**
     * Build a JTree.
     */
    private void init() {
        nodLogin= new DefaultMutableTreeNode("学生登陆");
        jt=new JTree(nodLogin);
        DefaultMutableTreeNode nodPersonalInfo = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode nodLibrary = new DefaultMutableTreeNode("图书馆");
        DefaultMutableTreeNode nodCourses = new DefaultMutableTreeNode("课程管理");
        DefaultMutableTreeNode nodLivingServices = new DefaultMutableTreeNode(   "生活服务");
        DefaultMutableTreeNode nodShop = new DefaultMutableTreeNode(   "网上商店");
        DefaultMutableTreeNode nodDailyReport=new DefaultMutableTreeNode("每日上报");
        nodLogin.add(nodPersonalInfo);
        nodLogin.add(nodCourses);
        nodLogin.add(nodLibrary);
        nodLogin.add(nodLivingServices);
        nodLogin.add(nodShop);
        nodLogin.add(nodDailyReport);

        //DefaultMutableTreeNode nodInfoLookup = new DefaultMutableTreeNode("个人信息查询");
        DefaultMutableTreeNode nodInfoManage = new DefaultMutableTreeNode("个人信息维护");
        // nodPersonalInfo.add(nodInfoLookup);
        nodPersonalInfo.add(nodInfoManage);
        DefaultMutableTreeNode nodBorrowLookup = new DefaultMutableTreeNode("图书查询借阅");
        //DefaultMutableTreeNode nodBookLookup = new DefaultMutableTreeNode("书籍查询");
        DefaultMutableTreeNode nodBorrowHistory = new DefaultMutableTreeNode("已借图书");
        nodLibrary.add(nodBorrowLookup);
        // nodLibrary.add(nodBookLookup);
        nodLibrary.add(nodBorrowHistory);
        DefaultMutableTreeNode nodTimetable = new DefaultMutableTreeNode("课程表");
        DefaultMutableTreeNode nodGrades = new DefaultMutableTreeNode("成绩查询");
        DefaultMutableTreeNode nodChooseCourses = new DefaultMutableTreeNode("选课系统");
        DefaultMutableTreeNode nodChosenCourses = new DefaultMutableTreeNode("已选课程");
        nodCourses.add(nodTimetable);
        nodCourses.add(nodChooseCourses);
        nodCourses.add(nodGrades);
        nodCourses.add(nodChosenCourses);
        DefaultMutableTreeNode nodCard = new DefaultMutableTreeNode("一卡通");
        DefaultMutableTreeNode nodDormManage = new DefaultMutableTreeNode("宿舍管理");
        nodLivingServices.add(nodCard);
        nodLivingServices.add(nodDormManage);
        DefaultMutableTreeNode nodGoods = new DefaultMutableTreeNode("商品列表");
        DefaultMutableTreeNode nodCart = new DefaultMutableTreeNode("购物车");
        DefaultMutableTreeNode nodShoppingHistory = new DefaultMutableTreeNode("购买历史");
        nodShop.add(nodGoods);
        nodShop.add(nodCart);
        nodShop.add(nodShoppingHistory);

        TreeSelectionModel treeSelectionModel;
        treeSelectionModel=jt.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!jt.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                    if(node==nodPersonalInfo||node==nodInfoManage){//||node==nodInfoLookup
                        if(this.getClass().getName()!="com.vcampus.client.main.student.StudentInfo.AppStuInfo")
                        {
                            AppStuInfo app=new AppStuInfo();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodLibrary||node==nodBorrowLookup||node==nodBorrowHistory){//||node==nodBookLookup
                        if(this.getClass().getName()!="com.vcampus.client.main.StudentLibrary.StuLibrary") {
                            StuLibrary app = new StuLibrary();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodCourses||node==nodTimetable||node==nodGrades||node==nodChooseCourses
                            ||node==nodChosenCourses){
                        if(this.getClass().getName()!="com.vcampus.client.main.courseManage.AppStuCourse") {
                            AppStuCourse app = new AppStuCourse();
                            app.open();
                            setVisible(false);
                        }
                    }
                    else if(node==nodLivingServices||node==nodCard||node==nodDormManage){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppLife") {
                            AppLife app = new AppLife();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodShop||node==nodGoods||node==nodCart||node==nodShoppingHistory){
                        if(this.getClass().getName()!="com.vcampus.client.main.shop.AppShop") {
                            AppShop app = new AppShop();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodDailyReport){
                        if(this.getClass().getName()!="com.vcampus.client.main.dailyReport.AppDailyReport"){
                            WebLookAndFeel.install();
                            AppDailyReport app=new AppDailyReport();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                }
            }
        });
    }

    public JTree getJTree() {
        return jt;
    }

    public DefaultMutableTreeNode getNode() {
        return nodLogin;
    }
}

