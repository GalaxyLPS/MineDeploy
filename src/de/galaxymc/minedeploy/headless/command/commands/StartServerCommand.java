package de.galaxymc.minedeploy.headless.command.commands;

import de.galaxymc.minedeploy.headless.command.Command;

import java.util.ArrayList;
import java.util.HashMap;

public class StartServerCommand extends Command {

    public StartServerCommand() {
        super("startserver", new String[]{"start"}, "start minecraft server", "start <Server>");
    }

    @Override
    public void executeCommand(HashMap<String, String> args) {

    }
}
