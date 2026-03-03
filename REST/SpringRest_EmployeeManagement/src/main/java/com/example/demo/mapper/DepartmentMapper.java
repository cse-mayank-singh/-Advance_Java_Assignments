package com.example.demo.mapper;
import com.example.demo.dto.request.DepartmentRequestDTO;
import com.example.demo.dto.response.DepartmentResponseDTO;
import com.example.demo.entity.Department;
import org.springframework.stereotype.Component;
@Component
public class DepartmentMapper {
    public Department toEntity(DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setLocation(dto.getLocation());
        return department;
    }
    public DepartmentResponseDTO toResponse(Department department) {
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setLocation(department.getLocation());
        return dto;
    }
}