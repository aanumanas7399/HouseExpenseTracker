package com.example.ExpenseTracker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
public class Category {
    private @Getter UUID id;
    private @Getter String name;

    public String toString() {
        return  "Id:" + this.getId() + " Name:" + this.getName();
    }
}
