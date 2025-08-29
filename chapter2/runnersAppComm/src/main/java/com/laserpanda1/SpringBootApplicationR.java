package com.laserpanda1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;


//1-й способ с реализаей интерфейса
//2-й способ с внедрением бина (@Bean)
@SpringBootApplication
public class SpringBootApplicationR implements CommandLineRunner {

    protected final Logger log =
            LoggerFactory.getLogger(SpringBootApplicationR.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationR.class, args);
    }

    /* Это способ с бином
    @Bean
    public CommandLineRunner lineRunner() {
        return args -> {
          logger.info("CommandLineRunner executed as a bean definition with
                "+args.length+" arguments");
                for(int i=0; i<args.length;i++){
                logger.info("Argument: "+args[i]);
        };
    }*/

    @Override
    public void run(String...args) throws Exception {
        log.info("Start SpringBootApplicationR");
    }
}