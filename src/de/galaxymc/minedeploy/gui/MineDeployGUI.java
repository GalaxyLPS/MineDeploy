package de.galaxymc.minedeploy.gui;

import de.galaxymc.minedeploy.Main;
import de.galaxymc.minedeploy.gui.windowlistener.DefaultCloseListener;
import de.galaxymc.minedeploy.head.MineDeployHead;

import javax.swing.*;

public class MineDeployGUI implements MineDeployHead {

    private JFrame jFrame;

    @Override
    public void start() {
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setTitle(Main.mineDeploy.getSetting().GUI_NAME + " Version: " + Main.mineDeploy.getSetting().VERSION);
        jFrame.addWindowListener(new DefaultCloseListener());
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setResizable(false);
    }


    private void createWindow() {
    }

    @Override
    public void end() {
        jFrame.dispose();
    }
}
