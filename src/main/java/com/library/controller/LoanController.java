package com.library.controller;

import com.library.controller.request.LoanRequest;
import com.library.controller.response.LoanResponse;
import com.library.controller.response.UserResponse;
import com.library.mapper.LoanMapper;
import com.library.mapper.UserMapper;
import com.library.model.Loan;
import com.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> saveLoan(@RequestBody LoanRequest request){
        var savedLoan = loanService.createLoan(request.userId(), request.bookIds());
        return ResponseEntity.ok(LoanMapper.toResponse(savedLoan));
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<LoanResponse> returnLoan(@PathVariable Long id) {
        var returnedLoan = loanService.returnLoan(id);
        return ResponseEntity.ok(LoanMapper.toResponse(returnedLoan));
    }

    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAllLoans(){
        return ResponseEntity.ok(loanService.getAllLoans()
                .stream()
                .map(LoanMapper::toResponse)
                .toList());
    }

}
