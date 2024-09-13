package com.example.backend.service.impl;

import com.example.backend.dto.ExpenseDTO;
import com.example.backend.entity.ExpenseEntity;
import com.example.backend.repository.ExpenseRepository;
import com.example.backend.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Service implementation for Expense module
 * @author grigoriank
 * */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl  implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    /**
     * It will fetch the expenses from database
     * @return list
     * */
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from repository {}", list);
        List<ExpenseDTO> listOfExpenses = list.stream()
                .map(expenseEntity -> mapToExpenseDTO(expenseEntity))
                .collect(Collectors.toList());
        return listOfExpenses;
    }

    /**
     * Mapper method to convert expense entity to expense DTO
     * @param expenseEntity
     * @return ExpenseDTO
     * */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
