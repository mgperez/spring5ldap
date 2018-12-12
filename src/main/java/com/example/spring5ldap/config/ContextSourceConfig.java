package com.example.spring5ldap.config;


import com.example.spring5ldap.client.LdapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

/**
 * https://docs.spring.io/spring-data/ldap/docs/2.1.3.RELEASE/reference/html/#ldap.repositories
 * https://github.com/eugenp/tutorials/blob/master/spring-ldap/src/main/java/com/baeldung/ldap/javaconfig/AppConfig.java
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableLdapRepositories
public class ContextSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    ContextSource contextSource() {
        LdapContextSource contextSource  = new LdapContextSource();
        contextSource .setUrl(env.getRequiredProperty("ldap.url"));
        contextSource.setBase(env.getRequiredProperty("ldap.partitionSuffix"));
        contextSource.setUserDn(env.getRequiredProperty("ldap.principal"));
        contextSource.setPassword(env.getRequiredProperty("ldap.password"));
        return contextSource ;
    }

    @Bean
    LdapTemplate ldapTemplate(ContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }

    @Bean
    public LdapClient ldapClient() {
        return new LdapClient();
    }
}
