package de.galaxymc.minedeploy.gui;

import de.galaxymc.minedeploy.Main;
import de.galaxymc.minedeploy.gui.listener.click.ClickAdapter;
import de.galaxymc.minedeploy.gui.listener.close.DefaultCloseAdapter;
import de.galaxymc.minedeploy.gui.listener.open.DefaultOpenAdapter;
import de.galaxymc.minedeploy.gui.ui.CreateServerDialog;
import de.galaxymc.minedeploy.head.MineDeployHead;
import de.galaxymc.minedeploy.util.logger.Logger;
import de.galaxymc.minedeploy.util.servertype.ServerType;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MineDeployGUI implements MineDeployHead {

    private JFrame jFrame;

    Logger logger;


    JMenuBar bar;

    JScrollPane scrollPane;
    JTextArea console;

    JPanel noSelectedPanel;

    JTree serverTree;

    public MineDeployGUI() {
        logger = new Logger("MineDeployGUI");
        ;
    }

    @Override
    public void start() {
        logger.info("Start MineDeployGUI");
        createWindow();
    }


    private void createWindow() {
        jFrame = new JFrame();
        jFrame.setTitle(Main.mineDeploy.getSetting().GUI_NAME + " Version: " + Main.mineDeploy.getSetting().VERSION);
        jFrame.addWindowListener(new DefaultCloseAdapter());
        jFrame.addWindowListener(new DefaultOpenAdapter());
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame.setSize(800, 800);
        jFrame.setResizable(false);
        jFrame.setLayout(new BorderLayout());
        jFrame.setLocationRelativeTo(null);
        createMenuBar();
        jFrame.setJMenuBar(bar);
        createMainWindowContent();

        jFrame.add(new JScrollPane(serverTree), BorderLayout.WEST);
        jFrame.add(new JScrollPane(noSelectedPanel), BorderLayout.CENTER);
        jFrame.add(scrollPane, BorderLayout.EAST);

        jFrame.setVisible(true);
    }

    private void createMainWindowContent() {
        DefaultMutableTreeNode servers = new DefaultMutableTreeNode("Servers");
        for (ServerType serverType : ServerType.values()) {

            servers.add(new DefaultMutableTreeNode(serverType.name()));
        }
        serverTree = new JTree(servers);

        JButton button = new JButton("Add Server");

        button.addActionListener(new ClickAdapter() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("add server click performed");
                CreateServerDialog dialog = new CreateServerDialog(jFrame);
            }
        });

        noSelectedPanel = new JPanel();
        noSelectedPanel.add(button);


        console = new JTextArea();
        //console.setText("Hallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long text");
        scrollPane = new JScrollPane(console);
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
