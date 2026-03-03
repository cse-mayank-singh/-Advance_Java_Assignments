package com.example.demo.service;
import com.example.demo.entity.Book;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.BookRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repo;
    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public List<Book> getByAuthor(String author) {
        List<Book> books = repo.findByAuthor(author);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    
    @Override
    public Page<Book> getByGenre(String genre, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = repo.findByGenre(genre, pageable);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> getCheaperThan(Double maxPrice) {
        List<Book> books = repo.findByPriceLessThan(maxPrice);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> getMoreExpensiveThan(Double minPrice) {
        List<Book> books = repo.findByPriceGreaterThan(minPrice);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> getNewArrivals(LocalDate date) {
        List<Book> books = repo.findByPublishedDateAfter(date);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> searchByTitle(String keyword) {
        List<Book> books = repo.findByTitleContaining(keyword);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> getByGenreAndAuthor(String genre, String author) {
        List<Book> books = repo.findByGenreAndAuthor(genre, author);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> getByGenreOrAuthor(String genre, String author) {
        List<Book> books = repo.findByGenreOrAuthor(genre, author);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> getByPriceRange(Double min, Double max) {
        List<Book> books = repo.findByPriceBetween(min, max);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public List<Book> getGenreDiscount(String genre, Double maxPrice) {
        List<Book> books = repo.findByGenreAndPriceLessThan(genre, maxPrice);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public Page<Book> getLatest(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = repo.findByOrderByPublishedDateDesc(pageable);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
    @Override
    public Page<Book> getByPrice(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = repo.findByOrderByPriceAsc(pageable);
        if (books.isEmpty()) throw new ResourceNotFoundException("No books found");
        return books;
    }
}