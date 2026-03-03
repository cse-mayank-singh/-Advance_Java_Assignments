package com.example.demo.service;
import com.example.demo.dto.request.EmployeeRequestDTO;
import com.example.demo.dto.response.EmployeeResponseDTO;
import org.springframework.data.domain.Page;
public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);
    Page<EmployeeResponseDTO> getAllEmployees(
            String department,
            Double minSalary,
            Double maxSalary,
            int page,
            int size,
            String sortBy,
            String direction
    );
    EmployeeResponseDTO getEmployeeById(Long id);
    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request);
    void deleteEmployee(Long id);
}