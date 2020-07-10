package de.galaxymc.minedeploy.util.servertype;

public enum ServerType {

    VANILLA(MinecraftVersion.values()), BUKKIT(MinecraftVersion.values()), SPIGOT(MinecraftVersion.values()), SPONGE(MinecraftVersion.MC1_8, MinecraftVersion.MC1_9), FORGE(MinecraftVersion.values()), BUNGEECORD();

    private final MinecraftVersion[] versions;

    ServerType(MinecraftVersion... versions) {
        this.versions = versions;
    }

    public static ServerType getFromString(String s) {
        for (ServerType t : values()) {
            if (t.name().equalsIgnoreCase(s)) {
                return t;
            }
        }
        return null;
    }

    public MinecraftVersion[] getVersions() {
        return versions;
    }

}