package de.galaxymc.minedeploy.headless.command.listener;

import de.galaxymc.minedeploy.Main;
import de.galaxymc.minedeploy.headless.MineDeployConsole;
import de.galaxymc.minedeploy.headless.command.Command;
import de.galaxymc.minedeploy.headless.command.CommandHandler;
import de.galaxymc.minedeploy.util.array.ArrayHelper;
import de.galaxymc.minedeploy.util.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DefaultCommandListener implements CommandListener {

    Scanner scanner;

    boolean stop = false;

    Logger logger;

    @Override
    public void begin() {
        logger = new Logger("DefaultCommandListener");
        logger.info("Begin of DefaultCommandListener");
        scanner = new Scanner(System.in);
        beginListening();

    }

    @Override
    public void end() {
        logger.info("End of DefaultCommandListener");
    }

    private void beginListening() {
        Thread t = new Thread(() -> {
            Logger logger = new Logger("DefaultCommandListenerRun");
            logger.info("Begin of DefaultCommandListenerRun");
            String in;
            while (!stop) {
                in = scanner.nextLine();
                if (in == null || in.equalsIgnoreCase("")) continue;
                String first = in.split(" ")[0]; // first word in string
                for (Command c : ((MineDeployConsole) Main.mineDeploy.getMineDeployHead()).getCommandHandler().getCommands()) {
                    if (c.name.equalsIgnoreCase(first)) {
                        logger.info("execute command " + c.name + "! [" + in + "]");
                        executeCommand(c, (String[]) ArrayHelper.shiftArrayToLeft(1, in.split(" ")));
                        continue; // continue if other command have same name/alias
                    }
                    for (String s : c.aliases) {
                        if (s.equalsIgnoreCase(first)) {
                            logger.info("execute command " + c.name + "! [" + in + "]");
                            executeCommand(c, (String[]) ArrayHelper.shiftArrayToLeft(1, in.split(" ")));
                        }
                    }
                }
            }
            logger.info("Terminate DefaultCommandListenerRun");
            Thread.currentThread().interrupt();
        });
        t.setName("DefaultCommandListener-Listener");
        t.start();
    }

    private void endListening() {
        stop = true;
    }

    private void executeCommand(Command command, String[] args) {
        HashMap<String, String> arguments = new HashMap<>();
        for (String s : args) {
            if (s.contains(":")) {
                String[] arg = s.split(":");
                arguments.put(arg[0], arg[0]);
            }
        }
        command.executeCommand(arguments);
    }

}