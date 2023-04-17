package com.zhang.dinosaur.game.cs.compone;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.event.TreeClickedEvent;
import com.zhang.dinosaur.game.cs.listener.TreeClickedListener;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
@Slf4j
public class FileTable extends JTable implements TreeClickedListener {
    public FileTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        setSelectionMode(SINGLE_SELECTION);
        GContextEventBus.register(this);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    @Subscribe
    public void action(TreeClickedEvent e) {
        String path = e.getPath();
        log.debug("点击的path  = {}",path);

    }
}
