package de.galaxymc.minedeploy;

import de.galaxymc.minedeploy.gui.IMineDeployGUI;
import de.galaxymc.minedeploy.gui.MineDeployGUI;
import de.galaxymc.minedeploy.util.setting.MineDeploySetting;

public class MineDeploy {

    IMineDeployGUI deployGUI;
    MineDeploySetting setting;

    public MineDeploy() {
        this.deployGUI = new MineDeployGUI();
        this.setting = new MineDeploySetting();
        this.deployGUI.openGUI();
    }

    public IMineDeployGUI getDeployGUI() {
        return deployGUI;
    }

    public MineDeploySetting getSetting() {
        return setting;
    }
}