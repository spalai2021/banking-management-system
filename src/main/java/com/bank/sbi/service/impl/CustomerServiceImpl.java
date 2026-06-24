package com.bank.sbi.service.impl;

import com.bank.sbi.dto.CustomerDTO;
import com.bank.sbi.entity.Customer;
import com.bank.sbi.repository.CustomerRepository;
import com.bank.sbi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobile(customerDTO.getMobile());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setPanNumber(customerDTO.getPanNumber());
        customer.setAadhaarNumber(customerDTO.getAadhaarNumber());
        customerRepository.save(customer);
        return customer;
    }
}
