package com.example.demo.service;
import com.example.demo.dto.request.DepartmentRequestDTO;
import com.example.demo.dto.response.DepartmentResponseDTO;
import java.util.List;

public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO request);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(Long id);
}