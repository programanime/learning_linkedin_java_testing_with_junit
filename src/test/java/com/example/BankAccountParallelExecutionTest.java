package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {
    @Test    
    public void testWithdrow(BankAccount account){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace(); 
        }
        account.deposit(5000);
        assertEquals(5000,account.getBalance());
    }

    @Test    
    public void testWithdrow2(BankAccount account){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace(); 
        }
        account.deposit(5000);
        assertEquals(5000,account.getBalance());
    }

    @Test    
    public void testWithdrow3(BankAccount account){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace(); 
        }
        account.deposit(5000);
        assertEquals(5000,account.getBalance());
    }
}
