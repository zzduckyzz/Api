package com.example.api.service;

import com.example.api.dao.CustomerRepository;
import com.example.api.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int cusId) {
        return customerRepository.getById(cusId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int cusId) {customerRepository.deleteById(cusId);

    }
}
