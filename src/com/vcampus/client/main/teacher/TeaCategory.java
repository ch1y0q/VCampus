package com.vcampus.client.main.teacher;

import com.vcampus.client.main.AppLife;
import com.vcampus.client.main.courseManage.AppTeaCourse;
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
                        if(!this.getClass().getName().equals("com.vcampus.client.main.teacher.TeacherInfo.AppTeaInfo"))
                        {
                            AppTeaInfo app=new AppTeaInfo();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodLibrary){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.StudentLibrary.StuLibrary")) {
                            StuLibrary app = new StuLibrary();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodGrades||node==nodChooseCourses){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.courseManage.AppStuCourse")) {
                            AppTeaCourse app = new AppTeaCourse();
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
                    else if(node==nodShop||node==nodGoods||node==nodCart||node==nodShoppingHistoty){
                        if(!this.getClass().getName().equals("com.vcampus.client.main.AppShopTeacher")) {
                            AppShop app = new AppShop();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                }
                }
        });
        return jt;
    }

}
