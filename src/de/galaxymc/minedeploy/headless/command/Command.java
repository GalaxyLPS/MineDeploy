package de.galaxymc.minedeploy.headless.command;

import java.util.HashMap;

public abstract class Command {

    public final String name;
    public final String[] aliases;
    public final String description;
    public final String help;

    public Command(String name, String[] aliases, String description, String help) {
        this.name = name;
        this.aliases = aliases;
        this.description = description;
        this.help = help;
    }

    public abstract void executeCommand(HashMap<String, String> arguments);
}