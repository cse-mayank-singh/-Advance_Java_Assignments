package com.example.demo.controller;
import com.example.demo.dto.request.DepartmentRequestDTO;
import com.example.demo.dto.response.DepartmentResponseDTO;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    public DepartmentResponseDTO createDepartment(
            @Valid @RequestBody DepartmentRequestDTO request) {
        return departmentService.createDepartment(request);
    }
    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }
}