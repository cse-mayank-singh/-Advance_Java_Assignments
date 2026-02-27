package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.LeaveRequest;
import com.example.demo.repository.LeaveRequestRepository;
@Service
public class LeaveRequestService {
    @Autowired
    private LeaveRequestRepository repository;
    public LeaveRequest applyLeave(LeaveRequest request) {
        request.setStatus("Pending");
        return repository.save(request);
    }
    public void approveLeave(Long id) {
        LeaveRequest request = repository.findById(id).get();
        request.setStatus("Approved");
        repository.save(request);
    }
    public void rejectLeave(Long id) {
        LeaveRequest request = repository.findById(id).get();
        request.setStatus("Rejected");
        repository.save(request);
    }
}