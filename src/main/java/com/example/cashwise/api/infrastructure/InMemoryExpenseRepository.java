package com.example.cashwise.api.infrastructure;

import com.example.cashwise.api.domain.Expense;
import com.example.cashwise.api.domain.ExpenseId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Repository
public class InMemoryExpenseRepository implements ExpenseRepository {
    private final Map<ExpenseId, Expense> storage = new HashMap<>();
    @Override
    public Expense save(Expense expense) {
        return storage.put(expense.expenseId(),expense);
    }

    @Override
    public Optional<Expense> getExpenseByExpenseId(ExpenseId expenseId) {
        return Optional.ofNullable(storage.get(expenseId));
    }

    @Override
    public void deleteExpenseById(ExpenseId expenseId) {
        storage.remove(expenseId);

    }

    @Override
    public Expense updateExpense(Expense expense) {
        return storage.put(expense.expenseId(),expense);
    }

}
