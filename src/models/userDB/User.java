package models.userDB;

import utils.Censor;

public class User {
     private String name;
     private String customerId;

    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        try{
            if (customerId.length() == 12 && Censor.isNumeric(customerId)){
                this.customerId = customerId;
            }else{
                throw new Exception("This customer id is invalid!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
