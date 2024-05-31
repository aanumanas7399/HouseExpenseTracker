package ExpenseTracker;

import java.util.*;

public class ExpenseTracker {
    private List<Expense> expenses;
    private List<Category> categories;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public double getTotalAmount() {
        return expenses.stream().map(x -> x.getAmount()).reduce(0.0, Double::sum);
    }

    //if I have to get expenses by category - tracking expenses based on category
    /*public Map<String,Double> basedOnCategory(){
        Map<String,Double> basedOnCategory = new HashMap<>();
        for (Expense expense : expenses) {
            String category =
        }
    }*/


}
