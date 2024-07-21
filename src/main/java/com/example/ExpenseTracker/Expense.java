package com.example.ExpenseTracker;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
public class Expense {
    private String id;
    private String description;
    private double amount;
    private Date date;
    private String categoryId;

    public double getAmount(){
        return amount;
    }

    //isWithinDateRange

    //isExpenseGreaterThan(Amount target)

    //
}
