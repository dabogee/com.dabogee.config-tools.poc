package com.dabogee.config.tools.typesafe;

import com.dabogee.config.tools.typesafe.models.AppConfig;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class TypeSafeConfigFactoryUsageTest {

    @Test
    public void testLoad() throws Exception {
        Config cfg = ConfigFactory.load("app");
        assertThat(cfg.getInt("port.client")).isEqualTo(80);
        assertThat(cfg.getInt("port.api")).isEqualTo(8079);
        assertThat(cfg.getString("scheme")).isEqualTo("https");
        assertThat(cfg.getString("hostname")).isEqualTo("app.dabogee.com");
    }

    @Test(expectedExceptions = ConfigException.class)
    public void testLoadUnknownProperty() throws Exception {
        ConfigFactory.load("app").getString("debug");
    }

    @Test
    public void testFallbackToDefaultConfig() throws Exception {
        Config configDefault = ConfigFactory.load("app");
        Config configDev = ConfigFactory.load("app.dev");

        Config merged = configDev.withFallback(configDefault);

        assertThat(merged.getInt("port.client")).isEqualTo(8080);
        assertThat(merged.getInt("port.api")).isEqualTo(8079);
        assertThat(merged.getString("scheme")).isEqualTo("http");
        assertThat(merged.getString("hostname")).isEqualTo("app.dabogee.com");
        assertThat(merged.getBoolean("debug")).isTrue();
    }

    @Test
    public void testMapToObject() throws Exception {
        Config configDefault = ConfigFactory.load("app");
        AppConfig appConfig = ConfigBeanFactory.create(configDefault, AppConfig.class);

        assertThat(appConfig.getPort().getClient()).isEqualTo(80);
        assertThat(appConfig.getPort().getApi()).isEqualTo(8079);
        assertThat(appConfig.getScheme()).isEqualTo("https");
        assertThat(appConfig.getHostname()).isEqualTo("app.dabogee.com");
    }
}
