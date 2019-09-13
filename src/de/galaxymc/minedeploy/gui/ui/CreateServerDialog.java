package de.galaxymc.minedeploy.gui.ui;

import de.galaxymc.minedeploy.Main;
import de.galaxymc.minedeploy.gui.listener.click.ClickAdapter;
import de.galaxymc.minedeploy.server.server.MinecraftServer;
import de.galaxymc.minedeploy.util.logger.Logger;
import de.galaxymc.minedeploy.util.servertype.ServerType;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CreateServerDialog extends JDialog {

    JPanel panel;

    JComboBox comboBox;

    Logger logger;

    public CreateServerDialog(JFrame owner) {
        super(owner, "Create Server", true);
        logger = new Logger("CreateServerDialog");
        panel = new JPanel();
        panel.setSize(300, 100);

        comboBox = new JComboBox(ServerType.values());

        JButton button = new JButton("Create");
        button.addActionListener(new ClickAdapter() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MinecraftServer server = new MinecraftServer();
                ServerType st = (ServerType) comboBox.getSelectedItem();
                logger.info("Try to create minecraft server");
                if (st == null) {
                    logger.error("ComboBoxItem == null");
                    return;
                }
                Main.mineDeploy.getServerHandler().addServer(st, server);
                dispose();
            }
        });
        panel.add(comboBox);
        panel.add(button);
        panel.setVisible(true);
        add(panel);
        setLocationRelativeTo(null);
        setSize(300, 100);
        setResizable(false);
        setVisible(true);
        setModal(true);
        setAlwaysOnTop(true);
    }

}