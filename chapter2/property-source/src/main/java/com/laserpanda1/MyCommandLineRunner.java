package com.laserpanda1;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) //с помощью аннотации, можно указать порядок загрузки , если несколько реализаций CommandLineRunner
@Component
public class MyCommandLineRunner {
}
