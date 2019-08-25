package de.galaxymc.minedeploy.util.logger;

public class Logger {

    private final String name;

    public Logger(String name) {
        this.name = name;
    }

    public void info(String log) {
        log("[Thread/" + name + "] Info -> " + log);
    }

    public void warning(String log) {
        log("[Thread/" + name + "] Warning -> " + log);
    }

    public void error(String log) {
        log("[Thread/" + name + "] Error -> " + log);
    }

    private void log(String log) {
        System.out.println(log);
    }

}