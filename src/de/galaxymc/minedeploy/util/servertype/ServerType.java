package de.galaxymc.minedeploy.util.servertype;

import de.galaxymc.minedeploy.server.ServerHandler;

public enum ServerType {

    VANILLA, BUKKIT, SPIGOT, SPONGE, FORGE, BUNGEECORD;

    public static ServerType getFromString(String s) {
        for (ServerType t : values()) {
            if (t.name().equalsIgnoreCase(s)) {
                return t;
            }
        }
        return null;
    }

}