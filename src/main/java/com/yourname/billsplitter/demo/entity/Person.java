package com.yourname.billsplitter.demo.entity;

import jakarta.persistence.*;



import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Expense> expenses;

    private double totalSpent;


}
