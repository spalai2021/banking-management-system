package com.bank.sbi.service.impl;

import com.bank.sbi.dto.CustomerDTO;
import com.bank.sbi.entity.Address;
import com.bank.sbi.entity.Customer;
import com.bank.sbi.repository.CustomerRepository;
import com.bank.sbi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Address address = new Address();
        address.setAddressId(customerDTO.getAddress().getAddressId());
        address.setCity(customerDTO.getAddress().getCity());
        address.setCountry(customerDTO.getAddress().getCountry());
        address.setHouseNo(customerDTO.getAddress().getHouseNo());
        address.setPinCode(customerDTO.getAddress().getPinCode());
        address.setState(customerDTO.getAddress().getState());
        address.setStreet(customerDTO.getAddress().getStreet());
        customer.setAddress(address);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerByCustomerId(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobile(customerDTO.getMobile());
        Address address = new Address();
        address.setAddressId(customerDTO.getAddress().getAddressId());
        address.setCity(customerDTO.getAddress().getCity());
        address.setCountry(customerDTO.getAddress().getCountry());
        address.setHouseNo(customerDTO.getAddress().getHouseNo());
        address.setPinCode(customerDTO.getAddress().getPinCode());
        address.setState(customerDTO.getAddress().getState());
        address.setStreet(customerDTO.getAddress().getStreet());
        customer.setAddress(address);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Optional<Customer> checkCustomerExist(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Optional<Customer> checkExistingCustomer(Long mobileNo) {
        return  customerRepository.findByMobile(mobileNo);
    }
}
