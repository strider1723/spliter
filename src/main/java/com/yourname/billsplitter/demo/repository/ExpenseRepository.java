package com.yourname.billsplitter.demo.repository;

import com.yourname.billsplitter.demo.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByIsDeletedFalse(); 

    List<Expense> findByCategoryAndIsDeletedFalse(String category);

    List<Expense> findByPersonIdAndIsDeletedFalse(Long personId);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.person.id = :personId AND e.isDeleted = false")
    Double getTotalSpentByPerson(Long personId);

    @Query("SELECT e FROM Expense e WHERE e.item LIKE %:keyword% AND e.isDeleted = false")
    List<Expense> searchByItem(String keyword);
}
