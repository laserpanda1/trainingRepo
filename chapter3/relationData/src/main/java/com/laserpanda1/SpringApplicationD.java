package com.laserpanda1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringApplicationD {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationD.class, args);
    }
}