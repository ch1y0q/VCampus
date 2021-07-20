package com.vcampus.test;


/*
 * This file is part of WebLookAndFeel library.
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
import com.alee.api.jdk.SerializableSupplier;
import com.alee.api.version.Version;
import com.alee.demo.api.example.Example;
import com.alee.demo.api.example.ExampleData;
import com.alee.demo.content.ExamplesManager;
import com.alee.demo.skin.decoration.FeatureStateBackground;
import com.alee.extended.dock.SidebarButtonVisibility;
import com.alee.extended.dock.WebDockableFrame;
import com.alee.extended.dock.WebDockablePane;
import com.alee.extended.label.TextWrap;
import com.alee.extended.label.WebStyledLabel;
import com.alee.extended.layout.AlignLayout;
import com.alee.extended.overlay.FillOverlay;
import com.alee.extended.overlay.WebOverlay;
import com.alee.extended.tab.DocumentAdapter;
import com.alee.extended.tab.DocumentData;
import com.alee.extended.tab.PaneData;
import com.alee.extended.tab.WebDocumentPane;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WindowState;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.alee.laf.window.WebFrame;
import com.alee.managers.language.LM;
import com.alee.managers.language.LanguageLocaleUpdater;
import com.alee.managers.language.LanguageManager;
import com.alee.managers.settings.Configuration;
import com.alee.managers.style.ChildStyleId;
import com.alee.managers.style.Skin;
import com.alee.managers.style.StyleId;
import com.alee.managers.style.StyleManager;
import com.alee.managers.task.TaskGroup;
import com.alee.managers.task.TaskManager;
import com.alee.skin.dark.WebDarkSkin;
import com.alee.utils.CollectionUtils;
import com.alee.utils.CoreSwingUtils;
import com.alee.utils.SystemUtils;
import com.alee.utils.XmlUtils;
import com.alee.utils.swing.Customizer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    private WebDockablePane dockablePane;
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
        title.append ( "vCampus " ).append ( version.toString () );

        // Opened example
        final DocumentData doc = mainPane != null ? mainPane.getSelectedDocument () : null;
        if ( doc != null )
        {
            title.append ( " - " ).append ( LM.get ( doc.getTitle () ) );
        }

        setTitle ( title.toString () );
    }

    // TODO rewrite
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
        information.setText("请从左侧选择要进行的操作");
        /*
        information.setLanguage (
                "demo.content.information.overlay.empty",
                version.name (), version.toString (),
                SystemUtils.getJavaName (),
                SystemUtils.getJavaVersion ().versionString (), SystemUtils.getOsArch ()
        );*/
        overlayContainer.add ( information );

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

        categoryFrame = new WebDockableFrame(StyleId.dockableframeCompact,"FancyUITest","vCampus");
        dockablePane.addFrame (categoryFrame);

        /**
         * Dockable pane position.
         * Added last for optimization purpose.
         */

        add ( dockablePane, BorderLayout.CENTER );
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
                /*
                // Configuring settings location
                SettingsManager.setDefaultSettingsDirName ( ".weblaf-demo" );
                SettingsManager.setDefaultSettingsGroup ( "WebLookAndFeelDemo" );
                SettingsManager.setSaveOnChange ( true );
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

                /*
                // Adding demo application skin extensions
                // They contain all custom styles demo application uses
                StyleManager.addExtensions ( new DemoAdaptiveExtension (), new DemoLightSkinExtension (), new DemoDarkSkinExtension () );
                */

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