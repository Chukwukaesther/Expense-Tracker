package com.semicolon.Expense_Tracker.dto.response;

import com.semicolon.Expense_Tracker.data.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAllTransactionResponse {
    private List<Transaction> transaction;
    private String message;
}
