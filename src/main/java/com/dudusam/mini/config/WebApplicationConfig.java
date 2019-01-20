package com.dudusam.mini.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
@ComponentScan(
        basePackages = "com.dudusam",
        excludeFilters = @ComponentScan.Filter(Configuration.class))
public class WebApplicationConfig implements WebMvcConfigurer {

    @Bean
    public PropertyPlaceholderConfigurer confFileInfo(){
        PropertyPlaceholderConfigurer conf = new ConfigFile();
        String path = System.getenv("MINI_HOME");
        if(path != null){
            conf.setLocation( new FileSystemResource( System.getenv("MINI_HOME") + File.separator + "mini.config.properties" ) );
        }

        return conf;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(0);
        registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(0);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(0);

        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/swagger/").setCachePeriod(0);
        registry.addResourceHandler("/swagger/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new MiniInterceptor());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dudusam.mini.controllers"))
                .paths(PathSelectors.ant("/dudusam/api/**"))
                //.paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        StringBuilder baseUrl = new StringBuilder();
        //baseUrl.append("/flyingdust").append("/v2").append("/api-docs");
        return new ApiInfo(
                "DuDuSam REST API",
                "DuDuSam REST API Documentation",
                "0.5",
                "",
                new Contact("DuDuSam Manager", "", "KANG-TAEK@samsung.com"),
                "",
                "",
                new ArrayList<>());
    }

}

