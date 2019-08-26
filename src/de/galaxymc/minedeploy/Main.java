package de.galaxymc.minedeploy;

import de.galaxymc.minedeploy.gui.MineDeployGUI;
import de.galaxymc.minedeploy.head.MineDeployHead;
import de.galaxymc.minedeploy.headless.MineDeployConsole;
import de.galaxymc.minedeploy.util.logger.Logger;

public class Main {

    public static MineDeploy mineDeploy;

    public static Logger logger;

    private static boolean headless = false;

    public static void main(String[] args) {
        logger = new Logger("Main");
        logger.info("Start of MineDeploy");
        for (String s : args) {
            if (s.equalsIgnoreCase("--headless")) {
                headless = true;
                logger.warning("Run MineDeploy in headless mode");
                continue;
            }
            logger.error("Unknown program argument: " + s);
        }
        mineDeploy = new MineDeploy();
        MineDeployHead mineDeployHead = headless ? new MineDeployConsole() : new MineDeployGUI();
        mineDeploy.initHead(mineDeployHead);
    }

}
