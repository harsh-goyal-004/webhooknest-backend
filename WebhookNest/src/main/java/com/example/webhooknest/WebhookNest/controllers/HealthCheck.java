package com.example.webhooknest.WebhookNest.controllers;


import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/public")
public class HealthCheck {

    @GetMapping
    public String checkHealth(){
        return "Ok";
    }
}
