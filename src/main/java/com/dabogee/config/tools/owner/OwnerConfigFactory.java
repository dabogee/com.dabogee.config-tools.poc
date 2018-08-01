package com.dabogee.config.tools.owner;

import com.dabogee.config.tools.PropertiesFinder;
import static com.google.common.base.Preconditions.checkNotNull;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public final class OwnerConfigFactory {

    private String environment;

    public OwnerConfigFactory(String environment) {
        checkNotNull(environment);
        this.environment = environment;
    }

    public <T extends Config> T create(Class<? extends T> clazz) {
        return ConfigFactory.create(
                clazz,
                new PropertiesFinder(environment).find()
        );
    }
}
