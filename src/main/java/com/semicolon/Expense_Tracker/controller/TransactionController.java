package com.semicolon.Expense_Tracker.controller;

import com.semicolon.Expense_Tracker.Exception.ExpenseTrackerException;
import com.semicolon.Expense_Tracker.dto.request.CreateTransactionRequest;
import com.semicolon.Expense_Tracker.dto.request.DeleteTransactionRequest;
import com.semicolon.Expense_Tracker.dto.request.GetAllTransactionRequest;
import com.semicolon.Expense_Tracker.dto.request.UpdateTransactionRequest;
import com.semicolon.Expense_Tracker.dto.response.*;
import com.semicolon.Expense_Tracker.service.TransactionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Transaction")
public class TransactionController {

    private final TransactionServiceImpl transactionService;

    @PostMapping("/createTransaction")
    public ResponseEntity<?> createTransaction(@RequestBody CreateTransactionRequest transactionRequest){
        try{
            CreateTransactionResponse result = (CreateTransactionResponse) transactionService.createTraction(transactionRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("/updateTransaction")
    public ResponseEntity<?> updateTransaction(@RequestBody UpdateTransactionRequest updateTransactionRequest){
        try{
            UpdateTransactionResponse result = (UpdateTransactionResponse) transactionService.updateTransaction(updateTransactionRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("/getAllTransaction")
    public ResponseEntity<?> getAllTransactionTransaction(@RequestBody GetAllTransactionRequest getAlltransactionRequest){
        try{
            GetAllTransactionResponse result = transactionService.allTransactions(getAlltransactionRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("/deleteTransaction")
    public ResponseEntity<?> deleteTransaction(@RequestBody DeleteTransactionRequest deleteTransactionRequest){
        try{
            DeleteTransactionResponse result = transactionService.deleteTransaction(deleteTransactionRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

}
