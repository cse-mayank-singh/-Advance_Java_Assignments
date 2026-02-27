package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveTypeId;

    private String leaveName;
    private int maxDaysAllowed;

    @OneToMany(mappedBy = "leaveType")
    private List<LeaveRequest> leaveRequests;
}