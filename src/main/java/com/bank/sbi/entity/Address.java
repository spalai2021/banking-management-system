package com.bank.sbi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "house_no")
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
    @Column(name = "pin_code")
    private String pinCode;
}
