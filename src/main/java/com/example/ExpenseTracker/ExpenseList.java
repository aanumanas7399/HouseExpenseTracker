package com.example.ExpenseTracker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
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
                .filter(expense -> expense.isOfCategory(category))
                .collect(Collectors.toList());
    }

    public double amountForExpensesByCategory(Category category) {
        List<Expense> expenses = getExpensesByCategory(category);
        return expenses.stream().reduce(0.0, (total, it) -> total + it.getAmount(), Double::sum);
    }

    public Optional<Expense> getHighValueExpenseForCategory(Category category) {
        List<Expense> expenses = getExpensesByCategory(category);
        return Optional.of(expenses.stream().max(Comparator.comparingDouble(Expense::getAmount)).get());
    }

    public List<Expense> getExpensesForCurrentWeek(){
        LocalDate startOfWeek = LocalDate.now().minusWeeks(1);
        LocalDate endOfWeek = LocalDate.now().plusWeeks(1);

        Date startDate = Date.from(startOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(endOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return expenses.stream().filter(expense -> !expense.getDate().before(startDate) && !expense.getDate().after(endDate)).collect(Collectors.toList());
    }

}
