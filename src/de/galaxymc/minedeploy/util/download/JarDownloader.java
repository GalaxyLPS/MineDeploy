package de.galaxymc.minedeploy.util.download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class JarDownloader {

    private final String url;
    private final String destination;

    public JarDownloader(String url, String destination) {
        this.url = url;
        this.destination = destination;
    }

    public void download() throws IOException {
        URL url = new URL(this.url);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(destination);
        FileChannel fc = fos.getChannel();
        fc.transferFrom(rbc, 0, Long.MAX_VALUE);
    }

    public String getDestination() {
        return destination;
    }

    public String getUrl() {
        return url;
    }
}