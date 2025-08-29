package com.library.mapper;

import com.library.controller.request.BookRequest;
import com.library.controller.response.BookResponse;
import com.library.model.Book;

public class BookMapper {

    public static Book toEntity(BookRequest request) {
        return Book.builder()
                .title(request.title())
                .author(request.author())
                .ISBN(request.ISBN())
                .build();
    }

    public static BookResponse toResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .ISBN(book.getISBN())
                .build();
    }
}
