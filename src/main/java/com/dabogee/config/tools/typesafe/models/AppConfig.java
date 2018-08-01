package com.dabogee.config.tools.typesafe.models;

public class AppConfig {

    private AppPort port;

    private String scheme;
    private String hostname;

    public AppPort getPort() {
        return port;
    }

    public void setPort(AppPort port) {
        this.port = port;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
