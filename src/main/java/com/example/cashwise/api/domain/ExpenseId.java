package com.example.cashwise.api.domain;

public record ExpenseId(
        String value) {
    static ExpenseId newId(String value){
        return new ExpenseId(value);
    }
}
