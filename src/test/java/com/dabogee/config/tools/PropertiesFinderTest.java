package com.dabogee.config.tools;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesFinderTest {

    @Test
    public void testFindExactMatch() throws Exception {
        assertThat(new PropertiesFinder("qa03").findExactMatchedConfiguration())
                .isEqualTo("app.qa.qa03.properties");
    }

    @Test
    public void testNoExactMatchOrDefault() throws Exception {
        assertThat(new PropertiesFinder("qa07").findExactMatchedConfiguration())
                .isEqualTo("app.properties");
    }

    @Test
    public void testLoadByFilename() throws Exception {
        Properties props = new PropertiesFinder("dev01").loadPropertiesByFilename("app.dev.dev01.properties");
        assertThat(props.getProperty("hostname")).isEqualTo("dev01.app.dabogee.com");
        assertThat(props.getProperty("scheme")).isEqualTo("https");
        assertThat(props.getProperty("port")).isEqualTo("80");
    }

    @Test
    public void testParseParentConfigurations() throws Exception {
        PropertiesFinder finder = new PropertiesFinder("dev");
        assertThat(finder.parseParentConfigurations("app.dev.dev03.properties"))
                .containsExactly(
                        "app.dev.dev03.properties",
                        "app.dev.properties",
                        "app.properties"
                );
    }

    @Test
    public void testNoParentConfiguration() throws Exception {
        PropertiesFinder finder = new PropertiesFinder("dev");
        assertThat(finder.parseParentConfigurations("app.properties"))
                .containsOnly("app.properties");
    }

    @Test
    public void testFind() throws Exception {
        PropertiesFinder finder = new PropertiesFinder("dev03");
        Properties[] props = finder.find();
        assertThat(props).hasSize(3);
    }
}
