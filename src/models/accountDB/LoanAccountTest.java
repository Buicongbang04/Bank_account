package models.accountDB;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static org.junit.Assert.*;

public class LoanAccountTest {
    public LoanAccount account;

    @Before
    public void setup(){
        account = new LoanAccount("123456", LoanAccount.LOAN_ACCOUNT_MAX_BALANCE);

        System.out.println("Running test...");
    }

    @Test
    public void withdraw() throws Exception {
        assertTrue(account.withdraw(40_000));
        assertTrue(account.withdraw(5_950_000));
        assertFalse(account.withdraw(99_960_000));

    }

    @Test
    public void isAccepted() throws Exception{
        assertTrue(account.isAccepted(40_000));
        assertTrue(account.isAccepted(5_000_000));
        assertFalse(account.isAccepted(99_960_000));
    }

    @Test
    public void getFee(){
        assertEquals(60_000, account.getFee(6_000_000, true),0);
        assertEquals(300_000, account.getFee(6_000_000, false),0);
    }

    @After
    public void endTest(){
        System.out.println("Test is ended!");
    }

}