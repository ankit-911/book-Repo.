package com.example.library.serviceImpl;

import com.example.library.DTO.BookRequestDto;
import com.example.library.DTO.BookResponseDto;
import com.example.library.entity.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.BookNotSaveException;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(BookRequestDto bookRequestDto) throws BookNotSaveException {
        Book book = null;
        try {
            book = new Book();
            book.setAuthor(bookRequestDto.getAuthor());
            book.setTitle(bookRequestDto.getTitle());
            book.setPrice(bookRequestDto.getPrice());
            book.setYearPublished(bookRequestDto.getYearPublished());
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new BookNotSaveException("Book not saved");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().collect(Collectors.toList());
    }

    @Override
    public String deleteBook(Integer id) throws BookNotFoundException {
        String message = "Delete Book Successfully";
        try {
            bookRepository.deleteById(id);
        } catch (Exception exception) {
            throw new BookNotFoundException("Book Not found !!" + id);
        }
        return message;
    }

    @Override
    public BookResponseDto fetchBookByID(Integer id) throws BookNotFoundException {
        BookResponseDto bookResponseDto = new BookResponseDto();
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found")));

        if (book.isPresent()) {
            bookResponseDto.setId(book.get().getId());
            bookResponseDto.setTitle(book.get().getTitle());
            bookResponseDto.setPrice(book.get().getPrice());
            bookResponseDto.setAuthor(book.get().getAuthor());
            bookResponseDto.setYearPublished(book.get().getYearPublished());
        } else {
            throw new BookNotFoundException("book not found with this : " + id);
        }
        return bookResponseDto;

    }

    @Override
    public Book updateBook(Integer id, BookRequestDto bookRequestDto) {

        Book book = bookRepository.findById(id).orElseThrow();

        if (bookRequestDto.getYearPublished() != null) {
            book.setYearPublished(bookRequestDto.getYearPublished());
        }

        if (bookRequestDto.getAuthor() != null) {
            book.setAuthor(bookRequestDto.getAuthor());
        }

        if (bookRequestDto.getPrice() != null) {
            book.setPrice(bookRequestDto.getPrice());
        }
        if (bookRequestDto.getTitle() != null) {
            book.setTitle(bookRequestDto.getTitle());
        }


        bookRepository.save(book);
        return book;
    }

    @Override
    public Page<Book> getAllBooks_Pegination(String title, String author, Double minPrice, Double maxPrice,
                                             Integer minYear, Integer maxYear,String sortBy, String sortOrder, Pageable pageable) {


        return bookRepository.searchBooks(title, author, minPrice,maxPrice, minYear, maxYear, sortBy, sortOrder, pageable);
    }



























//    @Override
//    public List<Book> fetchBookByName(String author) {
//        return bookRepository.findBookByName(author).stream().sorted((b1, b2) -> Double.compare(b1.getPrice(), b1.getPrice())).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Book> getBooksByPrice(double price) {
//        return bookRepository.findBooksByPrice(price);
//    }
//
//    @Override
//    public List<Book> getBooksByTitle(String title) {
//        return bookRepository.findBooksByTitleContainingIgnoreCase(title);
//    }
//
//
//    @Override
//    Page<Book> getAllBooks(int page, int size) {
//
//        PageRequest pageRequest = PageRequest.of(page, size);
//        return (Page<Book>) bookRepository.findAll(pageRequest);
//
//    }
}
