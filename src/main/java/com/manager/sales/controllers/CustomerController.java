package com.manager.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.sales.entities.Customer;
import com.manager.sales.repositories.CustomerRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/new")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create-customer";
    }

    @PostMapping("/save")
	public String saveCustomer(@Valid Customer customer, BindingResult result, 
        RedirectAttributes attributes) {
            if (result.hasErrors()) {
                return "/create-customer";
            }	
            customerRepository.save(customer);
            attributes.addFlashAttribute("message", "Customer saved successfully!");
            return "redirect:/customer/new";
	}

}
