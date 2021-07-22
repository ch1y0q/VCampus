package com.vcampus.client.administrator.main;

/**
 * JTree目录测试
 *
 * @author Dong Ruojing
 * @date 2021/7/20
 */
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Category extends JFrame
{
    public JPanel createComponent()
    {

        //教师登录目录
        JPanel panel=new JPanel();
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("Vcampus索引");
        String modules[][]=new String[5][];
        modules[0]=new String[]{""};
        modules[1]=new String[]{"课程查看","成绩录入"};
        modules[2]=new String[] {"借阅查询","书籍查询","借阅历史"};
        modules[3]=new String[]{""};
        modules[4]=new String[] {"商城","购物车","购买历史"};
        String moduleName[]={"个人信息管理","课程管理","图书馆","一卡通","网上商店"};
        DefaultMutableTreeNode node=null;
        DefaultMutableTreeNode childNode=null;
        //UIManager.put("Tree.leafIcon",new ImageIcon("src/resources/assets/logo/seu-1200px.png")); //更改子节点图标
        int length=0;
        for(int i=0;i<5;i++)
        {
            length=modules[i].length;
            node=new DefaultMutableTreeNode(moduleName[i]);
            for (int j=0;j<length;j++)
            {
                if(modules[i][j]=="")continue;
                childNode=new DefaultMutableTreeNode(modules[i][j]);
                node.add(childNode);
            }
            root.add(node);
        }
        JTree tree=new JTree(root);

        tree.addMouseListener ( new MouseAdapter()
        {
            public void mousePressed ( MouseEvent e )
            {
                if ( SwingUtilities.isRightMouseButton ( e ) )
                {
                    TreePath path = tree.getPathForLocation ( e.getX (), e.getY () );
                    Rectangle pathBounds = tree.getUI ().getPathBounds ( tree, path );
                    if ( pathBounds != null && pathBounds.contains ( e.getX (), e.getY () ) )
                    {
                        JPopupMenu menu = new JPopupMenu ();
                        menu.add ( new JMenuItem ( "Test" ) );
                        menu.show ( tree, pathBounds.x, pathBounds.y + pathBounds.height );
                    }
                }
            }
        } );

        panel.add(tree);
        panel.setVisible(true);

        return panel;
    }
}
