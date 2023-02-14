package com.example.cashwise.repository;

import com.example.cashwise.model.ExpenseModel;
import com.example.cashwise.repository.ExpensesRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryExpenseRepository implements ExpensesRepository {
    private final Map<String, ExpenseModel> expenseMap = new HashMap<>();

    @Override
    public void saveExpense(ExpenseModel expenseModel) {

    }

    @Override
    public List<ExpenseModel> getExpense(){
        return null;
    }

}
