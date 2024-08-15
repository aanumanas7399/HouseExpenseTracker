package com.test.ExpenseTracker;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.Optional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.CategoryList;

public class CategoryListTest {

    private CategoryList categoryList;
    private Optional<Category> foodCategory;
    private Optional<Category> utilitiesCategory;

    @BeforeMethod
    public void setUp() {
        categoryList = new CategoryList();
        categoryList.addCategory("Food");
        categoryList.addCategory("Utilities");
    }

    @Test
    public void testAddCategory() {
        utilitiesCategory = categoryList.getCategory("Utilities");
        assertTrue(utilitiesCategory.isPresent());
        assertEquals("Utilities", utilitiesCategory.get().getName());
    }

    @Test
    public void testGetCategoryById() {
        foodCategory = categoryList.getCategory("Food");
        Optional<Category> foundCategory = categoryList.getCategory(foodCategory.get().getId());
        assertTrue(foundCategory.isPresent());
        assertEquals(foodCategory, foundCategory);
    }

    @Test
    public void testGetCategoryByName() {
        utilitiesCategory = categoryList.getCategory("Utilities");
        Optional<Category> foundCategory = categoryList.getCategory("Utilities");
        assertTrue(foundCategory.isPresent());
        assertEquals(utilitiesCategory, foundCategory);
    }




}
