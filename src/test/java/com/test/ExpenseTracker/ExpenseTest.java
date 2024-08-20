package com.test.ExpenseTracker;

import static org.testng.AssertJUnit.*;

import java.util.*;

import org.testng.annotations.Test;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.Expense;

public class ExpenseTest {

    @Test
    public void testIsExpenseOfCategory() {
        Category category = new Category(UUID.randomUUID(), "Food");
        Expense expense = new Expense("Lunch", 150.0, new Date(), category);

        assertTrue(expense.isOfCategory(category));
    }

    @Test
    public void testUpdateExpense() {
        Category category = new Category(UUID.randomUUID(), "Utilities");
        Expense expense = new Expense("Electricity Bill", 3000.0, new Date(), category);
        expense.updateExpense("Water Bill", 2000.0);
        assertEquals("Water Bill", expense.toString().split(":")[0]);
        assertEquals(2000.0, expense.getAmount());
    }

    @Test
    public void testToString() {
        Category category = new Category(UUID.randomUUID(), "Groceries");
        Expense expense = new Expense("Milk", 50.0, new Date(), category);

        assertEquals("Milk: INR 50.0", expense.toString());
    }

    @Test
    public void testIsExpenseOfCategoryWithDifferentCategory() {
        Category category1 = new Category(UUID.randomUUID(), "Transport");
        Category category2 = new Category(UUID.randomUUID(), "Entertainment");
        Expense expense = new Expense("Movie Ticket", 500.0, new Date(), category2);

        assertFalse(expense.isOfCategory(category1));
    }
}
