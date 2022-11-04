package br.com.ractecnologia.servlet;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


public class MeuServlet extends HttpServlet {

    static {

        final WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

        if (context != null) {
            PropertySourcesPlaceholderConfigurer props = context.getBean("props", PropertySourcesPlaceholderConfigurer.class);
            PropertySource<?> localProperties = props.getAppliedPropertySources().get("localProperties");
            final Properties properties;
            if (Objects.isNull(localProperties)) {
                properties = new Properties();
            } else {
                properties = (Properties) localProperties.getSource();
            }

            System.out.println(properties.getProperty("tag.two"));
        }

    }

    public MeuServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("doGet------------------------------------------------");
        response.sendRedirect("page1.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("doPost------------------------------------------------");
        response.sendRedirect("page1.jsp");
    }
}