package com.example.api.rest;

import com.example.api.entity.Customer;
import com.example.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        return customerService.getCustomers();
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer theCustomer = customerService.getCustomer(customerId);
        if(theCustomer == null){
            throw new CustomerNotFoundException("Customer id not found -" + customerId);
        }
        return theCustomer;
    }
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer tempCustomer = customerService.getCustomer(customerId);
        if(tempCustomer == null){
            throw new CustomerNotFoundException("not found" + customerId);
        }
        customerService.deleteCustomer(customerId);
        return "delete" + customerId;
    }

}
