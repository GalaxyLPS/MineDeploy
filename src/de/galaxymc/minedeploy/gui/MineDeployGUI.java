package de.galaxymc.minedeploy.gui;

import de.galaxymc.minedeploy.Main;
import de.galaxymc.minedeploy.gui.listener.click.ClickAdapter;
import de.galaxymc.minedeploy.gui.listener.close.DefaultCloseAdapter;
import de.galaxymc.minedeploy.gui.listener.open.DefaultOpenAdapter;
import de.galaxymc.minedeploy.gui.ui.CreateServerDialog;
import de.galaxymc.minedeploy.head.MineDeployHead;
import de.galaxymc.minedeploy.server.server.MinecraftServer;
import de.galaxymc.minedeploy.util.logger.Logger;
import de.galaxymc.minedeploy.util.servertype.ServerType;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class MineDeployGUI implements MineDeployHead {

    Logger logger;
    JMenuBar bar;
    JScrollPane scrollPane;
    JTextArea console;
    JPanel noSelectedPanel;
    JTree serverTree;

    private JFrame jFrame;

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
        serverTree.addTreeSelectionListener(e -> {
            try {
                int id = Integer.parseInt(e.getNewLeadSelectionPath().getLastPathComponent().toString());
                ServerType type = ServerType.valueOf(e.getNewLeadSelectionPath().getPath()[1].toString());
                MinecraftServer server = Main.mineDeploy.getServerHandler().getServer(type, id);
            } catch (NumberFormatException nfe) {

            }
//            ServerType type = ServerType.valueOf(e.getNewLeadSelectionPath().getLastPathComponent().toString());
//            if (type != null) {
//
//                return;
//            }
        });

        JButton addServer = new JButton("Add Server");

        addServer.addActionListener(new ClickAdapter() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("add server click");
                CreateServerDialog dialog = new CreateServerDialog(jFrame);
                if (dialog.wasServerCreated()) {
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode) serverTree.getModel().getRoot();
                    Iterator<TreeNode> nodeIterator = root.children().asIterator();
                    while (nodeIterator.hasNext()) {
                        DefaultMutableTreeNode n = (DefaultMutableTreeNode) nodeIterator.next();
                        ServerType type = ServerType.getFromString(n.toString());
                        if (type == null) {
                            logger.error("Couldn't find matching server type");
                            return;
                        }
                        if (dialog.getServer().getType() == type) {
                            n.add(new DefaultMutableTreeNode(dialog.getServer().getVersion().getName() + "-" + dialog.getServer().getId()));
                            Main.mineDeploy.getServerHandler().addServer(dialog.getServer());
                            logger.info("Minecraft server with id " + dialog.getServer().getId() + " and version " + dialog.getServer().getVersion() + " was added!");
                            break;
                        }
                    }
                }
            }
        });

        noSelectedPanel = new JPanel();
        noSelectedPanel.add(addServer);


        console = new JTextArea();
        scrollPane = new JScrollPane(console);
        //console.setText("Hallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long textHallo o dis ver o y long text");
        console.setMaximumSize(scrollPane.getMaximumSize());
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
