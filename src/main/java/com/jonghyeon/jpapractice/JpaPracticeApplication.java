package com.jonghyeon.jpapractice;

import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class JpaPracticeApplication {


    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
    }

}
