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
import com.vcampus.client.main.courseManage.AppTeaCourse;
import com.vcampus.client.main.dailyReport.AppDailyReport;
import com.vcampus.client.main.library.TeaLibrary;
import com.vcampus.client.main.life.AppLifeTeacher;
import com.vcampus.client.main.shop.AppShop;
import com.vcampus.client.main.teacher.AppTeacher;
import com.vcampus.client.main.teacher.TeaCategory;
import com.vcampus.client.main.teacher.TeacherInfo.AppTeaInfo;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.KeyEvent;

/**
 * ???????????????????????????????????????FancyUI
 * 
 * @author Huang Qiyue
 * @date 2021-07-29
 */

public final class TeacherFancyUI extends FancyUI
{

    /**
     * Returns application instance.
     *
     * @return application instance
     */
    @NotNull
    protected static TeacherFancyUI getInstance() {
        if ( instance == null )
        {
            instance = new TeacherFancyUI();
        }
        return (TeacherFancyUI) instance;   //polymorphism
    }

    public TeacherFancyUI() {
        super();

        JInternalFrame internal = new JInternalFrame("????????????",true,true,true, true);
        internal.setContentPane(new AppTeacher().getContentPane());
        internal.pack();
        internal.setVisible(true);
        internal.setBounds(10,10,1400,1000);
        desktopPane.add(internal);

        /* Teachers need no chatroom
        final JInternalFrame chatFrame = new JInternalFrame("?????????",true,true,true, true);
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
        WebTree appTree=  new WebTree(new TeaCategory().getNode());
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
             * ???????????????????????????
             */
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!appTree.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) appTree.getLastSelectedPathComponent();
                    JInternalFrame internal = null;
                    switch((String)node.getUserObject()) {
                        case "????????????":
                            internal = new JInternalFrame("??????????????????",true,true,true, true);
                            internal.setContentPane(new AppTeaInfo().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setBounds(30,50,1400,1000);
                            desktopPane.add(internal);
                            break;
                        case "?????????":
                            // fall through
                        case "??????????????????":
                            // fall through
                        case "????????????":
                            // fall through
                        case "????????????":
                            internal = new JInternalFrame("?????????",true,true,true, true);
                            internal.setContentPane(new TeaLibrary().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setBounds(30,50,1400,1000);
                            desktopPane.add(internal);
                            break;
                        case "????????????":
                            // fall through
                        case "????????????":
                            internal = new JInternalFrame("??????????????????",true,true,true, true);
                            internal.setContentPane(new AppTeaCourse().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setBounds(30,50,1400,1000);
                            desktopPane.add(internal);
                            break;
                        case "????????????":
                            internal = new JInternalFrame("????????????",true,true,true, true);
                            internal.setContentPane(new AppLifeTeacher().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setBounds(30,50,1400,1000);
                            desktopPane.add(internal);
                            break;
                        case "????????????":
                            // fall through
                        case "?????????":
                            // fall through
                        case "????????????":
                            internal = new JInternalFrame("????????????",true,true,true, true);
                            internal.setContentPane(new AppShop().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setBounds(30,50,1400,1000);
                            desktopPane.add(internal);
                            break;
                        case "????????????":
                            internal = new JInternalFrame("????????????",true,true,true, true);
                            internal.setContentPane(new AppDailyReport().getContentPane());
                            internal.pack();
                            internal.setVisible(true);
                            internal.setBounds(30,50,1400,1000);
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