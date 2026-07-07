package com.bank.sbi.service;

import com.bank.sbi.dto.AccountDTO;
import com.bank.sbi.entity.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {
    Account createAccount(AccountDTO accountDTO);

    Optional<Account> getAccountDetailsByAccountNo(Long mobileNo);
}
