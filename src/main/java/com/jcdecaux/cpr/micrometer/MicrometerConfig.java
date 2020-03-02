package com.jcdecaux.cpr.micrometer;

import com.jcdecaux.cpr.micrometer.config.CustomMetricsConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan
@Configuration
@Import(CustomMetricsConfig.class)
public class MicrometerConfig {
}
