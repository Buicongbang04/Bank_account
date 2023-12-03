package models.bankDB;

import models.userDB.DigitalCustomer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    public Bank bank;

    @Before
    public void setup(){
        bank = new Bank();
        bank.addCustomer(new DigitalCustomer("Bui Cong Bang", "083204000400"));
    }

    @Test
    public void isCustomerExisted() {
        assertEquals(true, bank.isCustomerExisted("083204000400"));
        assertFalse(bank.isCustomerExisted("083204000450"));
    }
    @After
    public void endTest(){
        System.out.println("Test is ended!");
    }
}