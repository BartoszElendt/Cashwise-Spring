package com.example.cashwise.api.infrastructure;

import com.example.cashwise.api.domain.Expense;
import com.example.cashwise.api.domain.ExpenseId;

import java.util.Optional;

public interface ExpenseRepository {
    Expense save(Expense expense);

    Optional<Expense> getExpenseByExpenseId(ExpenseId expenseId);

    void deleteExpenseById(ExpenseId expenseId);

    Expense updateExpense (ExpenseId expenseId);
}
