package com.dabogee.config.tools.owner;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:app.properties"})
interface OwnerAppConfigFromClasspath extends OwnerAppConfig {
}
