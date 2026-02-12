package com.library.entity;

import com.library.entity.Book;
import jakarta.persistence.*;

import java.util.List;
public class LibraryBookJpaApp {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book b1 = new Book(1, "Clean Code", "Robert C. Martin",
                "Programming", 750.0, "Available", 2008);

        Book b2 = new Book(2, "Effective Java", "Joshua Bloch",
                "Programming", 900.0, "Available", 2018);

        Book b3 = new Book(3, "The Alchemist", "Paulo Coelho",
                "Fiction", 500.0, "Available", 1988);

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);

        em.getTransaction().commit();

        System.out.println("Books Inserted Successfully\n");

        // Fetch by ID
        Book book = em.find(Book.class, 1);
        System.out.println("Fetched By ID:");
        System.out.println(book);

        // Fetch All
        System.out.println("\nAll Books:");
        List<Book> bookList =
                em.createQuery("FROM Book", Book.class).getResultList();

        for (Book b : bookList) {
            System.out.println(b);
        }

        em.getTransaction().begin();

        Book updateBook = em.find(Book.class, 2);
        if (updateBook != null) {
            updateBook.setPrice(950.0);
            updateBook.setAvailabilityStatus("Issued");
        }

        em.getTransaction().commit();
        System.out.println("\nBook Updated Successfully");

        em.getTransaction().begin();

        Book deleteBook = em.find(Book.class, 3);
        if (deleteBook != null) {
            em.remove(deleteBook);
        }

        em.getTransaction().commit();
        System.out.println("Book Deleted Successfully");

        em.close();
        emf.close();
    }
}
