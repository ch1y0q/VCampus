package com.vcampus.client.main;

/*
 * This file is *adopted from* part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

import com.alee.api.annotations.NotNull;
import com.alee.api.data.CompassDirection;
import com.alee.extended.dock.WebDockableFrame;
import com.alee.extended.panel.GroupPanel;
import com.alee.extended.panel.GroupingType;
import com.alee.laf.scroll.ScrollPaneState;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.separator.WebSeparator;
import com.alee.laf.tree.TreeSelectionStyle;
import com.alee.laf.tree.WebTree;
import com.alee.managers.hotkey.Hotkey;
import com.alee.managers.settings.Configuration;
import com.alee.managers.style.*;
import com.alee.utils.swing.extensions.KeyEventRunnable;
import com.vcampus.UI.FancyUI;
import com.vcampus.client.main.courseManage.AppAdminCourse;
import com.vcampus.client.main.dailyReport.AppDailyReportManage;
import com.vcampus.client.main.library.ManagerLibrary.ManLibrary;
import com.vcampus.client.main.life.AppDormAdmin;
import com.vcampus.client.main.manager.*;
import com.vcampus.client.main.shop.AppShopAdmin;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.KeyEvent;

/**
 * 管理员的主界面，继承自抽象类FancyUI
 *
 * @author Huang Qiyue
 * @date 2021-07-30
 */


public final class AdminFancyUI extends FancyUI
{

    /**
     * Returns application instance.
     *
     * @return application instance
     */
    @NotNull
    protected static AdminFancyUI getInstance() {
        if ( instance == null )
        {
            instance = new AdminFancyUI();
        }
        return (AdminFancyUI) instance;   //polymorphism
    }

    public AdminFancyUI() {
        super();

        JInternalFrame internal = new JInternalFrame("管理员入口",true,true,true, true);
        internal.setContentPane(new AppAdmin().getContentPane());
        internal.pack();
        internal.setVisible(true);
        internal.setBounds(-5,-5,1400,1000);
        internal.toFront();
        desktopPane.add(internal);

        /* Teachers need no chatroom
        final JInternalFrame chatFrame = new JInternalFrame("聊天室",true,true,true, true);
        chatFrame.setContentPane(new AppChatDiag().getContentPane());
        chatFrame.pack();
        chatFrame.setVisible(true);
        chatFrame.setBounds(1000,700,300,500);
        desktopPane.add(chatFrame);
         */
    }

    @Override
    /**
     * Initializes categoryFrame.
     * Called during initializeDocks().
     *
     * @author Huang Qiyue
     * @date 2021-07-20
     */
    protected void initializeCategoryFrame()
    {
        categoryFrame = new WebDockableFrame(StyleId.dockableframeCompact,"FancyUITest","vCampus");
        categoryFrame.setPosition(CompassDirection.west);

        //final WebTree appTree = new WebTree(getTreeNodes());
        WebTree appTree=  new WebTree(new ManCategory().getNode());
        appTree.setEditable(false);
        appTree.setRootVisible(false);
        appTree.setShowsRootHandles(true);
        /* WebTree methods*/
        appTree.setMultipleSelectionAllowed(false);
        appTree.setSelectionStyle(TreeSelectionStyle.line);
        appTree.expandAll();
        appTree.onKeyPress ( Hotkey.ENTER, new KeyEventRunnable()
        {
            @Override
            public void run ( @NotNull final KeyEvent e )
            {
                //TODO
                //open ( appTree.getSelectedNode () );
            }
        } );

        appTree.addTreeSelectionListener(new TreeSelectionListener() {

            /**
             * 判断需要打开的窗口
             */
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!appTree.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) appTree.getLastSelectedPathComponent();
                    JInternalFrame internal = null;
                    switch((String)node.getUserObject()) {
                        case "个人信息":
                            internal = new JInternalFrame("个人信息维护",true,true,true, true);
                            internal.setContentPane(new AppAdminInfoFrame().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1000,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        case "教师信息管理":
                            internal = new JInternalFrame("教师信息管理",true,true,true, true);
                            internal.setContentPane(new TeaManage().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1000,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        case "学生信息管理":
                            internal = new JInternalFrame("学生信息管理",true,true,true, true);
                            internal.setContentPane(new StuManage().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1000,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        case "图书馆":
                            // fall through
                        case "图书查询借阅":
                            // fall through
                        case "已借图书":
                            // fall through
                        case "书籍查询":
                            internal = new JInternalFrame("图书馆",true,true,true, true);
                            internal.setContentPane(new ManLibrary().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1000,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        case "成绩录入":
                            // fall through
                        case "课程管理":
                            internal = new JInternalFrame("在线课程管理",true,true,true, true);
                            internal.setContentPane(new AppAdminCourse().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1000,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        case "生活管理":
                            internal = new JInternalFrame("生活服务",true,true,true, true);
                            internal.setContentPane(new AppDormAdmin().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1000,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        case "商店管理":
                            internal = new JInternalFrame("在线商店管理",true,true,true, true);
                            internal.setContentPane(new AppShopAdmin().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1500,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        case "每日上报管理":
                            internal = new JInternalFrame("每日上报",true,true,true, true);
                            internal.setContentPane(new AppDailyReportManage().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setSize(1000,1000);
                            internal.toFront();
                            desktopPane.add(internal);
                            break;
                        default:
                            //System.out.println("Nothing selected");
                            break;
                    }
                }
            }
        });
        final WebScrollPane appTreeScroll = new WebScrollPane ( StyleId.scrollpaneTransparentHoveringExtending, appTree );
        appTreeScroll.registerSettings ( new Configuration<ScrollPaneState> ( "ExamplesScroll" ) );

        // Filtering field
        // not implemented - requires tree models that implement FilterableNodes e.g. WebExTree
        // final WebTreeFilterField filter = new WebTreeFilterField ( appTree );

        // Frame UI composition
        final WebSeparator separator = new WebSeparator ( StyleId.separatorHorizontal );
        //categoryFrame.add ( new GroupPanel( GroupingType.fillLast, 0, false, filter, separator, appTreeScroll ) );
        categoryFrame.add ( new GroupPanel( GroupingType.fillLast, 0, false, appTreeScroll ) );

    }

}