package com.example.ExpenseTracker;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Category {
    private String id;
    private String name;

    public String getId() {return id;}

    public String getName() {return name;}
}
