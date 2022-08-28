package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestableCodeTest {
    TestableCode tc;
    @BeforeEach
    public void prepareEachTest(){
        tc = new TestableCode();
    }
    
    @Test    
    public void testGreetUser(){
        assertTrue(tc.greetUser("Zach").contains("VIP"));
    }

    @Test    
    public void testGreetDay(){
        assertTrue(() -> {
            return tc.greetDay(
                LocalDateTime.of(2022, 8, 27, 22, 2)
            ).toLowerCase().contains("evening");
        });
    }

    @AfterEach
    public void cleanEachTest(){
        tc = null;
    }
}
