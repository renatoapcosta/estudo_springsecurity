package br.com.ractecnologia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
public class PropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer props(Environment env ) {
        final PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        final List<Resource> resources = Arrays.stream(env.getActiveProfiles()).map(c -> new PathMatchingResourcePatternResolver()
                        .getResource(String.format("classpath:application-%s.properties", c)))
                .filter(Resource::exists).collect(Collectors.toList());

        if(resources.isEmpty()) {
            final Resource application = new PathMatchingResourcePatternResolver().getResource("classpath:application-prd.properties");
            if(application.exists()) {
                resources.add(application);
                settingProfileDefault(propertyConfigurer);
            }
        }

        final Resource application = new PathMatchingResourcePatternResolver().getResource("classpath:application.properties");
        if(application.exists()) {
            resources.add(0, application);
        }

        propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
        propertyConfigurer.setLocations( resources.toArray(new Resource[0]) );

        return propertyConfigurer;
    }

    private static void settingProfileDefault(PropertySourcesPlaceholderConfigurer propertyConfigurer) {
        final Properties propertyDefault = new Properties();
        propertyDefault.setProperty("spring.profiles.active", "prd");
        propertyConfigurer.setProperties(propertyDefault);
    }
}
