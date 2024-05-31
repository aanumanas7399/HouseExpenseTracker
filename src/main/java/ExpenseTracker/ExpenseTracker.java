package main.java.ExpenseTracker;

import java.util.*;

public class ExpenseTracker {
    private List<Expense> expenses;

    private List<Category> categories;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public double getTotalExpenses() {
        return expenses.stream().reduce(0.0,(total,expense)-> total + expense.getAmount());

    }

    // if I have to get expenses by category - tracking expenses based on category
    /*public Map<String,Double> basedOnCategory(){
        Map<String,Double> basedOnCategory = new HashMap<>();
        for (Expense expense : expenses) {
            String category =
        }
    }*/


}
