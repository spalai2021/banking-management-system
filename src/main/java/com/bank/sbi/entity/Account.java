package com.bank.sbi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Setter
@Getter
@Table(name="account")
public class Account {

    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    private BigDecimal balance;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "account_status")
    private String accountStatus;

    @Column(name = "opened_date")
    private LocalDate openedDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
