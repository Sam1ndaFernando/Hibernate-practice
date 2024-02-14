package org.ijse.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ijse.entity.Laptop;
import org.ijse.entity.Student;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getFactoryConfiguration(){
        return factoryConfiguration==null ? factoryConfiguration=new FactoryConfiguration() : factoryConfiguration;

    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
