package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDto;
import org.springframework.http.ResponseEntity;

import com.thelibrarian.integration.dto.BookDataDto;

public interface BookService {
    public ResponseEntity<BookDataDto> getRandomBooks();
    public ResponseEntity<BookDataDto> searchBookByTitleAuthor(String title, String author);
    public ResponseEntity<BookDataDto> getBookByIsbn(String isbn);
    public ResponseEntity<BookDataDto> getBookByAuthor(String author);
    public ResponseEntity<BookDataDto> getBookByTitle(String title);
    public ResponseEntity<BookDto> getBookById(String id);
}
