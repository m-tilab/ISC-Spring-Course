package org.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {

        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);

        return urlBasedViewResolver;

    }

    @Bean
    public DataSource dataSource() {

        var jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        //return jndiDataSourceLookup.getDataSource("java:comp/env/" + "jdbc/springDB");
        return jndiDataSourceLookup.getDataSource("jdbc/springDB");
    }
}
