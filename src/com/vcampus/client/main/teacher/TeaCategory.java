package com.vcampus.client.main.teacher;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppLife;
import com.vcampus.client.main.courseManage.AppTeaCourse;
import com.vcampus.client.main.dailyReport.AppDailyReport;
import com.vcampus.client.main.library.StuLibrary;
import com.vcampus.client.main.teacher.TeacherInfo.AppTeaInfo;
import com.vcampus.client.main.shop.AppShop;

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
    private JTree jt;
    private DefaultMutableTreeNode nodLogin;
    /* constructor */
    public TeaCategory() {
        init();
    }

    /**
     * Build a JTree.
     */
    private void init() {
        /* ALSO CHANGE in com.vcampus.client.main.TeacherFancyUI */
        nodLogin= new DefaultMutableTreeNode("教师登陆");
        jt=new JTree(nodLogin);
        DefaultMutableTreeNode nodPersonalInfo = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode nodChooseCourses = new DefaultMutableTreeNode("课程管理");
        DefaultMutableTreeNode nodGrades = new DefaultMutableTreeNode("成绩录入");
        DefaultMutableTreeNode nodLibrary = new DefaultMutableTreeNode("图书馆");
        DefaultMutableTreeNode nodCard = new DefaultMutableTreeNode("生活管理");
        DefaultMutableTreeNode nodShop = new DefaultMutableTreeNode("网上商店");
        DefaultMutableTreeNode nodDailyReport=new DefaultMutableTreeNode("每日上报");
        nodLogin.add(nodPersonalInfo);nodLogin.add(nodChooseCourses);nodLogin.add(nodGrades);
        nodLogin.add(nodLibrary);nodLogin.add(nodCard);nodLogin.add(nodShop);
        nodLogin.add(nodDailyReport);


        DefaultMutableTreeNode nodGoods = new DefaultMutableTreeNode("商品列表");
        DefaultMutableTreeNode nodCart = new DefaultMutableTreeNode("购物车");
        DefaultMutableTreeNode nodShoppingHistory = new DefaultMutableTreeNode("购买历史");
        nodShop.add(nodGoods); nodShop.add(nodCart); nodShop.add(nodShoppingHistory);

        TreeSelectionModel treeSelectionModel;
        treeSelectionModel=jt.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!jt.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                    if(node==nodPersonalInfo){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.teacher.TeacherInfo.AppTeaInfo"))
                        {
                            AppTeaInfo app=new AppTeaInfo();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodLibrary){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.library.StuLibrary")) {
                            StuLibrary app = new StuLibrary();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodGrades||node==nodChooseCourses){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.courseManage.AppTeaCourse")) {
                            AppTeaCourse app = new AppTeaCourse();
                            app.open();
                            setVisible(false);
                        }
                    }
                    else if(node==nodCard){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.AppLife")) {
                            AppLife app = new AppLife();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodShop||node==nodGoods||node==nodCart||node==nodShoppingHistory){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.shop.AppShop")) {
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
