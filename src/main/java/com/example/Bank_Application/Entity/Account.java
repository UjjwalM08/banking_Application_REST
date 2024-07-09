package com.example.Bank_Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts")

@Entity
public class Account {
    @Id
    private Long id;

    @Column(name="account_holder_name")
    private String accountHolderName;

    @Column(name="balance")
    private double balance;

}
