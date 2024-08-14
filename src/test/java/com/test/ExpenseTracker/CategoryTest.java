package com.test.ExpenseTracker;

import com.example.ExpenseTracker.Category;
import org.testng.annotations.Test;


import java.util.UUID;

import static org.testng.AssertJUnit.*;
public class CategoryTest {

    @Test
    public void testToString() {
        Category category = new Category(UUID.randomUUID(), "Groceries");
        assertEquals("Id:"+category.getId() +" Name:Groceries", category.toString());
    }
}
