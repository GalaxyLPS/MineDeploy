package de.galaxymc.minedeploy.gui.listener;

import de.galaxymc.minedeploy.util.logger.Logger;

import java.awt.event.WindowAdapter;

public abstract class MineDeployWindowAdapter extends WindowAdapter {

    protected Logger logger;

    public MineDeployWindowAdapter() {
        this.logger = new Logger("AbstractWindowAdapter");
    }
}