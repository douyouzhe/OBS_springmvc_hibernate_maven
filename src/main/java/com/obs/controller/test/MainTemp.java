package com.obs.controller.test;

import com.obs.Entities.Book;
import com.obs.Entities.User;
import utils.WebUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class MainTemp {

    public static void main(String[] args) {
        User admin = new User();
        admin.setId("1");
        admin.setUsername("1");

        //Book bk = new Book();
        //bk.setId("1");

        SessionFactory sessionFactory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(admin);
        //session.save(bk);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
