/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author hoangnv
 */
@Configuration
@Import({CDConfig.class, CDPlayerConfig.class})
@ImportResource("classpath:cd-config.xml")
@ComponentScan
public class SoundSystemConfig {

}
