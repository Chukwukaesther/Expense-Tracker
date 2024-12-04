package com.semicolon.Expense_Tracker.data.repository;

import com.semicolon.Expense_Tracker.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryById(Long categoryId);
}
