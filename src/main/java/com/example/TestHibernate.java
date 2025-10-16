package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfig;
import entities.Product;

public class TestHibernate {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Product p = new Product();
        p.setName("Clavier mécanique");
        p.setPrice(450.0);
        session.save(p);
        tx.commit();

        session.close();
        context.close();
        System.out.println("✅ Produit enregistré avec succès !");
    }
}
