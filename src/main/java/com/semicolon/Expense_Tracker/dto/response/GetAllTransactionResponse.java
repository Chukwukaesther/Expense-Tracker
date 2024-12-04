package com.semicolon.Expense_Tracker.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAllTransactionResponse {
    private List transactions;
    private String message;
}
