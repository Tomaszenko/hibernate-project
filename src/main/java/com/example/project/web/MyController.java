package com.example.project.web;

import com.example.project.schema.MyThing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by tomxon on 30.08.17.
 */

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    private Session session;

//    @PersistenceContext
//    private EntityManager entityManager;

    public MyController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Transactional
    @RequestMapping("/get")
    public MyThing getThing() {
//        entityManager.createQuery("")
        MyThing myThing = new MyThing();
        myThing.setName("henio");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(myThing);
        session.getTransaction().commit();
        session.close();
        return myThing;
    }
}
