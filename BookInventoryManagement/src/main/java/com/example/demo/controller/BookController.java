package com.example.demo.controller;
import com.example.demo.service.BookService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    @GetMapping("/author")
    public ResponseEntity<?> byAuthor(@RequestParam String author) {
        return ResponseEntity.ok(service.getByAuthor(author));
    }

    @GetMapping("/genre")
    public ResponseEntity<?> byGenre(@RequestParam String genre,
                                     @RequestParam(defaultValue="0") int page,
                                     @RequestParam(defaultValue="5") int size) {
        return ResponseEntity.ok(service.getByGenre(genre, page, size));
    }

    @GetMapping("/cheaper")
    public ResponseEntity<?> cheaper(@RequestParam Double maxPrice) {
        return ResponseEntity.ok(service.getCheaperThan(maxPrice));
    }

    @GetMapping("/expensive")
    public ResponseEntity<?> expensive(@RequestParam Double minPrice) {
        return ResponseEntity.ok(service.getMoreExpensiveThan(minPrice));
    }

    @GetMapping("/new-arrivals")
    public ResponseEntity<?> newArrivals(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publishedAfter) {
        return ResponseEntity.ok(service.getNewArrivals(publishedAfter));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String keyword) {
        return ResponseEntity.ok(service.searchByTitle(keyword));
    }

    @GetMapping("/genre-author")
    public ResponseEntity<?> genreAuthor(@RequestParam String genre,
                                         @RequestParam String author) {
        return ResponseEntity.ok(service.getByGenreAndAuthor(genre, author));
    }

    @GetMapping("/genre-or-author")
    public ResponseEntity<?> genreOrAuthor(@RequestParam String genre,
                                           @RequestParam String author) {
        return ResponseEntity.ok(service.getByGenreOrAuthor(genre, author));
    }

    @GetMapping("/price-range")
    public ResponseEntity<?> priceRange(@RequestParam Double minPrice,
                                        @RequestParam Double maxPrice) {
        return ResponseEntity.ok(service.getByPriceRange(minPrice, maxPrice));
    }

    @GetMapping("/genre-discount")
    public ResponseEntity<?> genreDiscount(@RequestParam String genre,
                                           @RequestParam Double maxPrice) {
        return ResponseEntity.ok(service.getGenreDiscount(genre, maxPrice));
    }
    @GetMapping("/latest")
    public ResponseEntity<?> latest(@RequestParam(defaultValue="0") int page,
                                    @RequestParam(defaultValue="5") int size) {
        return ResponseEntity.ok(service.getLatest(page, size));
    }

    @GetMapping("/by-price")
    public ResponseEntity<?> byPrice(@RequestParam(defaultValue="0") int page,
                                     @RequestParam(defaultValue="5") int size) {
        return ResponseEntity.ok(service.getByPrice(page, size));
    }
}