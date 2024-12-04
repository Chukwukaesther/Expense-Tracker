package com.semicolon.Expense_Tracker.service;

import com.semicolon.Expense_Tracker.data.model.Category;
import com.semicolon.Expense_Tracker.data.repository.CategoryRepository;
import com.semicolon.Expense_Tracker.dto.request.CreateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.request.DeleteCategoryRequest;
import com.semicolon.Expense_Tracker.dto.request.UpdateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.response.CreateCategoryResponse;
import com.semicolon.Expense_Tracker.dto.response.DeleteCategoryResponse;
import com.semicolon.Expense_Tracker.dto.response.UpdateCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest request) {
        Category category = new Category();
        BeanUtils.copyProperties(request, category);
        category = categoryRepository.save(category);
        CreateCategoryResponse response = new CreateCategoryResponse();
        BeanUtils.copyProperties(category, response);

        return response;
    }
    @Override
    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest request){
        Category category = new Category();
       if (request.getName() != null){
           category.setName(request.getName());
       }
        if (request.getDescription() != null){
            category.setDescription(request.getDescription());
        }
        category = categoryRepository.save(category);
        UpdateCategoryResponse response = new UpdateCategoryResponse();
        BeanUtils.copyProperties(category, response);
        return response;
    }

    @Override
    public DeleteCategoryResponse delete(DeleteCategoryRequest request) {
        Category category = categoryRepository.findCategoryById(request.getCategoryId());
        if(category == null){
            throw new RuntimeException("Category not found");
        }
        categoryRepository.delete(category);
        DeleteCategoryResponse response = new DeleteCategoryResponse();
        response.setMessage("Category deleted successfully");

        return response;
    }
    @Override
    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category not found"));
    }
}
