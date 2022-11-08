package br.com.ractecnologia.filter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class BeforeAuthenticationProcessingFilter extends GenericFilterBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public BeforeAuthenticationProcessingFilter() {
        System.out.println(getClass().getSimpleName() + "created");
    }

    @Override
    protected void initFilterBean() throws ServletException {
        System.out.println("initFIlterBean");
        super.initFilterBean();
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.getAttributeNames();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext "+ applicationContext);
        this.applicationContext = applicationContext;
    }
}
