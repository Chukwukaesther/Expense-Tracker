package com.semicolon.Expense_Tracker.data.repository;

import com.semicolon.Expense_Tracker.data.model.Transaction;
import com.semicolon.Expense_Tracker.data.model.User;
import com.semicolon.Expense_Tracker.dto.request.GetAllTransactionRequest;
import com.semicolon.Expense_Tracker.dto.response.GetAllTransactionResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
//     GetAllTransactionResponse getAllTransactions (Long id);
    List<Transaction> findByUser(User user);

    Optional<Transaction> getTransactionById (Long Id);

}
