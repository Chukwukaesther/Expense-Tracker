package com.semicolon.Expense_Tracker.data.repository;

import com.semicolon.Expense_Tracker.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
