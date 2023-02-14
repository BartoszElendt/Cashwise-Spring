package com.example.cashwise.model;

import java.math.BigDecimal;
import java.time.LocalDate;




public class ExpenseModel {

    private BigDecimal amount;
    private String title;

    private LocalDate creationDate;


    public ExpenseModel() {
    }

    public ExpenseModel(BigDecimal amount, String title, LocalDate creationDate) {
        this.amount = amount;
        this.title = title;
        this.creationDate = creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
