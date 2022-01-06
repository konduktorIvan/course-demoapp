package com.course.coursedemoapp;

import model.CompanyEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateQueryTrain {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration()
                    .addPackage("model")
                    .configure().
                    addAnnotatedClass(CompanyEntity.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        CompanyEntity testEntity = new CompanyEntity(
                "A",
                "XNYS",
                "",
                "kNacgtncxneEY ocS Iwkeo rh ",
                "YNSX",
                "exEta g YN eIok cnnorcSwkch",
                "tehgnTileI.l Ac oscngeoin",
                LocalDate.now(),
                "cs",
                "IEX_46574843354B2D52",
                "US",
                "USD",
                true,
                "2W7RGIM8XPWUQX0729YA", "DV23G06CBB00",
                "1142938"
        );

        addCompany(testEntity);

    }
    public static void addCompany(CompanyEntity companyEntity){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(companyEntity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
