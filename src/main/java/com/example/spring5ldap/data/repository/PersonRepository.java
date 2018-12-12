package com.example.spring5ldap.data.repository;

import com.example.spring5ldap.data.model.Person;
import org.springframework.data.repository.CrudRepository;

import javax.naming.Name;
import java.util.List;

public interface PersonRepository {//extends CrudRepository<Person, Name> {

    // additional custom finder methods go here

    /**
     * Find by UserId.
     *
     * @param uid
     * @return
     */
    List<Person> findByUid(String uid);

    /**
     * Prefix search on {@link Person#getLastname()}.
     *
     * @param prefix
     * @return
     */
    List<Person> findByLastnameStartsWith(String prefix);
}