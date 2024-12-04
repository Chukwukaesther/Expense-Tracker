package com.semicolon.Expense_Tracker.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequest {

    private Long categoryId;
    private String name;
    private String description;
}
