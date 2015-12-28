package com.bkstorm.spring.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

    public static void main(String[] args) throws Exception {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "META-INF/spring/minstrel.xml")) {
            Knight knight = context.getBean(Knight.class);
            knight.embarkOnQuest();
        }
    }

}
