package br.com.ractecnologia.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MeuBean {

    @Value("${meu.nome}")
    private String meuNome;

    @Value("${tag.two}")
    private String tagTwo;

    @Value("${spring.profiles.active:default}")
    private String profile;



    public MeuBean() {
        System.out.println(getClass().getSimpleName() + " instaciado ----------------------------");
    }

    @PostConstruct
    public void postCOnstructor() {
        System.out.println("Post constructor ");
        System.out.println("meu.nome: "+ meuNome);
        System.out.println("tag.two: "+ tagTwo);
        System.out.println("spring.profiles.active: "+ profile);

    }
}
