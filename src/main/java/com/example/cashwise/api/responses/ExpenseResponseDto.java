package com.example.cashwise.api.responses;

import com.example.cashwise.api.domain.Expense;

import java.math.BigDecimal;

public record ExpenseResponseDto(
        //record- definiuje on automatycznie konstruktory, metody equals, hashCode i toString, opakowując pola obiektu, jest immutable co oznacza, żejego wartość nie może zostać zmieniona po utworzeniu, w nawiasię okrąglym deklarujemy pola
        String title,
        String expnseId,
        BigDecimal amount
) {
    public static ExpenseResponseDto fromDomain(Expense expense){
       return new ExpenseResponseDto(expense.title(),expense.expenseId().value(),expense.amount());
    }
}
