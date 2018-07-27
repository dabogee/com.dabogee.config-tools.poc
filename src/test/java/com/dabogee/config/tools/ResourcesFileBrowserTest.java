package com.dabogee.config.tools;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class ResourcesFileBrowserTest {

    @Test
    public void testReadConfigurations() throws Exception {
        assertThat(new ResourcesFileBrowser().getConfigurations()).hasSize(6);
    }
}
