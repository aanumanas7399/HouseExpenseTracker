package com.example;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.CategoryService;
import com.example.ExpenseTracker.Expense;
import com.example.ExpenseTracker.ExpenseService;

import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();
        CategoryService categoryService = new CategoryService();

        // Add a new category
        categoryService.addCategory("Clothes");
        categoryService.addCategory("Food");

        //get category Ids by its name

        String clothesCategoryId = categoryService.getCategoryIdByName("Clothes");
        String foodCategoryId = categoryService.getCategoryIdByName("Food");

        // add new expenses
        expenseService.addExpense("shopping - purchase clothes",2000.0,clothesCategoryId,new Date());
        expenseService.addExpense("expenses - spent on food",500.0,foodCategoryId,new Date());

        // get list of expenses for each category
        List<Expense> clothesExpenses = expenseService.getExpensesByCategory(clothesCategoryId);
        List<Expense> foodExpenses = expenseService.getExpensesByCategory(foodCategoryId);

        // Printing expenses for each category
        System.out.println("Clothes Expenses:");
        for (Expense expense : clothesExpenses) {
            System.out.println(expense.getDescription() + ": INR " + expense.getAmount());
        }

        System.out.println("Food Expenses:");
        for (Expense expense : foodExpenses) {
            System.out.println(expense.getDescription() + ": INR " + expense.getAmount());
        }

        // Retrieve category by ID
        Category clothesCategory = categoryService.getCategoryById(clothesCategoryId);
        Category foodCategory = categoryService.getCategoryById(foodCategoryId);

        // Printing the category details
        System.out.println("Retrieved Category details by ID:");
        System.out.println("Food Category - ID: " + foodCategory.getId() + ", Name: " + foodCategory.getName());
        System.out.println("Clothes Category - ID: " + clothesCategory.getId() + ", Name: " + clothesCategory.getName());
    }
}