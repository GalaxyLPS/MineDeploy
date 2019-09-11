package de.galaxymc.minedeploy.gui.listener;

import de.galaxymc.minedeploy.util.logger.Logger;

import java.awt.event.WindowAdapter;

public abstract class MinedeployWindowAdapter extends WindowAdapter {

    protected Logger logger;

    public MinedeployWindowAdapter() {
        this.logger = new Logger("AbstractWindowAdapter");
    }
}