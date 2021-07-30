package com.vcampus.UI;


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
import com.alee.api.data.BoxOrientation;
import com.alee.api.data.CompassDirection;
import com.alee.api.jdk.SerializableSupplier;
import com.alee.api.version.Version;
import com.alee.demo.content.ExamplesManager;
import com.alee.demo.skin.decoration.FeatureStateBackground;
import com.alee.extended.behavior.ComponentResizeBehavior;
import com.alee.extended.canvas.WebCanvas;
import com.alee.extended.dock.SidebarButtonVisibility;
import com.alee.extended.dock.WebDockableFrame;
import com.alee.extended.dock.WebDockablePane;
import com.alee.extended.label.WebStyledLabel;
import com.alee.extended.memorybar.WebMemoryBar;
import com.alee.extended.overlay.AlignedOverlay;
import com.alee.extended.overlay.WebOverlay;
import com.alee.extended.panel.GroupPanel;
import com.alee.extended.panel.GroupingType;
import com.alee.extended.statusbar.WebStatusBar;
import com.alee.extended.tab.DocumentAdapter;
import com.alee.extended.tab.DocumentData;
import com.alee.extended.tab.PaneData;
import com.alee.extended.tab.WebDocumentPane;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.desktoppane.WebDesktopPane;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WindowState;
import com.alee.laf.scroll.ScrollPaneState;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.separator.WebSeparator;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.alee.laf.toolbar.WebToolBar;
import com.alee.laf.tree.TreeSelectionStyle;
import com.alee.laf.tree.WebTree;
import com.alee.laf.window.WebFrame;
import com.alee.managers.hotkey.Hotkey;
import com.alee.managers.language.LM;
import com.alee.managers.language.LanguageLocaleUpdater;
import com.alee.managers.language.LanguageManager;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.settings.Configuration;
import com.alee.managers.style.*;
import com.alee.managers.task.TaskGroup;
import com.alee.managers.task.TaskManager;
import com.alee.skin.dark.WebDarkSkin;
import com.alee.utils.CollectionUtils;
import com.alee.utils.CoreSwingUtils;
import com.alee.utils.XmlUtils;
import com.alee.utils.swing.Customizer;
import com.alee.utils.swing.extensions.KeyEventRunnable;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * 学生/教师/管理员的主界面。左侧有常驻的树状结构目录，从目录选择项目，可在右侧打开
 *
 * @author Huang Qiyue
 * @date 2021-07-29
 */

public abstract class FancyUI extends WebFrame
{
    /**
     * Available application and example skins.
     */
    public static ArrayList<Skin> skins;

    /**
     * Application instance.
     */
    protected static FancyUI instance;

    /**
     * Demo application {@link Version}.
     */
    private final Version version;

    /**
     * Application base UI elements.
     */
    WebDockablePane dockablePane;
    WebDocumentPane<DocumentData> mainPane;
    protected WebDockableFrame categoryFrame;
    protected WebDesktopPane desktopPane;
    WebStyledLabel information;
    WebPanel overlayContainer;

    /**
     * Returns application instance.
     *
     * @return application instance
    */
    @NotNull
    protected static FancyUI getInstance() {
        return null;
    }

    /**
     * Constructs new FancyUI
     */
    public FancyUI()
    {
        super ();

        version = new Version ( FancyUI.class );

        setIconImages ( WebLookAndFeel.getImages () );
        updateTitle ();

        initializeDocks();
        initializeStatus();
        initializeToolBar();
        // initializeCategoryFrame();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registerSettings(new Configuration<WindowState>("application", new SerializableSupplier<WindowState>() {
                    @Override
                    public WindowState get() {
                        return new WindowState(new Dimension(1200, 820));
                    }
                }
                )
        );
    }

    /**
     * Updates demo application title.
     */
    public void updateTitle ()
    {
        final StringBuilder title = new StringBuilder ();

        // Library version
        title.append ( "vCampus " );

        // Opened example
        final DocumentData doc = mainPane != null ? mainPane.getSelectedDocument () : null;
        if ( doc != null )
        {
            title.append ( " - " ).append ( LM.get ( doc.getTitle () ) );
        }

        setTitle ( title.toString () );
    }


    /**
     * Initializes categoryFrame.
     * Called during initializeDocks().
     *
     * @author Huang Qiyue
     * @date 2021-07-20
     */
    protected abstract void initializeCategoryFrame();

    /**
     * Initializes status bar and its content.
     */
    private void initializeStatus ()
    {
        final WebStatusBar statusBar = new WebStatusBar ();

        statusBar.addSpacingToEnd ( 10 );

        final WebOverlay memoryBarOverlay = new WebOverlay ();

        memoryBarOverlay.setContent ( new WebMemoryBar().setPreferredWidth ( 150 ) );

        final WebCanvas resizeCorner = new WebCanvas ( StyleId.canvasGripperSE );
        new ComponentResizeBehavior( resizeCorner, CompassDirection.southEast ).install ();

        memoryBarOverlay.addOverlay ( new AlignedOverlay(
                resizeCorner,
                BoxOrientation.right,
                BoxOrientation.bottom,
                new Insets ( 0, 0, -1, -1 )
        ) );

        statusBar.addToEnd ( memoryBarOverlay );

        add ( statusBar, BorderLayout.SOUTH );
        // Custom status bar margin for notification manager
        NotificationManager.setMargin ( 0, 0, statusBar.getPreferredSize ().height, 0 );
    }


    /**
     * Initializes demo application toolbar and its content.
     */
    private void initializeToolBar ()
    {
        final WebToolBar toolBar = new WebToolBar ( StyleId.toolbarAttachedNorth );
        toolBar.setFloatable ( false );

        toolBar.add ( new com.vcampus.UI.SkinChooserTool() );
        toolBar.addSeparator ();
        //toolBar.add ( new LanguageChooserTool() );

        add ( toolBar, BorderLayout.NORTH );
    }

    private void initializeDocks ()
    {
        /**
         * Dockable pane.
         */

        dockablePane = new WebDockablePane ( StyleId.dockablepaneCompact );
        dockablePane.setSidebarButtonVisibility ( SidebarButtonVisibility.anyMinimized );

        /**
         * Content.
         */
        mainPane = new WebDocumentPane<>();
        mainPane.setClosable ( true );
        mainPane.setDragEnabled ( true );
        mainPane.setDragBetweenPanesEnabled ( false );
        mainPane.setSplitEnabled ( true );
        mainPane.setTabbedPaneCustomizer (new Customizer<WebTabbedPane> ()
        {
            @Override
            public void customize ( @NotNull final WebTabbedPane tabbedPane )
            {
                tabbedPane.setTabLayoutPolicy ( JTabbedPane.SCROLL_TAB_LAYOUT );
            }
        } );

        /* Add a label, no need
        final WebOverlay overlay = new WebOverlay (mainPane);

        overlayContainer = new WebPanel (new AlignLayout () );

        information = new WebStyledLabel ( );
        information.setHorizontalTextAlignment ( WebStyledLabel.CENTER );
        information.setWrap ( TextWrap.none );
        information.changeFontSize ( 3 );
        information.setFontName("微软雅黑");
        information.setText("请从左侧选择要进行的操作");

        overlayContainer.add ( information );
        overlay.addOverlay ( new FillOverlay ( overlayContainer ) );
        */

        desktopPane = new WebDesktopPane();
        /* an example for JInternalFrame
        int  x = 30, y = 30;
        for(int  i = 0; i < 10 ; ++i )
        {
            JInternalFrame jframe = new JInternalFrame("Internal Frame " + i ,  true, true, true, true);

            jframe.setBounds(x, y, 250, 85);
            Container c1 = jframe.getContentPane( ) ;
            c1.add(new JLabel("I love my country"));
            jframe.setVisible(true);
            desktopPane.add( jframe );
            y += 85;
        }
        */



        mainPane.add(desktopPane);


        mainPane.addDocumentListener ( new DocumentAdapter<DocumentData>()
        {
            @Override
            public void selected (final DocumentData document, final PaneData<DocumentData> pane, final int index )
            {
                updateTitle ();
            }

            @Override
            public void opened ( final DocumentData document, final PaneData<DocumentData> pane, final int index )
            {
                overlayContainer.setVisible ( false );
            }

            @Override
            public void closed ( final DocumentData document, final PaneData<DocumentData> pane, final int index )
            {
                if ( desktopPane.getComponentCount () == 0 )
                {
                    overlayContainer.setVisible ( true );
                    updateTitle ();
                }
            }
        } );

        //dockablePane.setContent ( overlay );
        dockablePane.setContent( desktopPane );

        /**
         * Frames.
         */

        initializeCategoryFrame();
        dockablePane.addFrame (categoryFrame);

        /**
         * Dockable pane position.
         * Added last for optimization purpose.
         */

        add ( dockablePane, BorderLayout.CENTER );
    }

    /**
     * Initialize a tree with all functionalities.
     * Replaced by StuCategory.getNode()
     * @author Huang Qiyue
     * @date 2021-07-22
     */
    @Deprecated
    private DefaultMutableTreeNode getTreeNodes(){
        DefaultMutableTreeNode nodLogin= new DefaultMutableTreeNode("学生登陆");
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
        DefaultMutableTreeNode nodShoppingHistory = new DefaultMutableTreeNode("购买历史");
        nodShop.add(nodGoods);
        nodShop.add(nodCart);
        nodShop.add(nodShoppingHistory);

        // JTree jt = new JTree(nodLogin);
        // jt.setBounds(0,50,200,600);
        // categoryFrame.add(jt);
        return nodLogin;
    }

    /**
     * Returns content pane.
     *
     * @return content pane
     */
    @NotNull
    public WebDocumentPane<DocumentData> getMainPane()
    {
        return mainPane;
    }

    /**
     * Displays demo application.
     */
    public void display ()
    {
        setVisible ( true );
        categoryFrame.requestFocusInWindow ();
    }

    /**
     * Properly launches demo application.
     *
     * @param args launch arguments
     */
    public static void main ( final String[] args )
    {
        CoreSwingUtils.enableEventQueueLogging ();
        CoreSwingUtils.invokeLater ( new Runnable ()
        {
            @Override
            public void run ()
            {
                // Configuring settings location
                //SettingsManager.setDefaultSettingsDirName ( ".weblaf-demo" );
                //SettingsManager.setDefaultSettingsGroup ( "WebLookAndFeelDemo" );
                //SettingsManager.setSaveOnChange ( true );

                /* TODO
                final IconSet iconSet = new RuntimeIconSet( "my-icon-set" );
                iconSet.addIcon ( new SvgIconSource( "brush16", (Resource) getClass().getResourceAsStream("/resources/assets/icon/brush.svg")) ); // Adding IconSet into IconManager
                IconManager.addIconSet ( iconSet );
                   */

                // Adding demo data aliases before styles using it are read
                XmlUtils.processAnnotations ( FeatureStateBackground.class );

                // Installing Look and Feel
                WebLookAndFeel.setForceSingleEventsThread ( true );
                WebLookAndFeel.install ();

                // Saving skins for reference
                skins = CollectionUtils.asList ( StyleManager.getSkin (), new WebDarkSkin () );


                // Custom ThreadGroup for demo application
                TaskManager.registerGroup ( new TaskGroup("TaskGroup",4) );


                // Adding demo application skin extensions
                // They contain all custom styles demo application uses
                /*
                StyleManager.addExtensions ( new XmlSkinExtension( new ClassResource( com.alee.demo.skin.DemoAdaptiveExtension.class, "resources/demo-adaptive-extension.xml" )),
                        new XmlSkinExtension(new ClassResource ( com.alee.demo.skin.DemoLightSkinExtension.class, "resources/demo-light-extension.xml" ) ),
                        new XmlSkinExtension( new ClassResource ( com.alee.demo.skin.DemoDarkSkinExtension.class, "resources/demo-dark-extension.xml" )) );
                */
                StyleManager.setSkin(com.alee.skin.flat.FlatSkin.class);

                /* Adding demo language dictionary
                LanguageManager.addDictionary ( new Dictionary (
                        new ClassResource ( com.vcampus.test.FancyUITest.class, "language/demo-language.xml" )
                ) );
*/

                // Registering listener to update current Locale according to language changes
                LanguageManager.addLanguageListener ( new LanguageLocaleUpdater() );

                // Initializing demo application managers
                ExamplesManager.initialize ();

                // Starting demo application
                // FancyUI.getInstance ().display ();
            }
        } );
    }
}