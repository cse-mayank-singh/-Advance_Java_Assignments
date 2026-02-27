package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.LeaveType;
import com.example.demo.service.LeaveTypeService;
import ch.qos.logback.core.model.Model;
@Controller
@RequestMapping("/leave-types")
public class LeaveTypeController {
    @Autowired
    private LeaveTypeService service;
    @GetMapping
    public String viewLeaveTypes(Model model) {
        model.addAttribute("leaveTypes", service.getAllLeaveTypes());
        return "leave-type-list";
    }
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("leaveType", new LeaveType());
        return "leave-type-form";
    }
    @PostMapping("/save")
    public String saveLeaveType(@ModelAttribute LeaveType leaveType) {
        service.saveLeaveType(leaveType);
        return "redirect:/leave-types";
    }
}