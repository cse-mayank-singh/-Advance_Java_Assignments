package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeService {
	public EmployeeRepository empRepo;
	public EmployeeService(EmployeeRepository empRepo) {
		this.empRepo=empRepo;
	}
	public List<Employee> getAllEmp(){
		return empRepo.findAll();
	}
	public void saveEmployees(Employee emp) {
		empRepo.save(emp);
	}
}

