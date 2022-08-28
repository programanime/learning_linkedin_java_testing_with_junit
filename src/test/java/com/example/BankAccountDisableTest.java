package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDisableTest {

    @Test    
    @Disabled("temporarily disable")
    public void testWithdrow(BankAccount account){
        assertTrue(account.isActive());
    }
}
