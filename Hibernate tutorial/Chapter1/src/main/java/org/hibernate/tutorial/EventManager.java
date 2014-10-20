/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hibernate.tutorial;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

/**
 *
 * @author hoangnv
 */
public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());
        } else if (args[0].equals("list")) {
            List events = mgr.listEvents();
            for (Object event : events) {
                Event theEvent = (Event) event;
                System.out.println("Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate());
            }
        }
        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }

    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    private void addPersonToEvent(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.createQuery("SELECT p FROM Person p LEFT JOIN FETCH p.events  WHERE p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult(); // Eager fetch the collection so we can use it detached
        Event anEvent = (Event) session.load(Event.class, eventId);

        session.getTransaction().commit();
        // End of first unit of work

        aPerson.getEvents().add(anEvent); // aPerson (and its collection) is detached

        //Begin second unit of work
        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        session2.beginTransaction();
        session2.update(aPerson); //Reattachment of aPerson

        session2.getTransaction().commit();
    }
    
    private void addEmailToPerson(Long personId, String emailAddress){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Person aPerson = (Person)session.load(Person.class, personId);
        // adding to the emailAddress collection might trigger a lazy load of the collection
        aPerson.getEmailAddresses().add(emailAddress);
        
        session.getTransaction().commit();
    }
}
