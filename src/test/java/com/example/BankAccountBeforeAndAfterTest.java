package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(BankAccountParameterResolver.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountBeforeAndAfterTest {
    static BankAccount account;

    @BeforeAll
    public static void prepTest(){
        account = new BankAccount(0, 0, true, "daniel");
    }

    @BeforeEach
    public void prepareEachTest(){
        account.setBalance(100);
    }
    
    @Test
    @Order(1)
    public void testWithdrow(){
        account.withdraw(50);
        assertEquals(50d, account.getBalance());
    }

    @Test
    @Order(2)
    public void testWithdrow2(){
        account.withdraw(90);
        assertEquals(10d, account.getBalance());
    }

    @AfterEach
    public void cleanEachTest(){
        account.setBalance(0);
    }

    @AfterAll
    public static void endTest(){
        System.out.println("AfterAll!!");
    }
}
