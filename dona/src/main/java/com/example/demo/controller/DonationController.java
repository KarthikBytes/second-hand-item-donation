package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonationController {

    // Home page (index)
    @GetMapping("/")
    public String index(Model model) {
        return "index"; // The index.html page
    }

    // Sign up page
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // The signup.html page
    }

    // Sign in page
    @GetMapping("/signin")
    public String showSigninForm() {
        return "signin"; // The signin.html page
    }

    // Donation page
    @GetMapping("/donate")
    public String showDonationForm() {
        return "donate"; // The donate.html page where the form is displayed
    }
}
