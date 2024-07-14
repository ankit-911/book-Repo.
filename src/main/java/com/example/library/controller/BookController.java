package com.example.library.controller;

import com.example.library.DTO.BookRequestDto;
import com.example.library.DTO.BookResponseDto;
import com.example.library.entity.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.BookNotSaveException;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping()
    public Book createBook(@RequestBody BookRequestDto bookRequestDto) throws BookNotSaveException {
        return bookService.createBook(bookRequestDto);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/deletBookByID/{id}")
    public String deleteBook(@PathVariable("id") Integer id) throws BookNotFoundException {
        return bookService.deleteBook(id);
    }

    @GetMapping("/getBookByID/{id}")
    public BookResponseDto fetchBookByID(@PathVariable("id") Integer id) throws BookNotFoundException {
        return bookService.fetchBookByID(id);
    }

    @PutMapping("/UpdateRecordByID/{id}")
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody BookRequestDto bookRequestDto) {
        return bookService.updateBook(id, bookRequestDto);
    }




















//    @GetMapping("/getAllBooks")
//    public Page<Book> getAllBooks_Pegination(@RequestParam(defaultValue = "0") int page,
//                                             @RequestParam(defaultValue = "10") int size,
//                                             @RequestParam(defaultValue = "price") String sortBy,
////                                             @RequestParam(defaultValue = "asc") String sortOrder,
//                                             @RequestParam(required = false) String title,
//                                             @RequestParam(required = false) String author,
//                                             @RequestParam(required = false) Double minPrice,
//                                             @RequestParam(required = false) Double maxPrice,
//                                             @RequestParam(required = false) Integer minYear,
//                                             @RequestParam(required = false) Integer maxYear)
//
//    {
//
////        Sort.Direction sortDirection  =  sortOrder.equalsIgnoreCase("desc")? Sort.Direction.DESC : Sort.Direction.ASC;
////
////        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
//
//
//
//        return bookService.getAllBooks_Pegination(title, author, minPrice,maxPrice, minYear, maxYear, sortBy, page, size);
//    }


//
//    @GetMapping("/getBookByName/{author}")
//    public List<Book> fetchBookByName(@PathVariable("author") String author) {
//        return bookService.fetchBookByName(author);
//    }
//
//
//    @GetMapping("/filterByPrice")
//    public List<Book> getBooksByPrice(@RequestParam double price) {
//        return bookService.getBooksByPrice(price);
//    }
//
//    @GetMapping("/filterByTitle")
//    public List<Book> getBooksByTitle(@RequestParam String title) {
//        return bookService.getBooksByTitle(title);
//    }
//
//    @GetMapping("/AllBooks")
//    public Page<Book> getAllBooks (@RequestParam(defaultValue = "1") int page,
//                                   @RequestParam(defaultValue = "5") int size ) {
//        return bookService.getAllBooks (page, size);
//    }

}
