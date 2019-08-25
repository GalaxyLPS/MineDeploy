package de.galaxymc.minedeploy;

import de.galaxymc.minedeploy.gui.MineDeployGUI;
import de.galaxymc.minedeploy.head.MineDeployHead;
import de.galaxymc.minedeploy.util.setting.MineDeploySetting;

public class MineDeploy {

    MineDeployHead mineDeployHead;
    MineDeploySetting setting;

    public MineDeploy(MineDeployHead head) {
        this.mineDeployHead = head;
        this.setting = new MineDeploySetting();
        this.mineDeployHead.start();
    }

    public MineDeployHead getMineDeployHead() {
        return mineDeployHead;
    }

    public MineDeploySetting getSetting() {
        return setting;
    }
}