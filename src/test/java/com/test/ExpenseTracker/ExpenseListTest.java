package com.test.ExpenseTracker;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.ExpenseTracker.Category;
import com.example.ExpenseTracker.Expense;
import com.example.ExpenseTracker.ExpenseList;

public class ExpenseListTest {

    private ExpenseList expenseList;
    private Category foodCategory ;;
    private Category clothesCategory ;;

    @BeforeMethod
    public void setUp() {
        expenseList = new ExpenseList();
        foodCategory = new Category(UUID.randomUUID(), "Food");
        clothesCategory =new Category(UUID.randomUUID(), "Clothes");;
        expenseList.addExpense("Dinner",250.0,foodCategory,new Date());
        expenseList.addExpense("Shopping - Clothes",1500.0,clothesCategory,new Date());
        expenseList.addExpense("Breakfast",100.0,foodCategory,new Date());
    }

    @Test
    public void testAddExpense() {
        List<Expense> expenses = expenseList.getExpensesByCategory(foodCategory);
        assertEquals(2,expenses.size());
        assertEquals(250.0,expenses.get(0).getAmount());
    }

    @Test
    public void testGetExpensesByCategory() {
        List<Expense> foodExpenses = expenseList.getExpensesByCategory(foodCategory);
        List<Expense> clothesExpenses = expenseList.getExpensesByCategory(clothesCategory);

        assertEquals(2,foodExpenses.size());
        assertEquals(250.0,foodExpenses.get(0).getAmount());
        assertEquals(1,clothesExpenses.size());
        assertEquals(1500.0,clothesExpenses.get(0).getAmount());
    }

    @Test
    public void testAmountForExpensesByCategory() {
        double clothesTotal = expenseList.amountForExpensesByCategory(clothesCategory);
        double foodTotal = expenseList.amountForExpensesByCategory(foodCategory);
        assertEquals(1500.0,clothesTotal);
        assertEquals(350.0,foodTotal);
    }

    @Test
    public void testGetHighValueExpenseForCategory(){
        expenseList.addExpense("Breakfast",100.0,foodCategory,new Date());
        expenseList.addExpense("Shopping - Clothes",2000.0,clothesCategory,new Date());

        Optional<Expense> highValueExpenseForClothesCategory = expenseList.getHighValueExpenseForCategory(clothesCategory);
        Optional<Expense> highValueExpenseForFoodCategory = expenseList.getHighValueExpenseForCategory(foodCategory);

        assertTrue(highValueExpenseForClothesCategory.isPresent());
        assertTrue(highValueExpenseForFoodCategory.isPresent());
        assertEquals(2000.0,highValueExpenseForClothesCategory.get().getAmount());
        assertEquals(250.0,highValueExpenseForFoodCategory.get().getAmount());
    }

    @Test
    public void testGetExpensesForCurrentWeek(){
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.minusWeeks(1);
        Date dateInCurrentWeek = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateAtStartOfWeek = Date.from(startOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
        ExpenseList expenseList = new ExpenseList();
        expenseList.addExpense("Dinner",250.0,foodCategory,dateInCurrentWeek);
        expenseList.addExpense("Dinner",350.0,foodCategory,dateAtStartOfWeek);
        List<Expense> currentWeekExpenses = expenseList.getExpensesForCurrentWeek();

        assertEquals(2,currentWeekExpenses.size());
        assertEquals(250.0,currentWeekExpenses.get(0).getAmount());
        assertEquals(350.0,currentWeekExpenses.get(1).getAmount());
    }

}
