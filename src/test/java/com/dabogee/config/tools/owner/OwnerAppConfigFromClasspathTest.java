package com.dabogee.config.tools.owner;

import org.aeonbits.owner.ConfigFactory;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class OwnerAppConfigFromClasspathTest {

    @Test
    public void testGet() throws Exception {
        OwnerAppConfigFromClasspath config = ConfigFactory.create(OwnerAppConfigFromClasspath.class);
        assertThat(config.port()).isEqualTo(80);
        assertThat(config.portApi()).isEqualTo(8079);
        assertThat(config.scheme()).isEqualTo("https");
        assertThat(config.hostname()).isEqualTo("app.dabogee.com");
        assertThat(config.debugEnabled()).isFalse();
    }
}
