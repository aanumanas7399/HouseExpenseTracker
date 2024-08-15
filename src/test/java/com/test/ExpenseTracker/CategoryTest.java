package com.test.ExpenseTracker;

import static org.testng.AssertJUnit.*;

import java.util.UUID;

import org.testng.annotations.Test;

import com.example.ExpenseTracker.Category;
public class CategoryTest {

    @Test
    public void testToString() {
        Category category = new Category(UUID.randomUUID(), "Groceries");
        assertEquals("Id:"+category.getId() +" Name:Groceries", category.toString());
    }
}
