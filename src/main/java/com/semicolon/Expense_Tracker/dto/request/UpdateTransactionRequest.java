package com.semicolon.Expense_Tracker.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class UpdateTransactionRequest {
    private Long userId;
    private Long categoryId;
    private Long TransactionId;
    private String description;
    private Double amount;
    private LocalTime time;


}
