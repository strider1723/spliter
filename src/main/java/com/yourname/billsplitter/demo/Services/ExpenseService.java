package com.yourname.billsplitter.demo.Services;


import com.yourname.billsplitter.demo.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense addExpense(Expense expense);
    List<Expense> getAllExpenses();
}
