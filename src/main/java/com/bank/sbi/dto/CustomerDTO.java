package com.bank.sbi.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private LocalDate dateOfBirth;
    private String panNumber;
    private String aadhaarNumber;
}
