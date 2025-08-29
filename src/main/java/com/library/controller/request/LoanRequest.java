package com.library.controller.request;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record LoanRequest(Long userId,
                          List<Long> bookIds,
                          LocalDate loanDate,
                          LocalDate returnDate) {
}
