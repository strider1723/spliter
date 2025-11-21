package com.yourname.billsplitter.demo.service.impl;

import com.yourname.billsplitter.demo.Services.ExpenseService;
import com.yourname.billsplitter.demo.entity.Expense;
import com.yourname.billsplitter.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findByIsDeletedFalse();
    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategoryAndIsDeletedFalse(category);
    }

    @Override
    public List<Expense> getSortedExpenses(String sortBy) {
        if (sortBy.equalsIgnoreCase("amount")) {
            return expenseRepository.findAll(Sort.by("amount").ascending());
        }
        return expenseRepository.findAll(Sort.by("expenseDate").descending());
    }

    @Override
    public Expense updateAmount(Long id, Double amount) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setAmount(amount);
        return expenseRepository.save(expense);
    }

    @Override
    public void softDeleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setDeleted(true);
        expenseRepository.save(expense);
    }

    @Override
    public Double getTotalSpentByPerson(Long personId) {
        return expenseRepository.getTotalSpentByPerson(personId);
    }
}
