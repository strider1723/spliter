package com.yourname.billsplitter.demo.controller;

import com.yourname.billsplitter.demo.Services.ExpenseService;
import com.yourname.billsplitter.demo.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses(
            @RequestParam(required = false) String category,
            @RequestParam(required = false, defaultValue = "date") String sort) {

        if (category != null) {
            return expenseService.getExpensesByCategory(category);
        }
        return expenseService.getSortedExpenses(sort);
    }

    @PatchMapping("/{id}/amount")
    public Expense updateAmount(@PathVariable Long id, @RequestBody Double amount) {
        return expenseService.updateAmount(id, amount);
    }

    @DeleteMapping("/{id}")
    public String softDelete(@PathVariable Long id) {
        expenseService.softDeleteExpense(id);
        return "Expense deleted successfully (soft delete)";
    }

    @GetMapping("/person/{personId}/total")
    public Double getTotalSpentByPerson(@PathVariable Long personId) {
        return expenseService.getTotalSpentByPerson(personId);
    }
}
