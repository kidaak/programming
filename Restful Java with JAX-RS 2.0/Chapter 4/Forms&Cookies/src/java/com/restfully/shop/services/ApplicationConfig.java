/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.services;

import com.restfully.shop.CustomerResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author hoangnv
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    private final Set<Object> singletons = new HashSet<>();
    private final Set<Class<?>> empty = new HashSet<>();

    public ApplicationConfig() {
        singletons.add(new CustomerResource());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
