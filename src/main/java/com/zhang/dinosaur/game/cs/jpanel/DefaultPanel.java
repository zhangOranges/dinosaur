package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.common.ConnectProperties;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.compone.InputTextArea;
import com.zhang.dinosaur.game.cs.compone.ShowTextArea;
import com.zhang.dinosaur.game.cs.event.LoadingIpEvent;
import com.zhang.dinosaur.game.cs.event.LoadingPingInfoEvent;
import com.zhang.dinosaur.game.cs.event.RTPChangeSelectTabDefaultPanelEvent;
import com.zhang.dinosaur.game.cs.event.ShowTextAddContentEvent;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

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
                Object valueAt = model.getValueAt(selectedRow, 0);
                log.info("click row {}",valueAt);

                ConnectProperties connectProperties = new ConnectProperties().setAlias(valueAt +"");
                GContextEventBus.post(new RTPChangeSelectTabDefaultPanelEvent(title,connectProperties));
                //测试ping值滚动
                GContextEventBus.post(new LoadingPingInfoEvent());
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
