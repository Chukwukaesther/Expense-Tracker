package com.semicolon.Expense_Tracker.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private LocalDateTime date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;

}
