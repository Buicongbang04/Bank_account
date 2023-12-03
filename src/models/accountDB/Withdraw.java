package models.accountDB;

public interface Withdraw {
    boolean withdraw(double amount);

    boolean isAccepted(double amount);
}
