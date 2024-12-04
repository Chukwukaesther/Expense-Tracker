package com.semicolon.Expense_Tracker.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllTransactionRequest {
    private Long TransactionId;
    private Long UserId;
}
