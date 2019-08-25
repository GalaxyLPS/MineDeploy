package de.galaxymc.minedeploy.gui;

import de.galaxymc.minedeploy.Main;

import javax.swing.*;

public class MineDeployGUI implements IMineDeployGUI {

    JFrame jFrame;


    @Override
    public void openGUI() {
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setTitle(Main.mineDeploy.getSetting().GUI_NAME + " Version: " + Main.mineDeploy.getSetting().VERSION);
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    }
}
