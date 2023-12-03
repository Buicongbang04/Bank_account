package models.accountDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    public SavingsAccount account_1;
    public SavingsAccount account_2;


    @Before
    public void setup(){
        account_1 = new SavingsAccount("123456", 500_000_000);
        account_2 = new SavingsAccount("234567", 6_000_000);
    }

    @Test
    public void withdraw() {
        assertEquals(false, account_1.withdraw(40_000));
        assertEquals(true, account_1.withdraw(60_000));
        assertEquals(false, account_1.withdraw(499_960_000));

        assertEquals(false, account_2.withdraw(40_000));
        assertEquals(false, account_2.withdraw(5_100_000));
        assertEquals(false, account_2.withdraw(40_100));
    }

    @Test
    public void isAccepted() {
        assertEquals(false, account_1.isAccepted(40_000));
        assertEquals(true, account_1.isAccepted(60_000));
        assertEquals(true, account_1.isAccepted(6_000_000));
        assertEquals(false, account_1.isAccepted(499_960_000));

        assertEquals(false, account_2.isAccepted(40_000));
        assertEquals(false, account_2.isAccepted(5_100_000));
        assertEquals(false, account_2.isAccepted(40_100));
    }

    @After
    public void endTest(){
        System.out.println("Test is ended!");
    }
}