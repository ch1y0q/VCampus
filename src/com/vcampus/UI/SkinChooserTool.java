package com.vcampus.UI;

/**
 * Adopted from WebLAF library.
 *
 * @author Huang Qiyue
 * @date 2021-07-29
 */

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
import com.alee.api.resource.ClassResource;
import com.alee.api.resource.FileResource;
import com.alee.demo.DemoApplication;
import com.alee.demo.skin.DemoIcons;
import com.alee.demo.skin.DemoStyles;
import com.alee.extended.svg.SvgIconSource;
import com.alee.laf.combobox.ComboBoxCellParameters;
import com.alee.laf.combobox.WebComboBox;
import com.alee.laf.combobox.WebComboBoxRenderer;
import com.alee.laf.panel.WebPanel;
import com.alee.managers.icon.IconManager;
import com.alee.managers.icon.LazyIcon;
import com.alee.managers.icon.set.IconSet;
import com.alee.managers.icon.set.RuntimeIconSet;
import com.alee.managers.style.Skin;
import com.alee.managers.style.StyleId;
import com.alee.managers.style.StyleManager;
import com.alee.skin.dark.WebDarkSkin;
import com.alee.utils.CollectionUtils;
import com.alee.utils.CoreSwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * {@link com.alee.demo.DemoApplication} skin chooser.
 *
 * @author Mikle Garin
 */
public final class SkinChooserTool extends WebPanel
{
    /**
     * Constructs new {@link com.alee.demo.ui.tools.SkinChooserTool}.
     */
    public SkinChooserTool ()
    {
        super ( StyleId.panelTransparent, new BorderLayout ( 0, 0 ) );

        // Skin chooser combobox
        final WebComboBox chooser = new WebComboBox ( StyleId.of ( "tool" ), CollectionUtils.asList ( StyleManager.getSkin (), new WebDarkSkin() ) );
        chooser.setLanguage ( "demo.tool.skin" );
        chooser.setSelectedItem ( StyleManager.getSkin () );
        chooser.setRenderer ( new WebComboBoxRenderer<Skin, JList, ComboBoxCellParameters<Skin, JList>> ()
        {
            /* TODO add icon
            @Override
            protected Icon iconForValue ( @NotNull final ComboBoxCellParameters<Skin, JList> parameters )
            {
                return parameters.index () == -1 ?  new LazyIcon( "brush16" ) : parameters.value ().getIcon ();
            }
            */
        } );
        chooser.addActionListener ( new ActionListener ()
        {
            @Override
            public void actionPerformed ( @NotNull final ActionEvent e )
            {
                // Executing later to allow combobox popup to close first
                CoreSwingUtils.invokeLater ( new Runnable ()
                {
                    @Override
                    public void run ()
                    {
                        final Skin skin = ( Skin ) chooser.getSelectedItem ();
                        if ( skin != null )
                        {
                            StyleManager.setSkin ( skin );
                        }
                    }
                } );
            }
        } );
        add ( chooser, BorderLayout.CENTER );
    }
}