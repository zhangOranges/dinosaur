package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.compone.InputTextArea;
import com.zhang.dinosaur.game.cs.compone.ShowTextArea;
import com.zhang.dinosaur.game.cs.event.ShowTextAddContentEvent;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
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
                JOptionPane.showMessageDialog(this, "no action");
            });

        });

        add(jPanel);

        String[] columnNames = {"host",
                "folder",
                "name"};
        Object[][] data = GContext.getHostInfo();
        if (data == null){
            data = new Object[][]{
                    {"127.0.0.1", "/", "root","idx"},
            };
        }
        JTable jTable = new JTable(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setSelectionMode(SINGLE_SELECTION);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = jTable.getSelectedRow();
                TableModel model = jTable.getModel();
                Object valueAt = model.getValueAt(selectedRow, 3);
                log.info("click row {}",valueAt);
                //通过点击  去connect host
                int i = jTabbedPane.indexOfTab(title);
                JPanel mainRightPanel = new JPanel(new MigLayout("wrap,fill","[grow,fill]","[grow 75,fill]0[grow 25,fill]"));

                MainPanel mainPanel = new MainPanel();

                JPanel mainPanel2 = new JPanel(new MigLayout("wrap,insets 0 0 0 0","grow,fill","[]0[]"));
                mainPanel2.setOpaque(false);

                JTextArea noEditTextArea = new ShowTextArea();



                GContextEventBus.post(new ShowTextAddContentEvent("connect server...",null));
                JTextArea jTextArea = new InputTextArea();

                mainPanel2.add(noEditTextArea);
                mainPanel2.add(jTextArea);
                JScrollPane scrollPane = new MainJScrollPane(mainPanel2);

                mainPanel.add(scrollPane);

                //add text
                mainPanel.add(new MainToolBarPanel());

                mainRightPanel.add(mainPanel);
                JTabbedPane jTabbedPane = new JTabbedPane();
                jTabbedPane.add("file",new FilePanel());

                JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, mainPanel, jTabbedPane);
                splitPane.setDividerLocation(400);
                splitPane.setResizeWeight(0.6);

                mainRightPanel.add(splitPane);
                DefaultPanel.this.jTabbedPane.setComponentAt(i,mainRightPanel);
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
