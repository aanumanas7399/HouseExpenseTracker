package com.example.ExpenseTracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseService {

    private List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount, String categoryId, Date date) {

        //ToDo Add method to generate random id
        Expense expense = Expense.builder().id("1").description(description).amount(amount).date(date).categoryId(categoryId).build();

        this.expenses.add(expense);
    }

}
