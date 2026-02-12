package com.gapgemini.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("my-pu");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer = new Customer(200, "Bruce", "Gotham");
        em.persist(customer);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
