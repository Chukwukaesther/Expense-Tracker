package com.semicolon.Expense_Tracker.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
public class CreateTransactionResponse {
    private Long id;
    private String description;
    private double amount;
    private LocalDateTime date;
    private Long userId;
    private String category;
    private String message;
}
