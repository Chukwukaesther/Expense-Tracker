package com.semicolon.Expense_Tracker.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class UpdateCategoryRequest {
    private Long categoryId;
    private String name;
    private String description;
}
