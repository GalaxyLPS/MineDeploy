package de.galaxymc.minedeploy.server.server;

import de.galaxymc.minedeploy.util.logger.Logger;
import de.galaxymc.minedeploy.util.servertype.MinecraftVersion;
import de.galaxymc.minedeploy.util.servertype.ServerType;

public class MinecraftServer {

    int id; // can be same for multiple servers (different server types)
    Logger logger;
    MinecraftVersion version;
    ServerType type;

    public MinecraftServer(MinecraftVersion version, ServerType type) {
        this.logger = new Logger("MinecraftServer:" + id);
        this.type = type;
        this.version = version;
    }

    public void start() {
        logger.info("Start Server!");
    }

    public MinecraftVersion getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }

    public ServerType getType() {
        return type;
    }
}