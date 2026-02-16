package com.company.employeelocker;
import jakarta.persistence.*;
public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // Create Locker
        Locker locker = new Locker("L-101", 2);
        // Create Employee and assign locker
        Employee employee =
                new Employee("Tony Stark", "Engineering", locker);
        // Persist
        em.persist(employee);
        em.getTransaction().commit();
        // Retrieve Employee
        Employee fetched =
                em.find(Employee.class, employee.getId());
        System.out.println("Employee: " + fetched.getName());
        System.out.println("Department: " + fetched.getDepartment());
        System.out.println("Locker Number: " +
                fetched.getLocker().getLockerNumber());
        System.out.println("Floor: " +fetched.getLocker().getFloor());
        em.close();
        emf.close();
    }
}