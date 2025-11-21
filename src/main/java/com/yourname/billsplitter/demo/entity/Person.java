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

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
    public double getTotalSpent() {
        return totalSpent;
    }
    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }
}
