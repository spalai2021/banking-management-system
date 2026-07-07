package com.bank.sbi.service.impl;

import com.bank.sbi.dto.AccountDTO;
import com.bank.sbi.entity.Account;
import com.bank.sbi.repository.AccountRepository;
import com.bank.sbi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setAccountStatus(accountDTO.getAccountStatus());
        account.setBalance(accountDTO.getBalance());
        account.setOpenedDate(accountDTO.getOpenedDate());
        account.setAccountType(accountDTO.getAccountType());
        account.setCustomer(accountDTO.getCustomer());
        accountRepository.save(account);
        return account;
    }

    @Override
    public Optional<Account> getAccountDetailsByAccountNo(Long accountNo) {
        Optional<Account> account = accountRepository.findById(accountNo);
        return account;
    }

    public String generateAccountNumber() {
        Random random = new Random();
        Long number = 100000000000L +
                (long)(random.nextDouble() * 900000000000L);

        return String.valueOf(number);
    }
}
