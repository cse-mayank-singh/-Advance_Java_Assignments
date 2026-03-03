package com.example.demo.mapper;
import com.example.demo.dto.request.EmployeeRequestDTO;
import com.example.demo.dto.response.EmployeeResponseDTO;
import com.example.demo.dto.response.DepartmentResponseDTO;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;
@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequestDTO dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());
        return employee;
    }
    public EmployeeResponseDTO toResponse(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
        DepartmentResponseDTO departmentDTO = new DepartmentResponseDTO();
        departmentDTO.setId(employee.getDepartment().getId());
        departmentDTO.setName(employee.getDepartment().getName());
        departmentDTO.setLocation(employee.getDepartment().getLocation());
        dto.setDepartment(departmentDTO);
        return dto;
    }
}