package de.galaxymc.minedeploy.util.servertype;

public enum MinecraftVersion {

    MC1_7_10,
    MC1_8,
    MC1_9,
    MC1_10,
    MC1_11,
    MC1_12,
    MC1_13,
    MC1_14,
    MC1_15,
    MC1_16;

    public String name;

    MinecraftVersion() {
        name = name().replace("MC", "").replace("_", ".");
    }

    public static MinecraftVersion byName(String name) {
        for (MinecraftVersion t : values()) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}