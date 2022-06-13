package org.example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebMvcInitializer implements WebApplicationInitializer {

    private String TMP_FOLDER = "c:\\Windows\\Temp";
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebMvcConfig.class);

        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);

        servletRegistration.setMultipartConfig(multipartConfigElement);
    }
}
