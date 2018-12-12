package com.example.spring5ldap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Spring5ldapApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5ldapApplication.class, args);
		log.info("testing logging with lombok");
	}

}

