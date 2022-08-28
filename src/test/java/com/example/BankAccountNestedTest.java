package com.example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(value = 10, unit = TimeUnit.SECONDS)
public class BankAccountNestedTest {
    @Test    
    public void testWithdrow(){
        BankAccount account = new BankAccount(300, 0, true, "alejo");
        account.withdraw(200);
        assertEquals(100, account.getBalance());
    }

    @Test    
    public void testDeposit(){
        BankAccount account = new BankAccount(0, 0, true, "daniel");
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero {
        @Test
        public void testWithdrawMinimumBalanceIs(){
            BankAccount account = new BankAccount(10, 0, true, "daniel");
            account.withdraw(1);
            assertEquals(9, account.getBalance());
            assertThrows(RuntimeException.class, () -> {
                account.withdraw(5000);
            });
        }

        @Test
        public void testWithdrawMinimumBalanceNegative(){
            BankAccount account = new BankAccount(0, -1000, true, "daniel");
            account.withdraw(1);
            assertEquals(-1, account.getBalance());
            assertThrows(RuntimeException.class, () -> {
                account.withdraw(5000);
            });
        }
    }
}
