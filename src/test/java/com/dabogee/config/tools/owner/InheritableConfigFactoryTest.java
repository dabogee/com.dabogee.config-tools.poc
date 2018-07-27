package com.dabogee.config.tools.owner;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class InheritableConfigFactoryTest {

    @Test
    public void testPropertiesInheritance() throws Exception {
        OwnerAppConfig config = new InheritableConfigFactory("dev03")
                .create(OwnerAppConfig.class);

        assertThat(config.hostname()).isEqualTo("dev03.app.dabogee.com");
        assertThat(config.port()).isEqualTo(8080);
        assertThat(config.portApi()).isEqualTo(8079);
        assertThat(config.scheme()).isEqualTo("http");
        assertThat(config.debugEnabled()).isTrue();
    }
}
