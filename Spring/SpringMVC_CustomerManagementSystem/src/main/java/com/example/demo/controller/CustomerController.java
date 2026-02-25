package com.example.demo.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
@Controller
public class CustomerController {

    private final CustomerService custService;

    public CustomerController(CustomerService custService) {
        this.custService = custService;
    }

    @GetMapping("/addCustomer")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @GetMapping("/saveCustomer")
    public String saveCustomer(Customer customer) {
        custService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = custService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer-list";
    }
}