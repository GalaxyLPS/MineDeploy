package de.galaxymc.minedeploy.server;

import de.galaxymc.minedeploy.server.server.MinecraftServer;
import de.galaxymc.minedeploy.util.logger.Logger;
import de.galaxymc.minedeploy.util.servertype.ServerType;

import java.util.ArrayList;
import java.util.HashMap;

public class ServerHandler {

    HashMap<ServerType, ArrayList<MinecraftServer>> servers;

    Logger logger;

    public ServerHandler() {
        logger = new Logger("ServerHandler");
        servers = new HashMap<>();
        for (ServerType serverType : ServerType.values()) {
            servers.put(serverType, new ArrayList<>());
        }
    }

    public void addServer(MinecraftServer server) {
        servers.get(server.getType()).add(server);
    }

    public void removeServer(MinecraftServer server) {
        for (ServerType type : ServerType.values()) {
            servers.get(type).remove(server);
        }
    }

    public MinecraftServer getServer(ServerType type, int id) {
        for (MinecraftServer server : servers.get(type)) {
            if (server.getId() == id) return server;
        }
        return null;
    }

}