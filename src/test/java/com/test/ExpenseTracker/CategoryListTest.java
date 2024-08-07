package com.test.ExpenseTracker;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.CategoryList;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CategoryListTest {

    @Test
    public void testAddCategory() {
        CategoryList categoryList = new CategoryList();
        categoryList.addCategory("Utilities");

        Optional<Category> category = categoryList.getCategory("Utilities");
        assertTrue(category.isPresent());
        assertEquals("Utilities", category.get().getName());
    }


}
