package br.com.ractecnologia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class HttpFirewallConfig {

    @Bean
    public HttpFirewall getHttpFirewall() {
        StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
        strictHttpFirewall.setAllowSemicolon(true);
        strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
        strictHttpFirewall.setAllowUrlEncodedSlash(true);
        strictHttpFirewall.setAllowBackSlash(true);
        return strictHttpFirewall;
    }
}
