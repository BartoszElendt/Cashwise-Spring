package com.example.cashwise.api.requests;

import com.example.cashwise.api.domain.ExpenseId;

import java.math.BigDecimal;

public record UpdateExpenseRequest(String title, BigDecimal amount, ExpenseId expenseId) {
}
