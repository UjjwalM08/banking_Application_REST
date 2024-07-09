package com.example.Bank_Application.Impl;

import com.example.Bank_Application.Dto.AccountDto;
import com.example.Bank_Application.Entity.Account;
import com.example.Bank_Application.Mapper.AccountMapper;
import com.example.Bank_Application.Repository.AccountRepository;
import com.example.Bank_Application.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {  
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto){
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id){
       Account account= accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist with id :"+id));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =accountRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Accounts does not exists."));
         double total =account.getBalance()+amount;
         account.setBalance(total);
         Account savedAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accounts does not exists."));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account= accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist with id :"+id));
        accountRepository.delete(account);
    }


    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts =accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }
}
