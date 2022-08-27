package com.thelibrarian.core.controller;

import com.thelibrarian.integration.dto.BookDataDto;
import com.thelibrarian.integration.dto.BookDto;
import com.thelibrarian.integration.service.BookServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/get")
public class BookControllerApi {

    //Prueba sonar
    @Autowired
    BookServiceImpl bookService;


    @GetMapping(value = "/random")
    public ResponseEntity<BookDataDto> getBook() {

        return bookService.getRandomBooks();

    }


    @GetMapping(value = "/getByTitleAuthor/{title}/{author}")
    public ResponseEntity<BookDataDto> getBookByTitleAuthor(@PathVariable String title, @PathVariable String author) {

        return bookService.searchBookByTitleAuthor(title, author);

    }


    @GetMapping(value = "/searchByIsbn/{isbn}")
    public ResponseEntity<BookDataDto> getBookByIsbn(@PathVariable String isbn) {

        return bookService.getBookByIsbn(isbn);

    }


    @GetMapping(value = "/author/{author}")
    public ResponseEntity<BookDataDto> findByAuthor(@PathVariable String author) {

        return bookService.getBookByAuthor(author);

    }

    @GetMapping(value = "searchByTitle/{title}")
    public ResponseEntity<BookDataDto> findByTitle(@PathVariable String title) {

        return bookService.getBookByTitle(title);

    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable String id) {
        
        return bookService.getBookById(id);

    }

}
