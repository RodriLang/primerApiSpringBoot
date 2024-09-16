package com.example.clientes.controllers;

import com.example.clientes.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1,"Rodrigo", "rodriLang","1234"),
            new Customer(2,"Sofia", "sofiSil","4321"),
            new Customer(3,"Benicio", "beni25","1111"),
            new Customer(4,"Claudia", "clau65","4444")));

    @GetMapping
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping(value = "/{username}")
    public Customer getCustomer(@PathVariable String username)
    {
        for(Customer customer :customers)
        {
            if(customer.getUsername().equalsIgnoreCase(username))
            {
                return customer;
            }
        }
        return null;
    }

    @PostMapping
    public Customer postCliente (@RequestBody Customer customer)
    {
        customers.add(customer);
        return customer;
    }
}
