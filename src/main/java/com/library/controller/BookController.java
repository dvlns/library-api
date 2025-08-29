package com.library.controller;

import com.library.controller.request.BookRequest;
import com.library.controller.response.BookResponse;
import com.library.mapper.BookMapper;
import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks()
                .stream()
                .map(BookMapper::toResponse)
                .toList());
    }

    @PostMapping
    public ResponseEntity<BookResponse> saveBook(@RequestBody BookRequest request){
        var book = BookMapper.toEntity(request);
        var savedBook = bookService.create(book);
        return ResponseEntity.ok(BookMapper.toResponse(savedBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
