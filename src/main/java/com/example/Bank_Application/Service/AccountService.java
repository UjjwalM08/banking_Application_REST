package com.example.Bank_Application.Service;

import com.example.Bank_Application.Dto.AccountDto;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);
    void deleteAccount(Long id);

    List<AccountDto> getAllAccounts();

}
