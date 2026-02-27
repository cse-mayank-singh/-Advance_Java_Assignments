package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.LeaveRequest;
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
	List<LeaveRequest> findByEmployeeEmployeeId(Long id);
}