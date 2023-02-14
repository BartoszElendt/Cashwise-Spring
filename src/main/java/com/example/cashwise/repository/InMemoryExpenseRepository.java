package com.example.cashwise.repository;

import com.example.cashwise.model.ExpenseModel;
import com.example.cashwise.repository.ExpensesRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryExpenseRepository implements ExpensesRepository {
    private final List<ExpenseModel> expenses = new ArrayList<>();

    @Override
    public void saveExpense(ExpenseModel expenseModel) {
        expenses.add(expenseModel);

    }

    @Override
    public List<ExpenseModel> getExpense(){
        return expenses;
    }

}
