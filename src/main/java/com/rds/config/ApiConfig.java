package com.rds.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vladk on 19.06.2017.
 */

@Configuration
@ComponentScan(basePackages = {"com.rds"})
@EnableAutoConfiguration
public class ApiConfig {
}
