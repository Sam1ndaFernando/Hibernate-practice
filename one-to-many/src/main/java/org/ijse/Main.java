package org.ijse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ijse.config.FactoryConfiguration;
import org.ijse.entity.Laptop;
import org.ijse.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        //code
        List<Laptop> laptops = new ArrayList<>();

        Student student = new Student();
        student.setId(1);
        student.setName("AMODH");
        student.setAddress("Kaluthara");

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setModel("ACER");
        laptops.add(laptop);

        Laptop laptop1  = new Laptop();
        laptop1.setLid(2);
        laptop1.setModel("DELL");
        laptops.add(laptop1);

        student.setLaptops(laptops);
        laptop.setStudent(student);
        laptop1.setStudent(student);

        session.save(student);
        session.save(laptop);
        session.save(laptop1);

        transaction.commit();
        session.close();
    }
}