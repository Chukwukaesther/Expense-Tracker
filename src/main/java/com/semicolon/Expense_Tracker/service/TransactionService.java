package com.semicolon.Expense_Tracker.service;

import com.semicolon.Expense_Tracker.dto.request.*;
import com.semicolon.Expense_Tracker.dto.response.*;
import java.util.List;

public interface TransactionService {

    List<CreateTransactionResponse> createTraction(CreateTransactionRequest request);

    List<UpdateTransactionResponse> updateTransaction(UpdateTransactionRequest request);
//    GetTransactionByIdResponse transactionById(GetTransactionByIdRequest request);
    GetAllTransactionResponse allTransactions(GetAllTransactionRequest request);
    DeleteTransactionResponse deleteTransaction(DeleteTransactionRequest request);

}
