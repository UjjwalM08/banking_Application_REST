package com.example.Bank_Application.Repository;

import com.example.Bank_Application.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
