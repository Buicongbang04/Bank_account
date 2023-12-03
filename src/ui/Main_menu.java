package ui;

import models.accountDB.Account;
import models.accountDB.LoanAccount;
import models.accountDB.SavingsAccount;
import models.accountDB.Transaction;
import models.bankDB.DigitalBank;
import models.userDB.Customer;
import models.userDB.DigitalCustomer;
import program.Main;
import utils.Inputter;
import constants.Enum.MAIN_MENU;

import java.util.List;

public class Main_menu {
    DigitalBank bank = Main.bank;
    Transaction transaction = new Transaction();
    private void printValue(String value){
        System.out.println("| " + value + " ".repeat(41 - value.length()) + "|");
    }

    /*
     * Hàm printMenu in ra màn hình các lựa chọn có trong menu
     */
    public void printMenu(String author, String version) {
        System.out.println("+----------+--------------------+----------+");
        System.out.printf("| NGÂN HÀNG SỐ | %s@%s" + " ".repeat(25 - author.length() - version.length()) + "|\n",
                author, version);
        System.out.println("+----------+--------------------+----------+");
        for(MAIN_MENU menu: MAIN_MENU.values()) {
            printValue(String.valueOf(menu.ordinal()) + ". to " + menu.name().replace("_", " ").toLowerCase());
        }
        System.out.println("+----------+--------------------+----------+");
    }

    /*
     * Hàm cho người dùng nhập lựa chọn
     */
    public int getChoiceFromUser(){
        while(true){
            try{
                int choice = Inputter.getInteger("Enter your choice: ");
                return MAIN_MENU.values()[choice].ordinal();
            }catch(Exception e){
                System.out.println("Invalid choice! Please enter a valid number.");
            }
        }
    }

    /*
     * Hàm thực thi chức năng người dùng chọn
     */
    public boolean handleUserChoice(int userChoice){
        boolean status = true;

        switch (userChoice) {
            case 5 -> {
                System.out.println("Thanks you for using...");
                status = false;
            }
            case 0 -> {
                System.out.println("Processing...");
                handleShowCustomer();
                System.out.println("Done.\n");
            }
            case 1 -> {
                System.out.println("Processing...");
                handleAddLoansAccount();
                System.out.println("Done.\n");
            }
            case 2 -> {
                System.out.println("Processing...");
                handleAddSavingsAccount();
                System.out.println("Done.\n");
            }
            case 3 -> {
                System.out.println("Processing...");
                handleWithDraw();
                System.out.println("Done.\n");
            }
            case 4 -> {
                System.out.println("Processing...");
                handleHistoryTransaction();
                System.out.println("Done.\n");
            }
        }
        return status;
    }

    /*
     * In ra thông tin người dùng, thông tin tài khoản
     * các tài khoản hiện có và số dư
     */
    public void handleShowCustomer(){
        try{
            List<DigitalCustomer> customers = bank.getCustomers();
            if(customers.size() == 0){
                throw new Exception("There is no customer!");
            }
            for(DigitalCustomer customer : customers){
                customer.displayInformation();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Hàm thêm một tài khoản ngân hàng
     */
    public void handleAddSavingsAccount(){
        String accountNumber;
        double balance;
        while(true) {
            try {
                accountNumber = Inputter.getString("Enter account number:\nEx: 123456", "^\\d{6}$");
                if (bank.checkAccountID(accountNumber)) {
                    throw new Exception("This account number is already exist!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                balance = Inputter.getDouble("Enter your balance: ");
                if(balance < 50_000){
                    throw new Exception("Balance must be greater than 50,000VNĐ!");
                }
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        SavingsAccount newAccount = new SavingsAccount(accountNumber, balance);

        if(bank.addAccount(Main.CUSTOMER_ID, newAccount)){
            System.out.println("Add new account successfully!");
        }
    }

    /*
     * Hàm thêm một tài khoản tín dụng
     */
    public void handleAddLoansAccount(){
        String accountNumber;
        double balance;
        while(true) {
            try {
                accountNumber = Inputter.getString("Enter account number:\nEx: 123456", "^\\d{6}$");
                if (bank.checkAccountID(accountNumber)) {
                    throw new Exception("This account number is already exist!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        LoanAccount newAccount = new LoanAccount(accountNumber, LoanAccount.LOAN_ACCOUNT_MAX_BALANCE);

        if(bank.addAccount(Main.CUSTOMER_ID, newAccount)){
            System.out.println("Add new account successfully!");
        }
    }


    /*
     * Hàm thực hiện rút tiền từ tài khoản
     */
    public void handleWithDraw(){
        try{
            String accountNumber = Inputter.getString("Enter account number:\nEx: 123456", "^\\d{6}$");
            if (!bank.checkAccountID(accountNumber)) {
                throw new Exception("This account number is not exist!");
            }
            double amount = Inputter.getDouble("Enter a double: ");
            bank.withdraw(Main.CUSTOMER_ID, accountNumber, amount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /*
     * Hàm in ra thông tin giao dịch của khách hàng
     */
    public void handleHistoryTransaction(){
        for(Customer customer: bank.getCustomers()){
            customer.displayInformation();
            System.out.println();
            System.out.printf("%10s%2s |%11s%5s |%12s%8s |%26s%11s |%16s%9s%n",
                    "Account"," ", "Amount"," ", "Time", " ", "Transaction ID", " ", "Status", " ");
            System.out.println("-".repeat(120));
            for(Account account: customer.getAccountsList()){
                account.showHistory();
            }
            System.out.println("\n");
        }
    }
}
