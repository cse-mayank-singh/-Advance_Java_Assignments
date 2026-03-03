package com.example.demo.service;
import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
public interface BookService {

    List<Book> getByAuthor(String author);

    Page<Book> getByGenre(String genre, int page, int size);

    List<Book> getCheaperThan(Double maxPrice);

    List<Book> getMoreExpensiveThan(Double minPrice);

    List<Book> getNewArrivals(LocalDate date);

    List<Book> searchByTitle(String keyword);

    List<Book> getByGenreAndAuthor(String genre, String author);

    List<Book> getByGenreOrAuthor(String genre, String author);

    List<Book> getByPriceRange(Double min, Double max);

    List<Book> getGenreDiscount(String genre, Double maxPrice);

    Page<Book> getLatest(int page, int size);

    Page<Book> getByPrice(int page, int size);
}