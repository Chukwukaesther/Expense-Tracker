package com.semicolon.Expense_Tracker.controller;

import com.semicolon.Expense_Tracker.Exception.ExpenseTrackerException;
import com.semicolon.Expense_Tracker.dto.request.CreateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.request.DeleteCategoryRequest;
import com.semicolon.Expense_Tracker.dto.request.UpdateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.response.ApiResponse;
import com.semicolon.Expense_Tracker.dto.response.CreateCategoryResponse;
import com.semicolon.Expense_Tracker.dto.response.DeleteCategoryResponse;
import com.semicolon.Expense_Tracker.dto.response.UpdateCategoryResponse;
import com.semicolon.Expense_Tracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest){
        try{
            CreateCategoryResponse result = categoryService.createCategory(createCategoryRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }


    @PostMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        try{
        UpdateCategoryResponse result = categoryService.updateCategory(updateCategoryRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("/deleteCategory")
    public ResponseEntity<?> deleteCategory(@RequestBody DeleteCategoryRequest deleteCategoryRequest){
        try{
            DeleteCategoryResponse result = categoryService.delete(deleteCategoryRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

}
