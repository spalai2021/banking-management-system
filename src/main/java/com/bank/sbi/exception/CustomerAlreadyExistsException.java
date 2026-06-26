package com.bank.sbi.exception;

public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String msg){
        super(msg);
    }
}
