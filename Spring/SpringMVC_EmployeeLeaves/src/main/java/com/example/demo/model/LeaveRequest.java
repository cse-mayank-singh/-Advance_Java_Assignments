package com.example.demo.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}