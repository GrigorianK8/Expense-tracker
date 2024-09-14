package com.example.backend.endpoint;

import com.example.backend.dto.ExpenseDTO;
import com.example.backend.io.ExpenseResponse;
import com.example.backend.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
/**
 * This is controller class for Expense module
 * @author grigoriank
 * */
@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class ExpenseEndpoint {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    /**
     * It will fetch the expenses from database
     * @return list
     * */
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses() {
        log.info("API GET / expenses called");
        List<ExpenseDTO> list = expenseService.getAllExpenses();
        log.info("Printing the data from service {}", list);
        List<ExpenseResponse> response = list.stream()
                .map(expenseDTO -> mapToExpenseResponse(expenseDTO))
                .collect(Collectors.toList());

        return response;
    }

    /**
     * Mapper method for converting expense dto object to expense response
     * @param expenseDto
     * @return ExpenseResponse
     * */
    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
