package com.semicolon.Expense_Tracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccessful;
    private Object data;
}
