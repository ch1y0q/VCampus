package com.vcampus.client.main;

import com.vcampus.client.administrator.main.AppAdminInfo;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
/**
 * @author Xiao Kaijie
 * @date 2021-07-13
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
        nodLogin.add(nodInfor);nodLogin.add(nodTeaInfor); nodLogin.add(nodStuInfor);nodLogin.add(nodClassManage);nodLogin.add(nodLibrary);nodLogin.add(nodDorm);

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
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodTeaInfor){
                        if(this.getClass().getName()!="com.vcampus.client.main.TeaManage") {
                            TeaManage app = new TeaManage();
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodStuInfor){
                        if(this.getClass().getName()!="com.vcampus.client.main.StuManage") {
                            StuManage app = new StuManage();
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodLibrary){
                        if(this.getClass().getName()!="com.vcampus.client.main.ManLibrary") {
                            ManLibrary app = new ManLibrary();
                            //setVisible(false);
                            app.setVisible(true);
                        }
                    }
                    else if(node==nodClassManage){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppAdminCourse") {
                            AppAdminCourse app = new AppAdminCourse();
                            //setVisible(false);
                        }
                    }
                    else if(node==nodDorm){
                        if(this.getClass().getName()!="com.vcampus.client.main.AppDormAdmin") {
                            AppLife app = new AppLife();
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
