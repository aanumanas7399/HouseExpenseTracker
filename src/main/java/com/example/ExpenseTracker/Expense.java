package com.example.ExpenseTracker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;
import java.util.UUID;

public class Expense {

    private UUID id;
    private String description;
    private @Getter double amount;

    private @Getter Date date;
    private UUID categoryId;


    public Expense(String description, double amount, Date date, Category category) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.categoryId = category.getId();
    }


    //isWithinDateRange

    //isExpenseGreaterThan(Amount target)

    public boolean isExpenseOfCategory(@NonNull Category category) {
        return this.categoryId == category.getId();
    }

    public String toString() {
        return this.description + ": INR " + this.amount;
    }


    public boolean updateExpense(Expense expense, String newDescription, double newAmount) {
        if (expense != null) {
            expense.description = newDescription;
            expense.amount = newAmount;
            return true;
        }
        return false;
    }

}
