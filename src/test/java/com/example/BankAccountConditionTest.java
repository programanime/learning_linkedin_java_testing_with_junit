package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BankAccountConditionTest {
    @Test
    @EnabledOnOs({OS.MAC})
    public void testMac(){
        assertEquals(1, 1);
    }

    @Test
    @DisabledOnOs({OS.MAC})
    public void testIfNotMac(){
        assertEquals(1, 1);
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testWindows(){
        assertEquals(1, 1);
    }

    @Test
    @EnabledOnOs({OS.LINUX})
    public void testLinux(){
        assertEquals(1, 1);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8 , max = JRE.JAVA_10)
    public void testJRE(){
        System.out.println("run the jre test");
        assertEquals(1, 1);
    }
    
    @Test
    @EnabledIfEnvironmentVariable(named = "PROCESSOR_IDENTIFIER", matches = ".*Intel64.*")
    public void testIfEnvironment(){
        assertEquals(1, 1);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROCESSOR_IDENTIFIER", matches = ".*Intel64.*")
    public void testIfNotEnvironment(){
        assertEquals(1, 1);
    }

    @Test   
    @EnabledIfSystemProperty(named = "user.name", matches = "dani") 
    public void testIfSystem(){
        assertEquals(1, 1);
    }
}
