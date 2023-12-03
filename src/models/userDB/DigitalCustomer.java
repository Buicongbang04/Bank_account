package models.userDB;

import models.accountDB.Account;
import models.accountDB.LoanAccount;
import models.accountDB.SavingsAccount;
import utils.Censor;

public class DigitalCustomer extends Customer{

    public DigitalCustomer(String name, String customerId) {
        super(name, customerId);
    }

    /*
    *Hàm này kiểm tra nếu accountNumber có tồn tại thì truy xuất
    * đối tượng đó ra và gọi hàm withdraw của đối tượng đó.
    */
     public void withdraw(String accountNumber, double amount){
         String className = "";
         for(Account account : accountList){
             if(Censor.isDup(accountNumber, account.getAccountNumber())){
                 if(account.getClass().getSimpleName().equals("LoanAccount")){
                     ((LoanAccount) account).withdraw(amount);
                     break;
                 }
                 ((SavingsAccount) account).withdraw(amount);
             }
         }
    }
}
