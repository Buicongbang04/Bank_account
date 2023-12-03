package models.accountDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    public Account account_1;
    public Account account_2;

    @Before
    public void setup(){
        account_1 = new Account("123456", 6_000_000);
        account_2 = new Account("123456", 11_000_000);
    }

    @Test
    public void isPremiumAccount() {
        assertEquals(false, account_1.isPremiumAccount());
        assertEquals(true, account_2.isPremiumAccount());
    }

    @After
    public void endTest(){
        System.out.println("Test is ended!");
    }
}