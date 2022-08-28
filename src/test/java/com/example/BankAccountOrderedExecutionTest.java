package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class BankAccountOrderedExecutionTest {
    static BankAccount account = new BankAccount(0, 0, true, "daniel");

    @Test
    @Order(1)
    public void testDeposit(){
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    @Order(2)
    public void testWithdraw(){
        account.withdraw(200);
        assertEquals(300, account.getBalance());
    }
}
