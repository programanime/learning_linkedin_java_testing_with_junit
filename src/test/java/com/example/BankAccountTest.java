package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
@DisplayName("test for deposit and withdraw from bank account")
public class BankAccountTest {
    @Test    
    public void testWithdrow(){
        BankAccount account = new BankAccount(100, 0, false, "daniel");
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test    
    @DisplayName("test deposit with something")
    public void testDeposit(){
        BankAccount account = new BankAccount(1000, 100, false, "daniel yepes");
        account.deposit(1000);
        assertEquals(2000, account.getBalance());
    }

    @Test    
    @DisplayName("withdraw become negative")
    public void testWithdrowNotStuckAtZero(){
        BankAccount account = new BankAccount(500, -1000, true, "daniel molina");
        account.withdraw(800);
        assertNotEquals(0, account.getBalance());
    }

    @Test    
    public void testActive(){
        BankAccount account = new BankAccount(500, 10, true, "daniel molina");
        assertTrue(account.isActive());
    }

    @Test    
    public void testHolderName(){
        BankAccount account = new BankAccount(500, 10, true, "daniel molina");
        account.setHolderName("alejo");
        assertNotNull(account.getHolderName());
    }
    

    @Test    
    public void testWithdrawNotBelowTheMinimum(){
        BankAccount account = new BankAccount(500, 10, true, "daniel molina");
        assertThrows(RuntimeException.class, () -> {
            account.withdraw(600);
        });
    }

    @Test    
    @DisplayName("test if is null")
    public void testNull(){
        assertNull(null, "it is null");
    }

    @Test    
    public void testCorrectFlow(){
        Executable assert1 = () -> {
            assertEquals(4, 2 * 2, "4 is 2 times 2");
        };

        Executable assert2 = () -> {
            assertEquals(4, 2 * 2, "4 is 2 times 2");
        };

        Executable assert3 = () -> {
            assertEquals(4, 2 * 2, "4 is 2 times 2");
        };

        assertAll(assert1,assert2, assert3);
    }

    @Test    
    public void testBankAccountFlow(){
        BankAccount account =   new BankAccount(500, 10, true, "daniel molina");
        assertAll(
            () -> account.deposit(100),
            () -> account.withdraw(50),
            () -> account.deposit(100),
            () -> account.withdraw(100)
        );
    }

    @Test    
    public void testTimeout(){
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
        });
    }

    @Test    
    public void testDelta(){
        assertEquals(0.33, 1/3, 0.5);
    }

    @Test    
    public void testFail(){
        // fail("something wrong");
    }

    @Test
    public void testAssumeTrue(){
        assumeTrue(true);
        assertEquals(4, 2 * 2);
    }

    @Test    
    public void testAssumeFalse(){
        assumeFalse(true);
        assertEquals(1, 1);
    }

    @Test    
    public void testAssumeThat(){
        assumingThat(false, () -> {
            assertEquals(1, 6);    
        });
        assertEquals(1, 1);
    }
}

