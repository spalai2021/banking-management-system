package com.bank.sbi.service;

import com.bank.sbi.dto.CustomerDTO;
import com.bank.sbi.entity.Customer;

public interface CustomerService {
    Customer createCustomer(CustomerDTO customerDTO);
}
