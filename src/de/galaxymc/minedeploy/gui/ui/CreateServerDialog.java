package de.galaxymc.minedeploy.gui.ui;

import de.galaxymc.minedeploy.Main;
import de.galaxymc.minedeploy.gui.listener.click.ClickAdapter;
import de.galaxymc.minedeploy.server.server.MinecraftServer;
import de.galaxymc.minedeploy.util.logger.Logger;
import de.galaxymc.minedeploy.util.servertype.MinecraftVersion;
import de.galaxymc.minedeploy.util.servertype.ServerType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class CreateServerDialog extends JDialog {

    JPanel panel;

    JComboBox<ServerType> typeBox;
    JComboBox<Object> versionBox;

    Logger logger;

    boolean serverCreated = false;
    private MinecraftServer server;

    public CreateServerDialog(JFrame owner) {
        super(owner, "Create Server", true);
        logger = new Logger("CreateServerDialog");
        panel = new JPanel();
        panel.setSize(300, 100);

        typeBox = new JComboBox<>(ServerType.values());
        versionBox = new JComboBox<Object>(Arrays.stream(((ServerType) typeBox.getSelectedItem()).getVersions()).map(MinecraftVersion::getName).toArray());

        typeBox.addActionListener(e -> {
            versionBox.removeAllItems();
            for (MinecraftVersion version : ((ServerType) typeBox.getSelectedItem()).getVersions()) {
                versionBox.addItem(version.getName());
            }
        });

        JButton button = new JButton("Create");
        button.addActionListener(new ClickAdapter() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerType st = (ServerType) typeBox.getSelectedItem();
                MinecraftVersion sv = MinecraftVersion.byName((String) versionBox.getSelectedItem());
                MinecraftServer server = new MinecraftServer(sv, st);
                logger.info("Try to create minecraft server");
                if (st == null) {
                    logger.error("TypeBoxItem == null");
                    return;
                }
                if (sv == null) {
                    logger.error("VersionBoxItem == null");
                    return;
                }
                CreateServerDialog.this.server = server;
                Main.mineDeploy.getServerHandler().addServer(server);
                serverCreated = true;
                logger.info("Minecraft-Server created!");
                dispose();
            }
        });
        panel.add(typeBox);
        panel.add(versionBox);
        panel.add(button);
        panel.setVisible(true);
        add(panel);
        setLocationRelativeTo(null);
        setSize(400, 100);
        setResizable(false);
        setVisible(true);
        setModal(true);
        setAlwaysOnTop(true);
    }

    public MinecraftServer getServer() {
        return server;
    }

    public boolean wasServerCreated() {
        return serverCreated;
    }

}