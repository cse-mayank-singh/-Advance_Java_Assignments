package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.LeaveType;
import com.example.demo.repository.LeaveTypeRepository;
@Service
public class LeaveTypeService {
    @Autowired
    private LeaveTypeRepository repository;
    public List<LeaveType> getAllLeaveTypes() {
        return repository.findAll();
    }
    public LeaveType getLeaveTypeById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public LeaveType saveLeaveType(LeaveType leaveType) {
        return repository.save(leaveType);
    }
}
