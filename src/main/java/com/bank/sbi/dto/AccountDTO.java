package com.bank.sbi.dto;

import com.bank.sbi.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private String branchCode;
    private String accountStatus;
    private LocalDate openedDate;
    private Customer customer;
}
