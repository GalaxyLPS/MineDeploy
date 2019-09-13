package de.galaxymc.minedeploy.server.server;

import de.galaxymc.minedeploy.util.logger.Logger;

public class MinecraftServer {

    int id; // can be same for multiple servers (different server types)

    Logger logger;

    public MinecraftServer() {
        this.logger = new Logger("MinecraftServer:-1");
    }

    public void start() {
        logger.info("Start Server!");
    }


}