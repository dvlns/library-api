package com.library.controller.response;

import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

@Builder
public record LoanResponse(Long id,
                           UserSummary user,
                           List<BookSummary> books,
                           LocalDate loanDate,
                           LocalDate returnDate,
                           boolean returned
) {
    @Builder
    public record UserSummary(Long id, String name, String email) {}

    @Builder
    public record BookSummary(Long id, String title, String author, String ISBN) {}
}
