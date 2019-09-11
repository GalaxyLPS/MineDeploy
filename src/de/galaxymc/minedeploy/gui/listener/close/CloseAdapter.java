package de.galaxymc.minedeploy.gui.listener.close;

import de.galaxymc.minedeploy.gui.listener.MineDeployWindowAdapter;

import java.awt.event.WindowEvent;

public abstract class CloseAdapter extends MineDeployWindowAdapter {

    public abstract void windowClosing(WindowEvent e);

}