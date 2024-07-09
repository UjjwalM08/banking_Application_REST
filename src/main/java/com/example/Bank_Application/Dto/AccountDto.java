package com.example.Bank_Application.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data    //for generate constructor,getter,setter
@AllArgsConstructor
public class AccountDto{
    private Long id;
    private String accountHolderName;
    private Double balance;
}
