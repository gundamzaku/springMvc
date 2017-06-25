package com.tantanwen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by dan on 2017/6/22.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.tantanwen.web")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        //查找JSP文件
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
    /*
    @Bean
    public void RequestMappingHandlerMapping (){

    }

    @Bean
    public void RequestMappingHandlerAdapter (){

    }*/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){

        configurer.enable();
    }
}
