package com.example.ExpenseTracker;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Expense {
    private String id;
    private double amount;
    private Date date;
    private String categoryId;
    private String description;


    public double getAmount(){
        return amount;
    }

    //isWithinDateRange

    //isExpenseGreaterThan(Amount target)

    //
}
