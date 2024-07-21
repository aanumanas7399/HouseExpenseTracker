package com.example;

import com.example.ExpenseTracker.CategoryService;
import com.example.ExpenseTracker.ExpenseService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();
        CategoryService categoryService = new CategoryService();
    }
}