package com.example.spring5ldap.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.ldap.odm.annotations.*;

import javax.naming.Name;

/**
 * https://www.baeldung.com/spring-data-ldap
 */
@Getter
@Setter
@Entry(
        base = "ou=users",
        objectClasses = { "person", "inetOrgPerson", "top" })
public class User {
    @Id
    private Name id;

    private @Attribute(name = "cn") String username;
    private @Attribute(name = "sn") String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // standard getters/setters

    @Override
    public String toString() {
        return username;
    }
}