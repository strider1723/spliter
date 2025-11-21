package com.yourname.billsplitter.demo.Services;

import com.yourname.billsplitter.demo.entity.Expense;
import java.util.List;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    List<Expense> getAllExpenses();

    List<Expense> getExpensesByCategory(String category);

    List<Expense> getSortedExpenses(String sortBy);

    Expense updateAmount(Long id, Double amount);

    void softDeleteExpense(Long id);

    Double getTotalSpentByPerson(Long personId);
}
