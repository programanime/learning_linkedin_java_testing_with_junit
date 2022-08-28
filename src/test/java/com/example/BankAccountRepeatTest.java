package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatTest {
    @RepeatedTest(5)
    public void testWithdrow(BankAccount account){
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @RepeatedTest(5)
    public void testWithdrowWithInfo(BankAccount account, RepetitionInfo repetitionInfo){
        account.deposit(100 * repetitionInfo.getCurrentRepetition());
        assertEquals(100 * repetitionInfo.getCurrentRepetition(), account.getBalance());
    }
}
