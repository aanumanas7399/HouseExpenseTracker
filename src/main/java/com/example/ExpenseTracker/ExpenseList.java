package com.example.ExpenseTracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ExpenseList {

    private List<Expense> expenses;

    public ExpenseList() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount, Category category, Date date) {
        Expense expense = new Expense(description, amount, date, category);
        this.expenses.add(expense);
    }

    public List<Expense> getExpensesByCategory(Category category) {
        return expenses.stream()
                .filter(expense -> expense.isExpenseOfCategory(category))
                .collect(Collectors.toList());
    }

    public double amountForExpensesByCategory(Category category) {
        List<Expense> expenses = getExpensesByCategory(category);
        return expenses.stream().reduce(new Double(0), (total, it) -> it.getAmount());
    }

}
