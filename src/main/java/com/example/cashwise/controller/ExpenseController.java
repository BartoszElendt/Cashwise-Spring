package com.example.cashwise.controller;

import com.example.cashwise.model.ExpenseModel;
import com.example.cashwise.repository.InMemoryExpenseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ExpenseController {
    InMemoryExpenseRepository inMemoryExpenseRepository = new InMemoryExpenseRepository();
    @GetMapping("/expenses")
    public List <ExpenseModel> getExpenses(){
        //return new ExpenseModel(BigDecimal.valueOf(12),"chleb", LocalDate.now());
        return inMemoryExpenseRepository.getExpense();
    }
    @PostMapping("/expenses")
    public void addExpenses(@RequestBody ExpenseModel expenseModel){
        System.out.println(expenseModel);
     // InMemoryExpenseRepository.saveExpense();

        inMemoryExpenseRepository.saveExpense(expenseModel);

    }

}
