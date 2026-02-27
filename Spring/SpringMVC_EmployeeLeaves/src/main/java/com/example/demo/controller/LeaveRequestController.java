package com.example.demo.controller;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveRequestService;
import com.example.demo.service.LeaveTypeService;
import ch.qos.logback.core.model.Model;
@Controller
@RequestMapping("/leave-requests")
public class LeaveRequestController {
    @Autowired
    private LeaveRequestService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveTypeService leaveTypeService;
    @GetMapping
    public String viewRequests(Model model) {
        model.addAttribute("requests", service.getAllRequests());
        return "leave-request-list";
    }
    @GetMapping("/apply")
    public String showApplyForm(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());
        return "leave-apply-form";
    }
    @PostMapping("/apply")
    public String applyLeave(@RequestParam Long employeeId,
                             @RequestParam Long leaveTypeId,
                             @RequestParam String startDate,
                             @RequestParam String endDate) {
        service.applyLeave(employeeId,
                leaveTypeId,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate));
        return "redirect:/leave-requests";
    }
    @GetMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {
        service.updateStatus(id, "Approved");
        return "redirect:/leave-requests";
    }
    @GetMapping("/reject/{id}")
    public String reject(@PathVariable Long id) {
        service.updateStatus(id, "Rejected");
        return "redirect:/leave-requests";
    }
}