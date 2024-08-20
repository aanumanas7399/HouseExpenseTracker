package com.example.ExpenseTracker;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.NonNull;

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

    public boolean isOfCategory(@NonNull Category category) {
        return this.categoryId == category.getId();
    }

    public String toString() {
        return this.description + ": INR " + this.amount;
    }

    public void updateExpense(String newDescription, double newAmount) {
        description = newDescription;
        amount = newAmount;
    }

}
