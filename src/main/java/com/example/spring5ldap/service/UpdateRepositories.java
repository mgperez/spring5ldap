package com.example.spring5ldap.service;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * https://stackoverflow.com/questions/45319900/multiple-ldap-repositories-with-spring-ldap-repository
 * https://www.javapedia.net/Spring-Beans/1938
 * https://www.programcreek.com/java-api-examples/index.php?source_dir=spring-ldap-master/core/src/main/java/org/springframework/ldap/core/support/BaseLdapPathBeanPostProcessor.java
 */
@Service
public class UpdateRepositories {
//    public void updateAllRepositories(LdapUserRepository userRepository1, LdapUserRepository userRepository2) {
//        // apply updates to userRepository1 and userRepository2
//    }

    public void updateAllRepositories(ApplicationContext appContext) {
        // iterate through map and apply updates

        Map<String, Repository> beansList = appContext.getBeansOfType(Repository.class);
        for (String key : beansList.keySet()) {
            System.out.println(key + " = " + beansList.get(key));
        }

//        Map<String, LdapRepository> ldapRepositories = appContext.getBeansofType(LdapRepository.class);
        Collection<LdapRepository> beans = appContext.getBeansOfType(LdapRepository.class).values();
        if (beans.isEmpty()) {
            throw new NoSuchBeanDefinitionException("No BaseLdapPathSource implementation definition found");
        }

        // Try to find the correct one
        for (LdapRepository bean : beans) {

        }




    }
}