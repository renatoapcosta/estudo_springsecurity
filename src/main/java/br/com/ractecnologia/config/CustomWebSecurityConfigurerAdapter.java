package br.com.ractecnologia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class CustomWebSecurityConfigurerAdapter extends
        WebSecurityConfigurerAdapter {

    public CustomWebSecurityConfigurerAdapter() {
        System.out.println(getClass().getSimpleName() + " instaciado ----------------------------");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")  // #1
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin") // #2
                .password("admin")
                .roles("ADMIN", "USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login.jsp").permitAll()
                .antMatchers("/index.jsp").permitAll()
                .antMatchers("/page1.jsp", "/servlet.do").permitAll()
                .antMatchers("/home.jsp").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin.jsp").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.jsp")
                .defaultSuccessUrl("/home.jsp")
                .failureUrl("/login.jsp?error=1")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403.jsp")
                .and()
                .logout()
                .logoutUrl("/j_spring_security_logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login.jsp")
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .and();
    }


}
