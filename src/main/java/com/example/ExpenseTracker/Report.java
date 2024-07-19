package com.example.ExpenseTracker;

import java.util.Map;

public class Report {
    private int month;
    private int year;
    private double totalExpenses;
    private Map<String,Double> expenseByCategory;

    public Report(int month, int year, double totalExpenses, Map<String,Double> expenseByCategory) {
        this.month = month;
        this.year = year;
        this.totalExpenses = totalExpenses;
    }


}
