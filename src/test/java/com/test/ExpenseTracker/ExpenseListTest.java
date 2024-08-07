package com.test.ExpenseTracker;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.CategoryList;
import com.example.ExpenseTracker.ExpenseList;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;

public class ExpenseListTest {

    @Test
    public void testAddExpense() {
        CategoryList categoryList = new CategoryList();
        categoryList.addCategory("Food");
        Optional<Category> foodCategory = categoryList.getCategory("Food");

        ExpenseList expenseList = new ExpenseList();
        expenseList.addExpense("Dinner",250.0,foodCategory.get(),new Date());

        assertEquals(1,expenseList.getExpensesByCategory(foodCategory.get()).size());
    }

    @Test
    public void testGetExpensesByCategory() {

    }
}
