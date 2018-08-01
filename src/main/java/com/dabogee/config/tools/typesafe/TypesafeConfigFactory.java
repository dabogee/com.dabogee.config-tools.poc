package com.dabogee.config.tools.typesafe;

import com.dabogee.config.tools.PropertiesFinder;
import static com.google.common.base.Preconditions.checkNotNull;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

import java.util.List;

public class TypesafeConfigFactory {

    private String environment;

    public TypesafeConfigFactory(String environment) {
        checkNotNull(environment);
        this.environment = environment;
    }

    public <T> T create(Class<T> clazz) {
        List<String> configs = new PropertiesFinder(environment).findOrderedList();
        Config out = ConfigFactory.load();

        for (String c : configs) {
            out = out.withFallback(ConfigFactory.load(c));
        }
        return ConfigBeanFactory.create(out, clazz);
    }
}
