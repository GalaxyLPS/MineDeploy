package de.galaxymc.minedeploy.headless.command;

import java.util.ArrayList;

public class CommandHandler {

    private final ArrayList<Command> commands;

    public CommandHandler() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void removeCommand(Command command) {
        this.commands.remove(command);
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }
}