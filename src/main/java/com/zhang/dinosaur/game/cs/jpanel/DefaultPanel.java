package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.GContext;
import com.zhang.dinosaur.game.TipFrame;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 * 默认panel
 */
@Slf4j
public class DefaultPanel extends JPanel {
    private JTabbedPane jTabbedPane;
    private String title;
    public DefaultPanel() {
        super(new MigLayout("wrap,insets 20 40 0 40","[grow,fill]",""));
        JPanel jPanel = new JPanel(new MigLayout("fill","[left][right]"));
        jPanel.setBackground(Color.LIGHT_GRAY);
        jPanel.setPreferredSize(new Dimension(this.getWidth(),30));


        Button clear = new Button("clear");
        jPanel.add(new JLabel("quick connect"));
        jPanel.add(clear,"align right");
        clear.addActionListener((e)->{
            SwingUtilities.invokeLater(()->{
                new TipFrame("no action");
            });

        });

        add(jPanel);

        String[] columnNames = {"host",
                "folder",
                "name"};
        Object[][] data = GContext.getHostInfo();
        if (data == null){
            data = new Object[][]{
                    {"127.0.0.1", "/",
                            "root"},
            };
        }
        JTable jTable = new JTable(data,columnNames);
        jTable.setSelectionMode(SINGLE_SELECTION);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = jTable.getSelectedRow();
                TableModel model = jTable.getModel();
                Object valueAt = model.getValueAt(selectedRow, 0);
                //通过点击  去connect host
                int i = jTabbedPane.indexOfTab(title);
                JPanel mainRightPanel = new JPanel(new MigLayout("wrap,fill","[grow,fill]","[grow 75,fill]0[grow 25,fill]"));
                mainRightPanel.add(new MainPanel());
                mainRightPanel.add(new JTabbedPane());
                jTabbedPane.setComponentAt(i,mainRightPanel);
            }
        });

        add(jTable);
    }

    public void setPanel(JTabbedPane jTabbedPane) {
        this.jTabbedPane = jTabbedPane;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
