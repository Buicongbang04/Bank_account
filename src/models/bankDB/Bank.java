package models.bankDB;

import models.accountDB.Account;
import models.userDB.Customer;
import models.userDB.DigitalCustomer;
import utils.Censor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final String id;
    protected List<DigitalCustomer> customerList;

    public Bank(){
        this.id = String.valueOf(UUID.randomUUID());
        this.customerList = new ArrayList<>();
    }

    /*
    * Hàm addCustomer nhận vào thông tin của một khách hàng mới
    * kiểm tra xem thông tin khách hàng tồn tại hay chưa
    * nếu chưa thì cho phép thêm mới
    * trả về true nếu thêm thành công
    * false nếu thêm thất bại
    */
    public boolean addCustomer(DigitalCustomer newCustomer) {
        for (Customer customer : customerList) {
            if (Censor.isDup(customer.getCustomerId(), newCustomer.getCustomerId(),
                    "This customer is already exist!")) {
                return false;
            }
        }

        customerList.add(newCustomer);
        return true;
    }

    /*
    * Hàm  isCustomerExisted nhận vào mã khách hàng
    * trả về true nếu khách hàng đã tồn tại
    * trả về false nếu khách hàng chưa tồn tại
    */
    public boolean isCustomerExisted (String customerID){
        for(DigitalCustomer customer : customerList){
            if(Censor.isDup(customerID, customer.getCustomerId())){
                return true;
            }
        }
        return false;
    }

    /*
    * Hàm getCustomers trả về list các khách hàng
    */
    public List<DigitalCustomer> getCustomers(){return customerList;}

    /*
    * Hàm addAccount nhận vào mã khách hàng và thông tin tài khoản
    * thêm một tài khoản mới cho khách hàng nếu mã tài khoản đó chưa tồn tại.
    * Trả về true nếu thêm tài khoản thành công
    * false nếu thêm tài khoản thất bại
    */
    public boolean addAccount(String customerID, Account account){
        if(isCustomerExisted(customerID)){
            for(DigitalCustomer customer : customerList){
                if(Censor.isDup(customer.getCustomerId(), customerID)){
                    customer.addAccount(account);
                    return true;
                }
            }
        }
        return false;
    }

    /*
    *  Hàm searchCustomerByName nhận vào một chuỗi và
    * trả về list các khách hàng trong tên có chứa chuỗi
    */
    public List<DigitalCustomer> searchCustomerByName(String name){
        ArrayList<DigitalCustomer> result = new ArrayList<>();
        for(DigitalCustomer customer : customerList){
            if(customer.getName().contains(name)){
                result.add(customer);
            }
        }
        return result;
    }

    /*
    * Hàm  checkCustomerID nhận vào mã khách hàng kiểm tra xem mã đã tồn tại hay chưa
    * có thì trả về true, chưa thì trả về false
    */
    public boolean checkCustomerID(String idCheck){
        for(DigitalCustomer customer : customerList){
            if(Censor.isDup(idCheck, customer.getCustomerId())){
                return true;
            }
        }
        return false;
    }

    /*
    * Hàm checkAccountID nhận vào mã tài khoản kiểm tra mã có tồn tại hay chưa
    * có thì trả về true, chưa thì trả về false
    */
    public boolean checkAccountID(String accountCheck){
        for(DigitalCustomer customer : customerList){
            for(int i = 0; i < customer.accountList.size(); i++){
                if(Censor.isDup(accountCheck, customer.accountList.get(i).getAccountNumber())){
                    return true;
                }
            }
        }
        return false;
    }
}
