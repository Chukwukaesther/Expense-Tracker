package com.semicolon.Expense_Tracker.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayStackResponse {
    private boolean status;
    private String message;
    private ResponseData data;
}
