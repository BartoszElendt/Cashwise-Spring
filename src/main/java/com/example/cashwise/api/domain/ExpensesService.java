package com.example.cashwise.api.domain;

import java.math.BigDecimal;
import java.util.Optional;

//@Service nie musi być tego oznaczenia, bo jest interface
public interface ExpensesService { //
    Expense registerNewExpense(String title, BigDecimal amount);
    Optional<Expense> getExpenseById(ExpenseId expenseId);

   Expense updateExpense(String title, BigDecimal amount, ExpenseId expenseId);

    void deleteExpense(ExpenseId expenseId);

}
