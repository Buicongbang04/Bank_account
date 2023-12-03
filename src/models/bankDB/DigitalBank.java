package models.bankDB;

import models.userDB.DigitalCustomer;
import utils.Censor;

public class DigitalBank extends Bank{

    /*
    * Hàm getCustomerById dùng để tìm khách hàng theo CCCD,  gồm 1 tham số:
    * customerId kiểu String là CCCD của khách hàng.
    * Kiểu trả về Customer.
    * Chỉ trả về khách hàng nếu như tồn tại CCCD trong hệ thống ngân hàng, ngược lại trả về null.
    */
    public DigitalCustomer getCustomerById(String customerId){
        for(DigitalCustomer customer : customerList){
            if(Censor.isDup(customerId, customer.getCustomerId())){
                return customer;
            }
        }
        return null;
    }

    /*
    * Hàm addCustomer dùng để tạo khách hàng cho ngân hàng, gồm 2 tham số:
    * customerId kiểu String là CCCD của khách hàng.
    * name kiểu String là tên của khách hàng.
    */
    public boolean addCustomer(String customerId, String name){
        if(!isCustomerExisted(customerId)){
            customerList.add(new DigitalCustomer(name, customerId));
            return true;
        }
        return false;
    }

    /*
    * Thêm hàm withdraw dùng để cho phép khách hàng rút tiền theo tài khoản gồm 3 tham số:
    * customerId kiểu String là CCCD của khách hàng.
    * accountNumber kiểu String là mã tài khoản của khách hàng.
    * amount kiểu double là số tiền mà khách hàng muốn rút.
    */
    public void withdraw(String customerId, String accountNumber, double amount){
        for (DigitalCustomer customer : customerList){
            if(Censor.isDup(customer.getCustomerId(), customerId)){
                customer.withdraw(accountNumber, amount);
                return;
            }
        }
    }
}
