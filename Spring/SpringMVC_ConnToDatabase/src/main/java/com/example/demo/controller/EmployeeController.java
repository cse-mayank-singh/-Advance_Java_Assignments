package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.ui.Model;

@Controller
public class EmployeeController {
	public EmployeeService empSer;

	public EmployeeController(EmployeeService empSer) {
		this.empSer = empSer;
	}
	@GetMapping("/employees")
	public String getEmpDetails(Model model) {
		List<Employee> emplist=empSer.getAllEmp();
		model.addAttribute("employees",emplist);
		return "employee";
	}
	@GetMapping("/employeesmodelandview")
	public ModelAndView getEmpDetails() {
		List<Employee> emplist=empSer.getAllEmp();
		ModelAndView mv=new ModelAndView();
		mv.addObject("employees",emplist);
		mv.setViewName("employee");
		return mv;
	}
	@GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee emp) {
        empSer.saveEmployees(emp);
        return "redirect:/employees";
    }
}
