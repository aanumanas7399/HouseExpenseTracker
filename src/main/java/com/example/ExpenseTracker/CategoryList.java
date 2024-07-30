package com.example.ExpenseTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryList {

    private List<Category> categories;

    public CategoryList() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(String name) {
        Category category = new Category(UUID.randomUUID(), name);
        this.categories.add(category);
    }

    public Optional<Category> getCategory(UUID id) {
        return categories.stream().filter(cat -> cat.getId().equals(id)).findFirst();
    }

    public Optional<Category> getCategory(String name) {
        return categories.stream().filter(cat -> cat.getName().equals(name)).findFirst();
    }

}
