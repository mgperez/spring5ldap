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

import java.util.Collections;

/**
 * https://docs.spring.io/spring-data/ldap/docs/2.1.3.RELEASE/reference/html/#ldap.repositories
 * https://github.com/eugenp/tutorials/blob/master/spring-ldap/src/main/java/com/baeldung/ldap/javaconfig/AppConfig.java
 *
 * multiple-ldap-repositories
 * https://stackoverflow.com/questions/45319900/multiple-ldap-repositories-with-spring-ldap-repository
 *
 * https://memorynotfound.com/spring-boot-spring-ldap-advanced-ldap-queries-example/
 * https://www.youtube.com/watch?v=6VaoicPysNc
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableLdapRepositories
public class ContextSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    ContextSource contextSource() {
//        LdapContextSourceCustom ldapContextSource = new LdapContextSourceCustom();
        LdapContextSource contextSource  = new LdapContextSource();
        contextSource .setUrl(env.getRequiredProperty("ldap.url"));
        contextSource.setBase(env.getRequiredProperty("ldap.partitionSuffix"));
        contextSource.setUserDn(env.getRequiredProperty("ldap.principal"));
        contextSource.setPassword(env.getRequiredProperty("ldap.password"));
//        contextSource.setBaseEnvironmentProperties(Collections.<String,Object>unmodifiableMap(this.properties.getBaseEnvironment()));
//        contextSource.setKeyStoreFile(env.getProperty("ldap.truststore"));
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
