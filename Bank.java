
/**
 * @author (Tridib Paul Turjo)
 * @version (18.03.2023)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private String bankName;
    private ArrayList<Account> accounts;
    
    /**
    * Default constructor for the Bank class.
    * Initializes the bank with a default name and an empty list of accounts.
    */
    public Bank() {
        this.bankName = "Not specified";
        this.accounts = new ArrayList<>();
    }

    /**
    * Overloaded constructor for the Bank class with a specified bank name.
    * Initializes the bank with the given name and an empty list of accounts.
    * @param name the name of the bank
    */
    public Bank(String name) {
        this.bankName = name;
        this.accounts = new ArrayList<>();
    }

    /**
    * Adds an account to the bank's list of accounts.
    * @param a the account to be added
    */
    public void add(Account a) {
        this.accounts.add(a);
    }
    
    /**
    * Returns the name of the bank.
    * @return the name of the bank
    */
    public String getBankName() {
        return this.bankName;
    }
    
    /**
     * Displays the bank name and details of all accounts.
     */
    public void display() {
        System.out.println("Bank Name: " + this.bankName);
        for (Account each : this.accounts) {
            String type = each instanceof Saving ? "Saving" : "Cheque";
            System.out.println("Account User Name: " + each.getUserName() + ", Account Number: " + each.getAccountNumber() + ", Account Balance: " + each.getBalance() + ", Account Type: " + type);
        }
    }

    /**
    * Displays the bank name and details of accounts for a specific user.
    * @param user the user name whose accounts are to be displayed
    */
    public void display(String user) {
        System.out.println("Bank Name: " + this.bankName);
        for (Account each : this.accounts) {
            if (each.getUserName().equals(user)) {
                String type = each instanceof Saving ? "Saving" : "Cheque";
                System.out.println("Account User Name: " + each.getUserName() + ", Account Number: " + each.getAccountNumber() + ", Account Balance: " + each.getBalance() + ", Account Type: " + type);
            }
        }
    }
    
    /**
    * Displays the bank name and details of accounts for a specific user.
    * @param user the user name whose accounts are to be displayed
    */
    public List<Account> getAccounts(String user) {
        return this.accounts.stream()
                            .filter(a -> a.getUserName().equals(user))
                            .collect(Collectors.toList());
    }
}
