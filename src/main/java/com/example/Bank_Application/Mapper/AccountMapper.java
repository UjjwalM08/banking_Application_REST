package com.example.Bank_Application.Mapper;

import com.example.Bank_Application.Dto.AccountDto;
import com.example.Bank_Application.Entity.Account;

public class AccountMapper {
    //Mapper class used converting jpa entity to dta and vice versa
    public static Account mapToAccount(AccountDto accountDto){
        Account account =new Account(
        accountDto.getId(),
        accountDto.getAccountHolderName(),
        accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
        account.getId(),
        account.getAccountHolderName(),
        account.getBalance()
        );
        return accountDto;
    }
}
