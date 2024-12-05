package com.semicolon.Expense_Tracker.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Setter
@Getter
public class CreateTransactionRequest {
    private Long userId;
    private Long Category;
    private String description;
    private Double amount;
    private LocalTime time;

}
