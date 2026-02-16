import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("manyToManyPU");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Create Roles
        Role admin = new Role("ADMIN");
        Role userRole = new Role("USER");

        em.persist(admin);
        em.persist(userRole);

        // Create Users
        User u1 = new User("Tony", "tony@mail.com");
        User u2 = new User("Steve", "steve@mail.com");

        // Assign roles
        u1.addRole(admin);
        u1.addRole(userRole);
        u2.addRole(userRole);

        em.persist(u1);
        em.persist(u2);

        tx.commit();

        System.out.println("===== Data Saved =====");

        // Fetch and display
        User fetched = em.find(User.class, u1.getUserId());

        System.out.println("User: " + fetched.getUsername());
        fetched.getRoles().forEach(r ->
                System.out.println("Role: " + r.getRoleName())
        );

        em.close();
        emf.close();
    }
}
