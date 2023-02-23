package com.example.cashwise.api.domain;

import com.example.cashwise.api.infrastructure.ExpenseRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service //spring zaczyta na stracie, dzięki temu możemy wstrzyknąć te kalse do controllera
public class DefaultExpensesService implements ExpensesService {
    private final ExpenseRepository expenseRepository;

    public DefaultExpensesService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense registerNewExpense(String title, BigDecimal amount) {
        Expense expense = new Expense(ExpenseId.newId(UUID.randomUUID().toString()), title, amount);
        expenseRepository.save(expense);
        return expense;

    }

    @Override
    public Optional<Expense> getExpenseById(ExpenseId expenseId) {
        return expenseRepository.getExpenseByExpenseId(expenseId);
    }

    @Override
    public Expense updateExpense(String title, BigDecimal amount, ExpenseId expenseId) {
        Expense expense = new Expense(ExpenseId.newId(UUID.randomUUID().toString()), title, amount);
        expenseRepository.save(expense);
        return expense;
    }


    @Override
    public void deleteExpense(ExpenseId expenseId) {
        expenseRepository.deleteExpenseById(expenseId);
    }
}
