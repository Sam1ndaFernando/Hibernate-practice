package org.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private int id;
    private String  name;
    private String address;

    @OneToMany(mappedBy = "student")
    private List<Laptop> laptops;
}
