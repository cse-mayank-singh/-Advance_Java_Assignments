package com.example.demo.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
@Service
public class CustomerService {

    private final CustomerRepository custRepo;

    public CustomerService(CustomerRepository custRepo) {
        this.custRepo = custRepo;
    }

    public List<Customer> getAllCustomers() {
        return custRepo.findAll();
    }

    public void saveCustomer(Customer customer) {
        custRepo.save(customer);
    }
}