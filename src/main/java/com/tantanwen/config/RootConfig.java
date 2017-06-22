package com.tantanwen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by dan on 2017/6/22.
 */
@Configuration
@ComponentScan(basePackages = {"com.tantanwen"},excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
})

public class RootConfig {
}
