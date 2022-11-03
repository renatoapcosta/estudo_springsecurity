package br.com.ractecnologia.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Properties;

@Service
public class MeuBean {

    @Value("${meu.nome}")
    private String meuNome;

    @Value("${tag.two}")
    private String tagTwo;

    @Value("${spring.profiles.active:default}")
    private String profile;

    @Autowired
    private PropertySourcesPlaceholderConfigurer localProperties;


    public MeuBean() {
        System.out.println(getClass().getSimpleName() + " instaciado ----------------------------");
    }

    @PostConstruct
    public void postCOnstructor() {
        System.out.println("Post constructor ");
        System.out.println("meu.nome: "+ meuNome);
        System.out.println("tag.two: "+ tagTwo);
        System.out.println("spring.profiles.active: "+ profile);
        System.out.println(Objects.requireNonNull(localProperties.getAppliedPropertySources().get("localProperties")).getProperty("meu.nome"));

    }

}
