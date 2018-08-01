package com.dabogee.config.tools.typesafe;

import com.dabogee.config.tools.typesafe.models.AppConfig;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class TypeSafeConfigFactoryTest {

    @Test
    public void testPropertiesInheritance() throws Exception {
        AppConfig config = new TypesafeConfigFactory("dev03")
                .create(AppConfig.class);

        assertThat(config.getHostname()).isEqualTo("dev03.app.dabogee.com");
        assertThat(config.getPort().getClient()).isEqualTo(8080);
        assertThat(config.getPort().getApi()).isEqualTo(8079);
        assertThat(config.getScheme()).isEqualTo("http");
    }
}
