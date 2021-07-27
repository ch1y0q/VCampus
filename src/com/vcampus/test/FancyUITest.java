package com.vcampus.test;


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
import com.alee.api.resource.ClassResource;
import com.alee.api.version.Version;
import com.alee.demo.DemoApplication;
import com.alee.demo.api.example.Example;
import com.alee.demo.api.example.ExampleData;
import com.alee.demo.content.ExamplesManager;
import com.alee.demo.frames.examples.ExamplesTreeNode;
import com.alee.demo.skin.*;
import com.alee.demo.skin.decoration.FeatureStateBackground;
import com.alee.demo.ui.tools.*;
import com.alee.extended.behavior.ComponentResizeBehavior;
import com.alee.extended.canvas.WebCanvas;
import com.alee.extended.dock.SidebarButtonVisibility;
import com.alee.extended.dock.WebDockableFrame;
import com.alee.extended.dock.WebDockablePane;
import com.alee.extended.label.TextWrap;
import com.alee.extended.label.WebStyledLabel;
import com.alee.extended.layout.AlignLayout;
import com.alee.extended.link.UrlLinkAction;
import com.alee.extended.link.WebLink;
import com.alee.extended.memorybar.WebMemoryBar;
import com.alee.extended.overlay.AlignedOverlay;
import com.alee.extended.overlay.FillOverlay;
import com.alee.extended.overlay.WebOverlay;
import com.alee.extended.panel.GroupPanel;
import com.alee.extended.panel.GroupingType;
import com.alee.extended.statusbar.WebStatusBar;
import com.alee.extended.tab.DocumentAdapter;
import com.alee.extended.tab.DocumentData;
import com.alee.extended.tab.PaneData;
import com.alee.extended.tab.WebDocumentPane;
import com.alee.extended.tree.ExTreeDataProvider;
import com.alee.extended.tree.WebExTree;
import com.alee.extended.tree.WebTreeFilterField;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.desktoppane.WebDesktopPane;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WindowState;
import com.alee.laf.scroll.ScrollPaneState;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.separator.WebSeparator;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.alee.laf.toolbar.WebToolBar;
import com.alee.laf.tree.TreeNodeEventRunnable;
import com.alee.laf.tree.TreeSelectionStyle;
import com.alee.laf.tree.TreeState;
import com.alee.laf.tree.WebTree;
import com.alee.laf.window.WebFrame;
import com.alee.managers.hotkey.Hotkey;
import com.alee.managers.language.LM;
import com.alee.managers.language.LanguageLocaleUpdater;
import com.alee.managers.language.LanguageManager;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.settings.Configuration;
import com.alee.managers.settings.SettingsManager;
import com.alee.managers.style.*;
import com.alee.managers.task.TaskGroup;
import com.alee.managers.task.TaskManager;
import com.alee.skin.dark.WebDarkSkin;
import com.alee.utils.CollectionUtils;
import com.alee.utils.CoreSwingUtils;
import com.alee.utils.SystemUtils;
import com.alee.utils.XmlUtils;
import com.alee.utils.swing.Customizer;
import com.alee.utils.swing.extensions.KeyEventRunnable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang Qiyue
 * @date 2021-07-19
 */
public final class FancyUITest extends WebFrame
{
    /**
     * Available application and example skins.
     */
    public static ArrayList<Skin> skins;

    /**
     * Demo application instance.
     */
    private static FancyUITest instance;

    /**
     * Demo application {@link Version}.
     */
    private final Version version;

    /**
     * Demo application base UI elements.
     */
    WebDockablePane dockablePane;
    WebDocumentPane<DocumentData> mainPane;
    WebDockableFrame categoryFrame;

    /**
     * Returns application instance.
     *
     * @return application instance
     */
    @NotNull
    public static FancyUITest getInstance ()
    {
        if ( instance == null )
        {
            instance = new FancyUITest();
        }
        return instance;
    }

    /**
     * Constructs new FancyUI.
     */
    FancyUITest()
    {
        super ();
        version = new Version ( FancyUITest.class );

        setIconImages ( WebLookAndFeel.getImages () );
        updateTitle ();

        initializeDocks();
        initializeStatus();
        initializeToolBar();
       // initializeCategoryFrame();

        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        registerSettings ( new Configuration<WindowState> ( "application", new SerializableSupplier<WindowState> ()
        {
            @Override
            public WindowState get ()
            {
                return new WindowState ( new Dimension ( 1200, 820 ) );
            }
        } ) );


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
    private void initializeCategoryFrame()
    {
        categoryFrame = new WebDockableFrame(StyleId.dockableframeCompact,"FancyUITest","vCampus");
        categoryFrame.setPosition(CompassDirection.west);

        final WebTree appTree = new WebTree(getTreeNodes());

        appTree.setEditable(false);
        appTree.setRootVisible(false);
        appTree.setShowsRootHandles(true);
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
        appTree.onNodeDoubleClick ( new TreeNodeEventRunnable<ExamplesTreeNode>()
        {
            @Override
            public void run ( @NotNull final ExamplesTreeNode node )
            {
                //TODO
                //open ( node );
            }
        } );
        //appTree.registerSettings ( new Configuration<TreeState> ( "ExamplesTree" ) );
        final WebScrollPane appTreeScroll = new WebScrollPane ( StyleId.scrollpaneTransparentHoveringExtending, appTree );
        appTreeScroll.registerSettings ( new Configuration<ScrollPaneState> ( "ExamplesScroll" ) );

        // Filtering field
        // unimplemented - requires WebExTree
        //final WebTreeFilterField filter = new WebTreeFilterField ( appTree );

        // Frame UI composition
        final WebSeparator separator = new WebSeparator ( StyleId.separatorHorizontal );
       //categoryFrame.add ( new GroupPanel( GroupingType.fillLast, 0, false, filter, separator, appTreeScroll ) );
       categoryFrame.add ( new GroupPanel( GroupingType.fillLast, 0, false, separator, appTreeScroll ) );
    }

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

       // toolBar.add ( new SkinChooserTool() );
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

        final WebOverlay overlay = new WebOverlay (mainPane);

        final WebPanel overlayContainer = new WebPanel (new AlignLayout () );

        final WebStyledLabel information = new WebStyledLabel ( );
        information.setHorizontalTextAlignment ( WebStyledLabel.CENTER );
        information.setWrap ( TextWrap.none );
        information.changeFontSize ( 3 );
        information.setFontName("微软雅黑");
        information.setText("请从左侧选择要进行的操作");
        /*
        information.setLanguage (
                "demo.content.information.overlay.empty",
                version.name (), version.toString (),
                SystemUtils.getJavaName (),
                SystemUtils.getJavaVersion ().versionString (), SystemUtils.getOsArch ()
        );*/

        overlayContainer.add ( information );
        JDesktopPane desktopPane = new JDesktopPane();
        int  x = 30, y = 30;
        for(int  i = 0; i < 10 ; ++i )
        {
            JInternalFrame jframe = new JInternalFrame("Internal Frame " + i ,  true, true, true, true);

            jframe.setBounds(x, y, 250, 85);
            Container c1 = jframe.getContentPane( ) ;
            c1.add(new JLabel("I love my country"));
            desktopPane.add( jframe );
            jframe.setVisible(true);
            y += 85;
        }
        overlayContainer.add ( desktopPane );

        overlay.addOverlay ( new FillOverlay ( overlayContainer ) );

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
                if ( mainPane.getDocumentsCount () == 0 )
                {
                    overlayContainer.setVisible ( true );
                    updateTitle ();
                }
            }
        } );

        dockablePane.setContent ( overlay );

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
     *
     * @author Huang Qiyue
     * @date 2021-07-22
     */
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
     * Opens specified example in content pane.
     *
     * @param example example to open
     */
    @Deprecated
    public void open ( @NotNull final Example example )
    {
        mainPane.openDocument ( ExampleData.forExample ( example ) );
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
                System.out.println(StyleManager.getSkin());

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
                FancyUITest.getInstance ().display ();
            }
        } );
    }
}