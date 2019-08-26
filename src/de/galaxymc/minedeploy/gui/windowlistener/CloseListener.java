package de.galaxymc.minedeploy.gui.windowlistener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class CloseListener extends WindowAdapter {

    public abstract void windowClosing(WindowEvent e);

}