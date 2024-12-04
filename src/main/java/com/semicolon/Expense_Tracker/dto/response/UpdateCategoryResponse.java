package com.semicolon.Expense_Tracker.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCategoryResponse {
    private Long categoryId;
    private String name;
    private String description;
}
