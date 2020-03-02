package com.jcdecaux.cpr.micrometer.config;

import com.jcdecaux.cpr.micrometer.tags.CustomTags;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class CustomMetricsConfig {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> meterRegistryCustomizer() {
        return registry -> {
            try {
                registry.config()
                        .commonTags(CustomTags.HOSTNAME, InetAddress.getLocalHost().getHostName());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        };
    }
}