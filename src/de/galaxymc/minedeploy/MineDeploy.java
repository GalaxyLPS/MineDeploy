package de.galaxymc.minedeploy;

import de.galaxymc.minedeploy.gui.MineDeployGUI;
import de.galaxymc.minedeploy.head.MineDeployHead;
import de.galaxymc.minedeploy.server.ServerHandler;
import de.galaxymc.minedeploy.util.setting.MineDeploySetting;

public class MineDeploy {

    MineDeployHead mineDeployHead;
    MineDeploySetting setting;
    ServerHandler serverHandler;

    public MineDeploy() {
        this.setting = new MineDeploySetting();
        // can't use head in constructor
    }

    public void initHead(MineDeployHead mineDeployHead) {
        this.mineDeployHead = mineDeployHead;
        this.mineDeployHead.start();
        this.serverHandler = new ServerHandler();
    }

    public MineDeployHead getMineDeployHead() {
        return mineDeployHead;
    }

    public MineDeploySetting getSetting() {
        return setting;
    }

    public ServerHandler getServerHandler() {
        return serverHandler;
    }
}