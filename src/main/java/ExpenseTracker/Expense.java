package main.java.ExpenseTracker;
import java.util.Date;

public class Expense {
    private String id;
    private double amount;
    private Date date;
    private String category;
    private String description;

    public Expense(String id, double amount, Date date, String category, String description) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    public double getAmount(){
        return amount;
    }

    //isWithinDateRange

    //isExpenseGreaterThan(Amount target)

    //
}
