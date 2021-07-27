package com.vcampus.client.main.manager;

import com.vcampus.client.administrator.main.AppAdminInfo;
import com.vcampus.client.main.AppAdminCourse;
import com.vcampus.client.main.AppLife;
import com.vcampus.client.main.dailyReport.AppDailyReportManage;
import com.vcampus.client.main.library.ManagerLibrary.ManLibrary;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
/**
 * @author Xiao Kaijie
 * @date 2021-07-20
 */
public class ManCategory extends JTree {
    public JTree init()
    {
        DefaultMutableTreeNode nodLogin= new DefaultMutableTreeNode("管理员登陆");
        DefaultMutableTreeNode nodInfor = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode nodTeaInfor = new DefaultMutableTreeNode("教师信息管理");
        DefaultMutableTreeNode nodStuInfor = new DefaultMutableTreeNode("学生信息管理");
        DefaultMutableTreeNode nodClassManage = new DefaultMutableTreeNode("课程管理");
        DefaultMutableTreeNode nodLibrary = new DefaultMutableTreeNode("图书馆");
        DefaultMutableTreeNode nodDorm = new DefaultMutableTreeNode("生活管理");
        DefaultMutableTreeNode nodDailyReport = new DefaultMutableTreeNode("每日上报管理");
        nodLogin.add(nodInfor);nodLogin.add(nodTeaInfor); nodLogin.add(nodStuInfor);
        nodLogin.add(nodClassManage);nodLogin.add(nodLibrary);nodLogin.add(nodDorm);
        nodLogin.add(nodDailyReport);

        JTree jt = new JTree(nodLogin);

        TreeSelectionModel treeSelectionModel;
        treeSelectionModel=jt.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!jt.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                    if(node==nodInfor){
                        if(this.getClass().getName()!="com.vcampus.client.administrator.AppAdminInfo")
                        {
                            AppAdminInfo app=new AppAdminInfo();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodTeaInfor){
                        if(this.getClass().getName()!="com.vcampus.client.main.Manager.TeaManage") {
                            TeaManage app = new TeaManage();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodStuInfor){
                        if(this.getClass().getName()!="com.vcampus.client.main.Manager.StuManage") {
                            StuManage app = new StuManage();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodLibrary){
                        if(this.getClass().getName()!="com.vcampus.client.main.library.ManagerLibrary.ManLibrary") {
                            ManLibrary app = new ManLibrary();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodClassManage){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppAdminCourse") {
                            setVisible(false);
                            AppAdminCourse app = new AppAdminCourse();
                        }
                    }
                    else if(node==nodDorm){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppDormAdmin") {
                            AppLife app = new AppLife();
                            app.setVisible(true);
                            setVisible(false);
                        }
                    }
                    else if(node==nodDailyReport){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppDailyReportManage") {
                            setVisible(false);
                            AppDailyReportManage app = new AppDailyReportManage();
                            app.setVisible(true);
                        }
                    }
                }
            }
        });
        return jt;
    }
}
