package com.semicolon.Expense_Tracker.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCategoryRequest {
    private Long id;
    private Long categoryId;
}
