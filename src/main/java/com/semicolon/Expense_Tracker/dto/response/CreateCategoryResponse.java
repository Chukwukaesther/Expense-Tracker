package com.semicolon.Expense_Tracker.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryResponse {
    private Long categoryId;
    private String name;
    private String description;
}