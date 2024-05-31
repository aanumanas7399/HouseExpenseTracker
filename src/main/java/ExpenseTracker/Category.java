package main.java.ExpenseTracker;

import java.util.List;

public class Category {
    private String id;
    private String name;

    public Category(String id, String name, List<Expense> expenses) {
        this.id = id;
        this.name = name;
    }
}
