package com.dabogee.config.tools.owner;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:app.qa.qa03.properties",
        "classpath:app.qa.properties",
        "classpath:app.properties",
    })
interface OwnerAppConfigMultipleStaticSources extends OwnerAppConfig {
}
