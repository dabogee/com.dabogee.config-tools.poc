package com.dabogee.config.tools;

import static java.lang.String.format;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public final class PropertiesFinder {

    static final String DEFAULT_PROPS = "app.properties";
    static final String PROPS_EXTENSION = "properties";

    private static final Properties EMPTY_PROPERTIES = new Properties();
    private String environment;

    public PropertiesFinder(String environment) {
        this.environment = environment;
    }

    public Properties[] find() {
        return parseParentConfigurations(findExactMatchedConfiguration())
                .stream()
                .map(this::loadPropertiesByFilename)
                .collect(Collectors.toList())
                .toArray(new Properties[]{});
    }

    Properties loadPropertiesByFilename(String filename) {
        try {
            Properties out = new Properties();
            ClassLoader classLoader = this.getClass().getClassLoader();
            out.load(classLoader.getResourceAsStream(filename));
            return out;
        }
        catch (IOException e) {
            return EMPTY_PROPERTIES;
        }
    }

    String findExactMatchedConfiguration() {
        return new ResourcesFileBrowser()
                .getConfigurations()
                .stream()
                .filter(c -> c.endsWith(format("%s.%s", environment, PROPS_EXTENSION)))
                .sorted(Comparator.comparing(String::length))
                .findFirst()
                .orElse(DEFAULT_PROPS);
    }

    List<String> parseParentConfigurations(String configuration) {
        List<String> result = new ArrayList<>();
        if (configuration != null) {
            String candidate = configuration;
            do {
                candidate = StringUtils.substringBeforeLast(candidate, ".");
                result.add(format("%s.%s", candidate, PROPS_EXTENSION));
            }
            while (!candidate.equals(StringUtils.substringBeforeLast(candidate, ".")));
        }
        return result;
    }
}
