/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.singleton.bean;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 *
 * @author Nguyen
 */
@Singleton
public class HitCounter {

    int count;

    public void increment() {
        ++count;
    }

    @Lock(LockType.READ)
    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }
}
