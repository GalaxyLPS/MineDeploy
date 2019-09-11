package de.galaxymc.minedeploy.gui.listener.close;

import de.galaxymc.minedeploy.util.logger.Logger;

import java.awt.event.WindowEvent;

public class DefaultCloseAdapter extends CloseAdapter {

    Logger logger;

    public DefaultCloseAdapter() {
        logger = new Logger("WindowCloseAdapter");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // shutdown handler
        logger.info("Close Window!");
        e.getWindow().dispose();
    }
}