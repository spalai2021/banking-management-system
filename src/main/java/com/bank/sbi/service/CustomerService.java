package com.bank.sbi.service;

import com.bank.sbi.dto.CustomerDTO;
import com.bank.sbi.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(CustomerDTO customerDTO);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerByCustomerId(Long customerId);

    void deleteCustomer(Long customerId);

    Customer updateCustomer(CustomerDTO customerDTO);

    Optional<Customer> checkCustomerExist(Long customerId);
}
