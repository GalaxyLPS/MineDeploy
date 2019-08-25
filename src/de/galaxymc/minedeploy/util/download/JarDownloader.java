package de.galaxymc.minedeploy.util.download;

public abstract class JarDownloader {

    protected final String url;
    

    public JarDownloader(String url) {
        this.url = url;
    }
}