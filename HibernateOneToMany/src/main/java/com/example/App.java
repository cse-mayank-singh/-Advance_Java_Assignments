package com.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmplyeeNestPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Department dept = new Department("IT", "Mumbai");

        Employee e1 = new Employee("Tony", "Developer", 70000);
        Employee e2 = new Employee("Alice", "Tester", 60000);

        // Add employees to department
        dept.addEmployee(e1);
        dept.addEmployee(e2);

        // Save department → employees saved automatically because of CascadeType.ALL
        em.persist(dept);

        em.getTransaction().commit();

        // Fetch department and see its employees
        Department fetchedDept = em.find(Department.class, dept.getId());
        System.out.println("Department: " + fetchedDept.getName());
        fetchedDept.getEmployees().forEach(emp -> 
            System.out.println(emp.getName() + " - " + emp.getDesignation())
        );

        em.close();
        emf.close();
    }
}
