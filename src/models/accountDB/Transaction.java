package models.accountDB;

import utils.Formatter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Transaction {
    private String id;
    private String accountNumber;
    private double amount;
    private LocalDateTime time;
    private boolean status;


    public Transaction() {
    }

    public Transaction(String accountNumber, double amount, LocalDateTime time, boolean status) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.time = time;
        this.status = status;
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    @Override
    public String toString(){
        String withdraw = String.format("-%s", Formatter.formatNumber(amount));
        String str = String.format("[GD]  %s | %15s | %s | %s | ",
                                    accountNumber, withdraw, Formatter.formatDateTime(time), id);
        if(status){
            str += ("Transaction successfully!");
        }else {
            str += ("Transaction failed!");
        }
        return str;
    }
}
