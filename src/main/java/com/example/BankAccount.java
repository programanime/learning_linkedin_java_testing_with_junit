package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    private double balance;
    private double minimumBalance;
    private boolean active;
    private String holderName;

    public double withdraw(double amount){
        if(balance - amount > minimumBalance){
            balance -= amount;
            return amount;
        }else{
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
        return balance += amount;
    }
}
