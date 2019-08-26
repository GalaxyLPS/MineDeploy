package de.galaxymc.minedeploy.gui.windowlistener;

import java.awt.event.WindowEvent;
import java.nio.file.ClosedDirectoryStreamException;

public class DefaultCloseListener extends CloseListener {


    @Override
    public void windowClosing(WindowEvent e) {
        // shutdown handler
        e.getWindow().dispose();
    }
}