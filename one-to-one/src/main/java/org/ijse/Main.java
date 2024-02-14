package org.ijse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ijse.config.FactoryConfiguration;
import org.ijse.entity.Laptop;
import org.ijse.entity.Student;

public class Main {
    public static void main(String[] args) {
        Session session  =  FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setModel("Dell");
        Student student = new Student();
        student.setId(1);
        student.setName("Samii");
        student.setAddress("Panadura");
        student.setLaptop(laptop);

        session.save(laptop);
        session.save(student);

        transaction.commit();
        session.close();
    }
}