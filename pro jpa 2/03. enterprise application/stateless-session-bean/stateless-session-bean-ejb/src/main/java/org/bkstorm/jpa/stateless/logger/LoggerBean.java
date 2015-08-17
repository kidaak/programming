/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.stateless.logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author Nguyen
 */
@Stateless
public class LoggerBean implements Logger {

    private java.util.logging.Logger logger;

    @PostConstruct
    public void init() {
        logger = java.util.logging.Logger.getLogger("notification");
    }

    @Override
    public void logMessage(String message) {
        logger.info(message);
    }

}
