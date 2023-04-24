package com.zhang.dinosaur.game.demo;
import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class CustomJTreeExample {
    public static void main(String[] args) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(){
            @Override
            public String toString() {
                return "Root";
            }
        };
        root.setUserObject(null);
        MyPanel myPanel = new MyPanel();
        MyPanel myPanel2 = new MyPanel();
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(new MyNode("C1", myPanel));
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode(new MyNode("C2", myPanel2));
//        root.add(child1);
//        root.add(child2);
        root.add(new DefaultMutableTreeNode("/usr"));


        // Create a tree model and set it in a JTree
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        JTree tree = new JTree(treeModel);

        tree.addMouseMotionListener(getML());



        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = e.getNewLeadSelectionPath();
                if (path != null) {
                    // 判断选中节点是否为自定义Panel节点
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (node != null) {
                        // 处理点击事件
                        System.out.println(path.getLastPathComponent());
//                        ((MyPanel)((MyNode)node.getUserObject()).getPanel()).clicked();
                    }
                }
            }
        });


        // Set the custom cell renderer for the JTree
        tree.setCellRenderer(new CustomCellRenderer());
        tree.setCellEditor(new xx(tree,new DefaultTreeCellRenderer()));

        // Display the JTree in a JFrame
        JFrame frame = new JFrame("Custom JTree Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(tree));
        frame.pack();
        frame.setVisible(true);
    }
    static class MyNode {
        private String name;
        private JPanel panel;

        public MyNode(String name, JPanel panel) {
            this.name = name;
            this.panel = panel;
        }

        public String getName() {
            return name;
        }

        public JPanel getPanel() {
            return panel;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class xx extends DefaultTreeCellEditor{
        public xx(JTree tree, DefaultTreeCellRenderer renderer) {
            super(tree, renderer);
        }

        @Override
        public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
//            return super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
            JPanel jPanel = new JPanel();
            jPanel.add(new JLabel(value+""));
            jPanel.add(new JButton("ceshi"));
            jPanel.addMouseListener(getML());
            return jPanel;
        }
    }
    static class CustomCellRenderer extends DefaultTreeCellRenderer {
        JButton button = new JButton("Button");

        public CustomCellRenderer() {
//            setLayout(new BorderLayout());

            setOpaque(false);
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            if (!leaf){
                super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            }else{
                JPanel jPanel = new JPanel();
                jPanel.add(new JLabel(value+""));
                jPanel.add(new JButton("ceshi"));
                jPanel.addMouseListener(getML());
                return jPanel;
            }

            return this;
        }

    }


    public static MouseAdapter getML(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("mouseMoved");
            }


        };
    }

    static class MyTreeCellRenderer extends JPanel implements TreeCellRenderer{

        private JPanel childPanel;
        private Color hoverColor = Color.LIGHT_GRAY;
        public MyTreeCellRenderer() {
            setLayout(new MigLayout());
            childPanel = new JPanel(new MigLayout("",""));
            childPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

            add(childPanel);
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                      boolean expanded, boolean leaf, int row, boolean hasFocus) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();

            if (userObject instanceof MyNode) {
                MyNode myNode = (MyNode) userObject;
                childPanel.removeAll();
                MyPanel panel = (MyPanel) myNode.getPanel();
                panel.removeAll();
                panel.init();
                if (selected){
                    JButton button = new JButton("hello");
                    button.addActionListener(e->{
                        System.out.println("bu clieck");
                    });
                    button.setBackground(Color.GREEN);
                    panel.add(button);
                }
                panel.setBackground(Color.MAGENTA);
                childPanel.setPreferredSize(new Dimension(300,50));
                childPanel.add(panel);
                childPanel.revalidate();
                childPanel.repaint();
                if (selected) {
                    childPanel.setBackground(hoverColor);
                    childPanel.setForeground(UIManager.getColor("Tree.selectionForeground"));
                } else {
                    childPanel.setBackground(UIManager.getColor("Tree.textBackground"));
                    childPanel.setForeground(UIManager.getColor("Tree.textForeground"));
                }
                return childPanel;
            } else {
                JLabel label = new JLabel(value.toString());
                label.setOpaque(true);
                if (selected) {
                    label.setBackground(UIManager.getColor("Tree.selectionBackground"));
                    label.setForeground(UIManager.getColor("Tree.selectionForeground"));
                } else {
                    label.setBackground(UIManager.getColor("Tree.textBackground"));
                    label.setForeground(UIManager.getColor("Tree.textForeground"));
                }
                return label;
            }

        }

    }

    static class MyPanel extends JPanel {

        private ImageIcon icon;
        private JButton jButton;

        public MyPanel() {
            init();
        }

        public void init(){
            add(new JLabel("My Panel1"));
            icon = new ImageIcon(getClass().getResource("/img/computer.png"));
            jButton = new JButton("hello");
//            jButton.setBackground(new Color(0,0,0,0));
            jButton.addActionListener((e)->{
                System.out.println("e");
            });
            add(jButton);
            hidden();
            setOpaque(true);
            setFocusable(true);
        }
        public void hidden(){
            jButton.setVisible(false);
        }
        public void shows(){
            jButton.setVisible(true);
        }

        public void clicked(){
            jButton.doClick();
        }
    }
}
