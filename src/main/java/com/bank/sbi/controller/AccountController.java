package com.bank.sbi.controller;

import com.bank.sbi.dto.AccountDTO;
import com.bank.sbi.entity.Account;
import com.bank.sbi.entity.Customer;
import com.bank.sbi.service.AccountService;
import com.bank.sbi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("account-service")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("account/{mobileNo}")
    public ResponseEntity<?> createAccount(@PathVariable Long mobileNo , @RequestBody AccountDTO accountDTO){
        Optional<Customer> customer = customerService.checkExistingCustomer(mobileNo);
        if(customer.isPresent()){
            Customer existingCustomer = customer.get();
            accountDTO.setCustomer(existingCustomer);
            Account account = accountService.createAccount(accountDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(account);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("You are the new Customer. May i Help You!");
    }
}
