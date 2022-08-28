package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
    
    @ParameterizedTest
    @ValueSource(ints = {100,400,800,1000})
    public void testWithdrowWithParameter(int amount, BankAccount account){
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value=DayOfWeek.class, names = {"SATURDAY","SUNDAY"})
    public void testWithdrowWithParameterDayOfWeek(DayOfWeek dayOfWeek){
        assertTrue(dayOfWeek.name().toLowerCase().contains("u"));
    }

    @ParameterizedTest
    @CsvSource({"100, Daniel", "200, Alejo"})
    public void testWithdrowWithParameterCsv(int amount, String holder, BankAccount account){
        account.setHolderName(holder);
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
        assertEquals(holder, account.getHolderName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/accounts.csv", numLinesToSkip = 1)
    public void testWithdrowWithParameterCsvFile(int amount, String holder, BankAccount account){
        account.setHolderName(holder);
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
        assertEquals(holder, account.getHolderName());
    }
}
