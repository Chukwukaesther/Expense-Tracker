package com.semicolon.Expense_Tracker.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayStackRequest {
    private String email;
    private String amount;
}
