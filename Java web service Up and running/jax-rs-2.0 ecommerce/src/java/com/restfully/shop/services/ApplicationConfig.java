/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author hoangnv
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {
    
//    private final Set<Object> singletons = new HashSet();
    
//    public ApplicationConfig(){
//        singletons.add(new CustomerResource());
//    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }


//    @Override
//    public Set<Object> getSingletons() {
//        return singletons;
//    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.restfully.shop.services.CustomerResource.class);
    }

}
