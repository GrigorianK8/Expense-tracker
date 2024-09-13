package com.example.backend.service;

import com.example.backend.dto.ExpenseDTO;

import java.util.List;
/**
 * Service interface for Expense module
 * @author grigoriank
 * */
public interface ExpenseService {

    /**
     * It will fetch the expenses from database
     * @return list
     * */
    List<ExpenseDTO> getAllExpenses();
}
