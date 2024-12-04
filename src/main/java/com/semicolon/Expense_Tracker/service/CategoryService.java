package com.semicolon.Expense_Tracker.service;

import com.semicolon.Expense_Tracker.data.model.Category;
import com.semicolon.Expense_Tracker.dto.request.CreateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.request.DeleteCategoryRequest;
import com.semicolon.Expense_Tracker.dto.request.UpdateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.response.CreateCategoryResponse;
import com.semicolon.Expense_Tracker.dto.response.DeleteCategoryResponse;
import com.semicolon.Expense_Tracker.dto.response.UpdateCategoryResponse;

public interface CategoryService {

    CreateCategoryResponse createCategory(CreateCategoryRequest request);

    UpdateCategoryResponse updateCategory(UpdateCategoryRequest request);

    Category findById(Long categoryId);

    DeleteCategoryResponse delete(DeleteCategoryRequest request);
}
