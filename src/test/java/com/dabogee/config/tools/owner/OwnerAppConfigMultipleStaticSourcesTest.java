package com.dabogee.config.tools.owner;

import org.aeonbits.owner.ConfigFactory;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class OwnerAppConfigMultipleStaticSourcesTest {

    @Test
    public void testGet() throws Exception {
        OwnerAppConfigMultipleStaticSources config =
                ConfigFactory.create(OwnerAppConfigMultipleStaticSources.class);

        assertThat(config.hostname()).isEqualTo("qa03.app.dabogee.com");
        assertThat(config.portApi()).isEqualTo(8079);
        assertThat(config.scheme()).isEqualTo("http");
        assertThat(config.port()).isEqualTo(7089);
        assertThat(config.debugEnabled()).isTrue();
    }
}
