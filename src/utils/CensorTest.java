package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CensorTest {
    @Before
    public void setup(){
        Censor.initListProvinces();
    }

    @Test
    public void checkCCCD() {
        assertTrue(Censor.checkCCCD("083204000420"));
        assertFalse(Censor.checkCCCD("076204938563"));
        assertFalse(Censor.checkCCCD("176204938563"));
    }

    @After
    public void endTest(){
        System.out.println("Test is ended!");
    }
}