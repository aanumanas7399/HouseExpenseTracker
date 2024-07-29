package com.example.ExpenseTracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ExpenseService {

    private List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount, String categoryId, Date date) {
        
        String id = UUID.randomUUID().toString();
        Expense expense = Expense.builder()
                .id(id)
                .description(description)
                .amount(amount).date(date)
                .categoryId(categoryId)
                .build();

        this.expenses.add(expense);
    }

    public List<Expense> getExpensesByCategory(String categoryId) {
        return expenses.stream()
                .filter(expense -> expense.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

}
