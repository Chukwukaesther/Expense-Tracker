package com.semicolon.Expense_Tracker.service;

import com.semicolon.Expense_Tracker.Exception.UserNotFoundException;
import com.semicolon.Expense_Tracker.data.model.Category;
import com.semicolon.Expense_Tracker.data.model.Transaction;
import com.semicolon.Expense_Tracker.data.model.User;
import com.semicolon.Expense_Tracker.data.repository.TransactionRepository;
import com.semicolon.Expense_Tracker.dto.request.*;
import com.semicolon.Expense_Tracker.dto.response.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final UserService userService;
    private final CategoryService categoryService;
    private final TransactionRepository transactionRepository;

    @Override
    public List<CreateTransactionResponse> createTraction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        Category category =  categoryService.findById(request.getUserId());
        transaction.setCategory(category);
        User user = userService.findById(request.getUserId());
        transaction.setUser(user);
        transaction.setDate(LocalDateTime.now());
        transaction.setAmount(request.getAmount());
        transaction.setDescription(request.getDescription());

        Transaction savedTransaction = transactionRepository.save(transaction);

        CreateTransactionResponse response = new CreateTransactionResponse();
        response.setId(savedTransaction.getId());
        response.setDescription(savedTransaction.getDescription());
        response.setDate(savedTransaction.getDate());
        response.setUserId(savedTransaction.getUser().getId());
        response.setCategory(savedTransaction.getCategory().getName());
        response.setMessage("Transaction created successfully");
        return List.of(response);

    }


    @Override
    public List<UpdateTransactionResponse> updateTransaction(UpdateTransactionRequest request) {
        Optional<Transaction> transaction = transactionRepository.getTransactionById(request.getTransactionId());
        if(transaction.isPresent()){
            Transaction updatedTransaction = transaction.get();
            updatedTransaction.setDate(LocalDateTime.now());
            updatedTransaction.setAmount(request.getAmount());
            updatedTransaction.setDescription(request.getDescription());

            Transaction savedTransaction = transactionRepository.save(updatedTransaction);

            UpdateTransactionResponse response = new UpdateTransactionResponse();
            response.setId(savedTransaction.getId());
            response.setDescription(savedTransaction.getDescription());
            response.setDate(savedTransaction.getDate());
            response.setUserId(savedTransaction.getUser().getId());
            response.setCategory(savedTransaction.getCategory().getName());
            response.setMessage("Transaction created successfully");
            return List.of(response);

        }

        return List.of();
    }

    @Override
    public GetAllTransactionResponse allTransactions(GetAllTransactionRequest request) {
        User user = userService.findById(request.getUserId());
        if(user == null){
            throw new UserNotFoundException("User not found");
        }
        List<Transaction> transactions = transactionRepository.findByUser(user);
        GetAllTransactionResponse response = new GetAllTransactionResponse();
        response.setTransaction(transactions);
        response.setMessage("All transactions fetched successfully");


        return null;
    }

    @Override
    public DeleteTransactionResponse deleteTransaction(DeleteTransactionRequest request) {
        Optional<Transaction> transaction = transactionRepository.getTransactionById(request.getTransactionId());
        if(transaction.isPresent()) {
            transactionRepository.deleteById(request.getTransactionId());
        }
        DeleteTransactionResponse response = new DeleteTransactionResponse();
        response.setMessage("Transaction deleted successfully");
        return response;


    }
}
