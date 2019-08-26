package de.galaxymc.minedeploy;

import de.galaxymc.minedeploy.gui.MineDeployGUI;
import de.galaxymc.minedeploy.head.MineDeployHead;
import de.galaxymc.minedeploy.util.setting.MineDeploySetting;

public class MineDeploy {

    MineDeployHead mineDeployHead;
    MineDeploySetting setting;

    public MineDeploy() {
        this.setting = new MineDeploySetting();
        // can't use head in constructer
    }

    public void initHead(MineDeployHead mineDeployHead) {
        this.mineDeployHead = mineDeployHead;
        this.mineDeployHead.start();
    }

    public MineDeployHead getMineDeployHead() {
        return mineDeployHead;
    }

    public MineDeploySetting getSetting() {
        return setting;
    }
}