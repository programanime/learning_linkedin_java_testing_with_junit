package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CodeTest 
{
    @Test
    public void testSayHello(){
        Code code = new Code();
        assertEquals("hi world", code.sayHello());
    }
}
