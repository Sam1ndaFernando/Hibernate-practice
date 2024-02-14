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
        List<Student> students = new ArrayList<>();

        Student student = new Student();
        student.setId(1);
        student.setName("Amodh");
        student.setAddress("Kaluthara");
        student.setLaptops(laptops);

        Student student1 = new Student();
        student1.setId(2);
        student1.setName("eranga");
        student1.setAddress("Beruwala");
        student1.setLaptops(laptops);

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setModel("ACER");
        laptop.setStudents(students);

        Laptop laptop1 = new Laptop();
        laptop1.setLid(2);
        laptop1.setModel("DELL");
        laptop1.setStudents(students);

        laptops.add(laptop);
        laptops.add(laptop1);
        students.add(student);
        students.add(student1);

        session.save(student);
        session.save(student1);
        session.save(laptop);
        session.save(laptop1);


        transaction.commit();
        session.close();
    }
}