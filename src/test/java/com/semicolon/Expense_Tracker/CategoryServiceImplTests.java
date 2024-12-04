package com.semicolon.Expense_Tracker;
import com.semicolon.Expense_Tracker.dto.request.CreateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.request.UpdateCategoryRequest;
import com.semicolon.Expense_Tracker.dto.response.CreateCategoryResponse;
import com.semicolon.Expense_Tracker.dto.response.UpdateCategoryResponse;
import com.semicolon.Expense_Tracker.service.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootTest
public class CategoryServiceImplTests {
    @Autowired
    private CategoryServiceImpl categoryService;


    @Test
    public void testThatUserCanCreateCreateCategory() {
        CreateCategoryRequest createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("Transportation");
        createCategoryRequest.setDescription("All transportation expenses");

        CreateCategoryResponse categoryResponse = categoryService.createCategory(createCategoryRequest);
        assertNotNull(categoryResponse);
        assertEquals("Transportation", categoryResponse.getName());
        assertEquals("All transportation expenses", categoryResponse.getDescription());
    }
    @Test
    public void testThatUserCanUpdateCategory() {
        CreateCategoryRequest createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("FoodStuff");
        createCategoryRequest.setDescription("Food Stuff Expenses");

        UpdateCategoryRequest update = new UpdateCategoryRequest();
        update.setName("A Car");
        update.setDescription("Car Budget");
        categoryService.updateCategory(update);

        UpdateCategoryResponse updatedCategory = categoryService.updateCategory(update);
        assertNotNull(updatedCategory);
        assertEquals("A Car", updatedCategory.getName());
        assertEquals("Car Budget", updatedCategory.getDescription());
    }

}

