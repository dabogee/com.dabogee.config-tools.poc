package com.dabogee.config.tools;

import static java.util.Objects.nonNull;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public final class ResourcesFileBrowser {

    public Collection<String> getConfigurations() {
        URL defaultPropsURL = this.getClass().getClassLoader().getResource(PropertiesFinder.DEFAULT_PROPS);

        if (nonNull(defaultPropsURL)) {
            return FileUtils.listFiles(
                    new File(defaultPropsURL.getFile()).getParentFile(),
                    new String[] {PropertiesFinder.PROPS_EXTENSION},
                    true
            ).stream()
                    .map(File::getName)
                    .collect(Collectors.toSet());
        }
        return Collections.emptyList();
    }
}
