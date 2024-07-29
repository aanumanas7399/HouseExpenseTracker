package com.example.ExpenseTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryService {

    private List<Category> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(String name) {
        String id = UUID.randomUUID().toString();
        Category category = new Category(id, name);
        this.categories.add(category);
    }

    public Category getCategoryById(String id) {
        return categories.stream().filter(cat->cat.getId().equals(id)).findFirst().orElse(null);
    }

    public String getCategoryIdByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category.getId();
            }
        }
        return null;
    }

}
