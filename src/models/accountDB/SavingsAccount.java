package models.accountDB;

import utils.Formatter;

import java.time.LocalDateTime;

public class SavingsAccount extends Account implements Report, Withdraw{
    public static final double  SAVINGS_ACCOUNT_MAX_WITHDRAW = 5_000_000;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /*
     * Hàm in ra thông tin giao dịch mà khách hàng đã thực hiện
     * nếu giao dịch được thực hiện thành công.
     */
    @Override
    public void log(double amount) {
        String date = Formatter.formatDateTime(LocalDateTime.now());
        String accountNumber = getAccountNumber();
        String amountWithDraw = Formatter.formatNumber(amount);
        String balance = Formatter.formatNumber(getBalance());

        System.out.println("+----------+--------------------+----------+");
        System.out.println(" ".repeat(11) + "BIEN LAI GIAO DICH SAVING" + " ".repeat(10));
        System.out.println("NGAY G/D:" + " ".repeat(16) + date);
        System.out.println("ATM ID:" + " ".repeat(16) + "DIGITAL-BANK-ATM 2023");
        System.out.println("SO TK:" + " ".repeat(38 - accountNumber.length()) + accountNumber);
        System.out.println("SO TIEN:" + " ".repeat(36 - amountWithDraw.length()) + amountWithDraw);
        System.out.println("SO DU:" + " ".repeat(38 - balance.length()) + balance);
        System.out.println("PHI + VAT:" + " ".repeat(32) + "0đ");
    }

    /*
     * Hàm xử lý yêu cầu rút tiền của khách hàng.
     * Gọi hàm isAccepted() để kiểm tra tài khoản và số tiền rút có đạt
     * yêu cầu hay không.
     * Có thì hành động rút tiền được diễn ra và trả về giá trị true
     * Không thì hành động bị từ chối và trả về giá trị false
     */
    @Override
    public boolean withdraw(double amount) {
        boolean status = false;
        if(isAccepted(amount)){
            setBalance(getBalance() - amount);
            log(amount);
            status = true;
        }
        Transaction transaction = new Transaction(getAccountNumber(), amount,
                LocalDateTime.now(), status);
        this.addTransaction(transaction);
        return status;
    }

    /*
    * Hàm kiểm tra số tiền trong tài khoản và số tiền
    * mà khách hàng muốn rút. Nếu đáp ứng đủ điều kiện thì
    * trả về già trị true để hành động rút tiền được diễn
    * ra, nếu không thì trả về false để từ chối yêu cầu rút tiền của khách hàng.
    */
    @Override
    public boolean isAccepted(double amount){
        if(amount >= 50_000 && (amount % 10_000 == 0)){
            if(!isPremiumAccount() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAW){
                System.out.println("The account cannot make this transaction!");
                return false;
            }

            if(getBalance() - amount < 50_000){
                System.out.println("The remaining balance in your wallet is not enough!");
                return false;
            }

            return true;
        }
        System.out.println("The amount you withdrew is invalid!");
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s" + " ".repeat(2) +"|" + " ".repeat(9) + "SAVINGS|"+ " ".repeat(11) +"%15s",
                getAccountNumber(), Formatter.formatNumber(getBalance()));
    }
}
