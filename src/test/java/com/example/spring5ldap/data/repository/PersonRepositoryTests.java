package com.example.spring5ldap.data.repository;

import com.example.spring5ldap.data.model.Person;

import static org.assertj.core.api.Assertions.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;

import java.util.Optional;

/**
 * https://github.com/spring-projects/spring-data-examples/blob/master/ldap/example/src/test/java/example/springdata/ldap/PersonRepositoryIntegrationTests.java
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

    @Autowired
    PersonRepository personRepository;


    /**
     * Find a {@link Person} by its Id that is a full DN.
     *
     * @throws InvalidNameException
     */
    @Test
    public void findOneByName() throws InvalidNameException {

        Optional<Person> person = personRepository.findById(new LdapName("uid=bob,ou=people,dc=springframework,dc=org"));

//        assertThat(person).hasValueSatisfying(it -> {
//            assertThat(it.getFullName()).isEqualTo("Bob Hamilton");
//            assertThat(it.getLastname()).isEqualTo("Hamilton");
//            assertThat(it.getUid()).isEqualTo("bob");
//        });
    }

    /**
     * Find all entries in the base path.
     */
    @Test
    public void findAll() {

        Iterable<Person> people = personRepository.findAll();

        assertThat(people).hasSize(3).extracting("uid").contains("bob", "joe", "ben");
    }

}
