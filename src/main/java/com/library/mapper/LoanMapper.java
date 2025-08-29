package com.library.mapper;

import com.library.controller.request.LoanRequest;
import com.library.controller.response.LoanResponse;
import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class LoanMapper {

    public static Loan toEntity(LoanRequest request, User user, List<Book> books) {
        return Loan.builder()
                .user(user)
                .books(books)
                .loanDate(request.loanDate())
                .returnDate(request.returnDate())
                .returned(false)
                .build();
    }

    public static LoanResponse toResponse(Loan loan) {
        var userSummary = LoanResponse.UserSummary.builder()
                .id(loan.getUser().getId())
                .name(loan.getUser().getName())
                .email(loan.getUser().getEmail())
                .build();

        var bookSummaries = loan.getBooks().stream()
                .map(book -> LoanResponse.BookSummary.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .ISBN(book.getISBN())
                        .build())
                .collect(Collectors.toList());

        return LoanResponse.builder()
                .id(loan.getId())
                .user(userSummary)
                .books(bookSummaries)
                .loanDate(loan.getLoanDate())
                .returnDate(loan.getReturnDate())
                .returned(loan.isReturned())
                .build();
    }
}
