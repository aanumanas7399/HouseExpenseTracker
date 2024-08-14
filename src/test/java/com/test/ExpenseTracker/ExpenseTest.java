package com.test.ExpenseTracker;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.Expense;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.AssertJUnit.*;

public class ExpenseTest {

    @Test
    public void testIsExpenseOfCategory() {
        Category category = new Category(UUID.randomUUID(), "Food");
        Expense expense = new Expense("Lunch", 150.0, new Date(), category);

        assertTrue(expense.isExpenseOfCategory(category));
    }

    @Test
    public void testUpdateExpense() {
        Category category = new Category(UUID.randomUUID(), "Utilities");
        Expense expense = new Expense("Electricity Bill", 3000.0, new Date(), category);

        boolean isUpdated = expense.updateExpense(expense, "Water Bill", 2000.0);

        assertTrue(isUpdated);
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

        assertFalse(expense.isExpenseOfCategory(category1));
    }
}
