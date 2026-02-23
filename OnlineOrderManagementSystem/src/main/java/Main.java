import jakarta.persistence.*;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("orderPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = new Customer();
        customer.setCustomerName("Tony");
        customer.setEmail("tony@email.com");
        OrderEntity order1 = new OrderEntity();
        order1.setOrderDate(LocalDate.now());
        order1.setTotalAmount(5000);
        OrderItem item1 = new OrderItem();
        item1.setProductName("Laptop");
        item1.setQuantity(1);
        item1.setPrice(5000);
        order1.addItem(item1);
        customer.addOrder(order1);
        em.persist(customer);
        tx.commit();
        em.close();
        emf.close();
        System.out.println("Data Saved Successfully");
    }
}