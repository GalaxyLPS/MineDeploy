package de.galaxymc.minedeploy.server;

import de.galaxymc.minedeploy.server.server.MinecraftServer;
import de.galaxymc.minedeploy.util.logger.Logger;
import de.galaxymc.minedeploy.util.servertype.ServerType;

import java.util.HashMap;

public class ServerHandler {

    HashMap<ServerType, MinecraftServer[]> servers = new HashMap<>();

    Logger logger;

    public ServerHandler() {
        logger = new Logger("ServerHandler");
        for (ServerType serverType : ServerType.values()) {
            servers.put(serverType, new MinecraftServer[100]);
        }
    }

    public void addServer(ServerType type, MinecraftServer server) {
        MinecraftServer[] a = servers.get(type);
        a[getAvailableId(type)] = server;
        servers.put(type, a);
    }

    public void removeServer(MinecraftServer server) {
        for (ServerType type : ServerType.values()) {
            removeServer(type, server);
        }
    }

    public void removeServer(ServerType type, MinecraftServer server) {
        MinecraftServer[] a = servers.get(type);
        for (int i = 0; i < servers.get(type).length; i++) {
            if (servers.get(type)[i] == server) {
                a[i] = null;
                return;
            }
        }
    }

    private int getAvailableId(ServerType type) {
        for (int i = 0; i < servers.get(type).length; i++) {
            if (servers.get(type)[i] == null) {
                return i;
            }
        }
        return -1;
    }

}