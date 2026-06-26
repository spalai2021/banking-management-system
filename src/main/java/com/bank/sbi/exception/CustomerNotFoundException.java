package com.bank.sbi.exception;

public class CustomerNotFoundException extends RuntimeException{

   public CustomerNotFoundException(String message){
        super(message);
    }
}
