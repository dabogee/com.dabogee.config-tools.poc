package com.dabogee.config.tools.owner;

import org.aeonbits.owner.Config;

public interface OwnerAppConfig extends Config {

    @Key("port.client")
    int port();

    @Key("port.api")
    int portApi();

    String scheme();

    String hostname();

    @Key("debug")
    @DefaultValue("false")
    Boolean debugEnabled();
}
