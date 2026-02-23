package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) {
        User user = new User(101, "John", "Punjab");
        model.addAttribute("user", user);
        return "home";
    }
    @GetMapping("/info")
    public String info() {
        return "info";
    }
}