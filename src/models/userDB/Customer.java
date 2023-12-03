package models.userDB;

import models.accountDB.Account;
import utils.Censor;
import utils.Formatter;

import java.util.ArrayList;
public class Customer extends User{
    public ArrayList<Account> accountList = new ArrayList<>();

    public Customer(String name, String customerId) {
        super(name, customerId);
    }

    public void getAccounts(){
        if(accountList.isEmpty()){
            System.out.println("There is no any account!");
            return;
        }

        for(Account account : accountList){
            System.out.println(account.toString());
        }
    }
    public ArrayList<Account> getAccountsList(){
        return accountList;
    }

    /*
    * Hàm kiểm tra tài khoản người dùng có đủ điều kiện Premium
    * có thì trả về true, khôn thì trả về false
    */
    public boolean isPremiumAccount(){
        for(Account account : accountList){
            if(account.isPremiumAccount()){
                return true;
            }
        }
        return false;
    }

    /*
    * Hàm thêm một tài khoản mới cho người dùng.
    * Kiểm tra nếu số tài khoản chưa tồn tại mới được thêm
    * Thêm thành công thì trả về true, không thì trả về false
    */
    public boolean addAccount(Account newAccount){
        for(Account account : accountList){
            if(Censor.isDup(account.getAccountNumber(), newAccount.getAccountNumber())){
                return false;
            }
        }

        accountList.add(newAccount);
        return true;
    }

    /*
    * Hàm in ra thông tin người dùng và thông tin tài khoản của từng người
    */
    public void displayInformation(){
        System.out.printf("%s|\t%s|\t%s|%16s\n", super.getCustomerId(), super.getName(),
                isPremiumAccount() ? "Premium" : "Normal", Formatter.formatNumber(getBalance()));

        for(int i = 0; i < accountList.size(); i++){
            System.out.println((i + 1) + "\t" + accountList.get(i).toString());
        }
    }

    /*
    * Hàm tính tổng tiền có trong tài khoản và trả về số tiền đó
    */
    public double getBalance(){
        int i = 0;
        double totalBalance = 0;
        while(i < accountList.size()){
            totalBalance += accountList.get(i).getBalance();
            i++;
        }
        return totalBalance;
    }

    public void showHistory(){
        for(Account account : accountList){
            account.showHistory();
        }
    }


}
