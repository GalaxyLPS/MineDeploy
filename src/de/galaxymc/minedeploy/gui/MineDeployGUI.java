package de.galaxymc.minedeploy.gui;

import de.galaxymc.minedeploy.Main;
import de.galaxymc.minedeploy.gui.listener.close.DefaultCloseAdapter;
import de.galaxymc.minedeploy.gui.listener.open.DefaultOpenAdapter;
import de.galaxymc.minedeploy.head.MineDeployHead;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MineDeployGUI implements MineDeployHead {

    private JFrame jFrame;

    JMenuBar bar;

    JScrollPane consoleScroll;
    JTextArea console;


    @Override
    public void start() {
        createWindow();
    }


    private void createWindow() {
        jFrame = new JFrame();
        jFrame.setTitle(Main.mineDeploy.getSetting().GUI_NAME + " Version: " + Main.mineDeploy.getSetting().VERSION);
        jFrame.addWindowListener(new DefaultCloseAdapter());
        jFrame.addWindowListener(new DefaultOpenAdapter());
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setResizable(false);
        jFrame.setLayout(new BorderLayout());
        createMenuBar();
        jFrame.setJMenuBar(bar);
        createMainWindowContent();

        jFrame.add(consoleScroll, BorderLayout.CENTER);

        jFrame.setVisible(true);
    }

    private void createMainWindowContent() {
        consoleScroll = new JScrollPane();
        console = new JTextArea();
        console.setAutoscrolls(true);
        console.setEditable(false);
        console.setBackground(Color.BLACK);
        console.setText("Hallo dis very long text.");
        consoleScroll.add(console);
    }

    private void createMenuBar() {
        bar = new JMenuBar();

        JMenu server = new JMenu("Server");
        JMenu download = new JMenu("Download");
        JMenu about = new JMenu("About");

        JMenuItem create = new JMenuItem("Create");
        JMenuItem delete = new JMenuItem("Delete");
        server.add(create);
        server.add(delete);

        JMenuItem versions = new JMenuItem("Versions");
        JMenuItem status = new JMenuItem("Status");
        download.add(versions);
        download.add(status);

        JMenuItem version = new JMenuItem("Version");
        JMenuItem developer = new JMenuItem("Developer");
        about.add(version);
        about.add(developer);

        bar.add(server);
        bar.add(download);
        bar.add(about);
    }

    @Override
    public void end() {
        jFrame.dispose();
    }// TODO: add shutdown hook
}
