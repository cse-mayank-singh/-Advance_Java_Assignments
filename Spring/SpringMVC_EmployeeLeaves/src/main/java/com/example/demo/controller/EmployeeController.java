package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping
    public String viewEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "employee-list";
    }
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/employees";
    }
}