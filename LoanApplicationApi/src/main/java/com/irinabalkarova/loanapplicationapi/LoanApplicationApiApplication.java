package com.irinabalkarova.loanapplicationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class LoanApplicationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApplicationApiApplication.class, args);
    }

}
