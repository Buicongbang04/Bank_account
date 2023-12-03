package program;

import models.accountDB.Account;
import models.accountDB.LoanAccount;
import models.accountDB.SavingsAccount;
import models.bankDB.DigitalBank;
import ui.Main_menu;
import utils.Censor;

public class Main {
    public static final int EXIT_COMMAND_CODE = 0;
    public static final int EXIT_ERROR_CODE = -1;
    public static final String CUSTOMER_ID = "080204000423";
    public static final String CUSTOMER_NAME = "Cong Bang Bui";
    public static final DigitalBank bank = new DigitalBank();
    public static final String CUSTOMER_ID_2 = "080204000425";
    public static final String CUSTOMER_NAME_2 = "Nguyen The Nguyen";


    public static void main(String[] args) {
        Censor.initListProvinces();
        String author = "fx23060";
        String version = "v3.0.0";

        bank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        Main_menu menu = new Main_menu();
        int userChoice;
        do {
            menu.printMenu(author, version);
            userChoice = menu.getChoiceFromUser();
        } while (menu.handleUserChoice(userChoice));
    }
}
