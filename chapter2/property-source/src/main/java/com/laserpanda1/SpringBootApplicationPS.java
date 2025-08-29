package com.laserpanda1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringBootApplicationPS {

    private static Logger log = LoggerFactory.getLogger(SpringBootApplicationPS.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(SpringBootApplicationPS.class, args);

        AppService appService =
                applicationContext.getBean(AppService.class);

        log.info(appService.getAppProperties().toString());

    }
}


/*@SpringBootApplication
public class SpringBootApplicationPS {

    private static final Logger log =
            LoggerFactory.getLogger(SpringBootApplicationPS.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(SpringBootApplicationPS.class, args);
        DbConfiguration dbConfiguration = applicationContext.getBean(DbConfiguration.class);
            log.info(dbConfiguration.toString());
    }
}*/