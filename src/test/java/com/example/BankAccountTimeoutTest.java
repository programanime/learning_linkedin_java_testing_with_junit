package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {
    @Test    
    @Timeout(value = 10, unit = TimeUnit.SECONDS) 
    public void testWithdrowTimeout(BankAccount account){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace(); 
        }
        account.deposit(300);
        assertEquals(300, account.getBalance());
    }

    @Test
    public void testDepositTimeoutAnnotation(BankAccount account){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace(); 
        }
        account.deposit(300);
        assertEquals(300, account.getBalance());        
    }

    @Test    
    public void testTimeout(){
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
        });
    }
}
