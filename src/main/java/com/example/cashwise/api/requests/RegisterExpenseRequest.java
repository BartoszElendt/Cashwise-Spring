package com.example.cashwise.api.requests;

import java.math.BigDecimal;

public record RegisterExpenseRequest(String title, BigDecimal amount) { //nie chcemy przyjmować ID z zewnątrz dlatego deklarujemy tylko dwa pola tutaj, ID nadajemy w swoim systemie
}
