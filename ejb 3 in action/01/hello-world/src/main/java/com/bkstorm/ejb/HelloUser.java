package com.bkstorm.ejb;

import javax.ejb.Local;

/**
 * Created by Nguyen on 11/28/2015.
 */
@Local
public interface HelloUser {

    String sayHello(String name);
}
