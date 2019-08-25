package de.galaxymc.minedeploy.headless;

import de.galaxymc.minedeploy.head.MineDeployHead;
import de.galaxymc.minedeploy.headless.command.CommandHandler;
import de.galaxymc.minedeploy.headless.command.listener.CommandListener;
import de.galaxymc.minedeploy.headless.command.listener.DefaultCommandListener;

import java.util.Scanner;

public class MineDeployConsole implements MineDeployHead {

    private CommandListener commandListener;
    CommandHandler commandHandler;

    @Override
    public void start() {
        commandListener = new DefaultCommandListener();
        commandListener.begin();
        commandHandler = new CommandHandler();
    }

    @Override
    public void end() {
        commandListener.end();
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }
}
