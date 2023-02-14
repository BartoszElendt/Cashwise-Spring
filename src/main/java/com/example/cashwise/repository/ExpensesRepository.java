package com.example.cashwise.repository;

import com.example.cashwise.model.ExpenseModel;

import java.util.List;

public interface ExpensesRepository {
    void saveExpense(ExpenseModel expenseModel);
    List<ExpenseModel> getExpense();
}
