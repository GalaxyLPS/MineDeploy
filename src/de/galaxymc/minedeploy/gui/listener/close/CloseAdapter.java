package de.galaxymc.minedeploy.gui.listener.close;

import de.galaxymc.minedeploy.gui.listener.MinedeployWindowAdapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class CloseAdapter extends MinedeployWindowAdapter {

    public abstract void windowClosing(WindowEvent e);

}