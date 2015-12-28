package com.bkstorm.spring.knights.config;

import com.bkstorm.spring.knights.BraveKnight;
import com.bkstorm.spring.knights.Knight;
import com.bkstorm.spring.knights.Quest;
import com.bkstorm.spring.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }
  
  @Bean
  public Quest quest() {
    return new SlayDragonQuest(System.out);
  }

}
