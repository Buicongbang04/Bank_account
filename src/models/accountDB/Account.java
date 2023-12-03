package models.accountDB;

import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private double balance;
    private final ArrayList<String> transactions = new ArrayList<>();
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremiumAccount(){
        return this.balance >= 10000000;
    }

    public String toString(){
        return String.format("%s" + " ".repeat(2) +"|" + " ".repeat(21) +"%.2fđ", getAccountNumber(), getBalance());
    }

    /*
     * Hàm đảm nhận việc thêm mới một thông tin giao dịch
     */
    public void addTransaction(Transaction newTransaction){
        transactions.add(newTransaction.toString());
    }
    /*
     * Hàm in ra toàn bộ lịch sử giao dịch của tài khoản
     */
    public void showHistory(){
        for(String transaction : transactions){
            System.out.println(transaction);;
        }
    }
}
