package com.example.ExpenseTracker;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Category {
    private @Getter UUID id;
    private @Getter String name;

    public String toString() {
        return  "Id:" + this.getId() + " Name:" + this.getName();
    }
}
