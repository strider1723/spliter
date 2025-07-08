package com.yourname.billsplitter.demo.repository;


import com.yourname.billsplitter.demo.entity.Expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {}
