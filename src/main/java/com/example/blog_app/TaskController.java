package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TaskController {
    @GetMapping("/tasks")
    public String tasks() {
        return "tasks";
    }

    
}
