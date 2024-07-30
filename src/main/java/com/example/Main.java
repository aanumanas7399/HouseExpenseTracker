package com.example;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.CategoryList;
import com.example.ExpenseTracker.Expense;
import com.example.ExpenseTracker.ExpenseList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExpenseList expenseList = new ExpenseList();
        CategoryList categoryService = new CategoryList();

        // Add a new category
        categoryService.addCategory("Clothes");
        categoryService.addCategory("Food");

        //get categories by its name
        Optional<Category> clothesCategory = categoryService.getCategory("Clothes");
        Optional<Category> foodCategory = categoryService.getCategory("Food");

        // add new expenses
        expenseList.addExpense("shopping - purchase clothes",2000.0,clothesCategory.get(), new Date());
        expenseList.addExpense("expenses - spent on food",500.0,foodCategory.get(), new Date());

        // get list of expenses for each category
        List<Expense> clothesExpenses = expenseList.getExpensesByCategory(clothesCategory.get());
        List<Expense> foodExpenses = expenseList.getExpensesByCategory(foodCategory.get());

        // Printing expenses for each category
        System.out.println("Clothes Expenses:");
        clothesExpenses.forEach(it -> System.out.println(it));

        System.out.println("Food Expenses:");
        foodExpenses.forEach(it -> System.out.println(it));

        // Retrieve category by ID
        clothesCategory = categoryService.getCategory(clothesCategory.get().getId());
        foodCategory = categoryService.getCategory(foodCategory.get().getId());

        // Printing the category details
        System.out.println("Retrieved Category details by ID:");
        System.out.println(foodCategory);
        System.out.println(clothesCategory);
    }
}