package com.example.ExpenseTracker;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private List<Category> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(String name) {
        //ToDo Add method to generate random id
        Category category = new Category("1", name);
        this.categories.add(category);
    }

}
