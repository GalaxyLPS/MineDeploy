package de.galaxymc.minedeploy.gui.listener.open;

import de.galaxymc.minedeploy.util.logger.Logger;

import java.awt.event.WindowEvent;

public class DefaultOpenAdapter extends OpenAdapter {

    Logger logger;

    public DefaultOpenAdapter() {
        this.logger = new Logger("WindowOpenAdapter");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        logger.info("Window Opened!");
    }
}