package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepo;
    @GetMapping("/dogs")
    public List<Book> getBooks(){
        return (List<Book>) bookRepo.findAll();
    }
    @PostMapping("/dogs")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book data = bookRepo.save(book);
        if (data == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(data);
    }

}
