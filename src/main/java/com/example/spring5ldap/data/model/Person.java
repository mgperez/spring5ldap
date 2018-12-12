package com.example.spring5ldap.data.model;

import lombok.Data;
import org.springframework.ldap.odm.annotations.*;

import javax.naming.Name;

/**
 * https://github.com/spring-projects/spring-data-examples/blob/master/ldap/example/src/main/java/example/springdata/ldap/Person.java
 */
//@Entry(base = "ou=people,dc=springframework,dc=org", objectClasses = "inetOrgPerson")
//@Entry(objectClasses = { "person", "top" }, base="ou=someOu")
//@Data
public class Person {

    @Id
    private Name dn;

    @Attribute(name="cn")
    @DnAttribute(value="cn", index=1)
    private String fullName;

    private @Attribute(name = "sn") String lastname;

    @Attribute(name="firstName")
    private String firstName;

    // No @Attribute annotation means this is bound to the LDAP attribute
    // with the same value
//    private String firstName;

    @DnAttribute(value="ou", index=0)
    @Transient
    private String company;

    @Transient
    private String someUnmappedField;
    // ...more attributes below

/*
    private @Id Name id;
    private @DnAttribute(value = "uid", index = 3) String uid;
    private @Attribute(name = "cn") String fullName;
    private @Attribute(name = "sn") String lastname;
    private String userPassword;
*/
}