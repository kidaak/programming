package org.bkstorm.jpa.bean;

import javax.ejb.Stateless;

@Stateless
public class AuditServiceBean implements AuditService {

    @Override
    public void audit() {
        System.out.println("Audit performed.");
    }
}
