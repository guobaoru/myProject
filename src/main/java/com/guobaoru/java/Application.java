package com.guobaoru.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext(Application.class);

        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:application.xml");

        annoContext.getBean("");
        Map map = new HashMap<>();
        annoContext.register(Application.class);
    }
}