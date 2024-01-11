/**
 * @author (Tridib Paul Turjo)
 * @version (18.03.2020)
 */
import java.util.Random;

public class Account {
    private int accountNumber;
    private String userName;
    protected double balance;
    
    
    /**
    * Default constructor for the Account class.
    * Initializes the account with a random account number, unspecified user name, and zero balance.
    */
    public Account() {
        Random randomNumber = new Random();
        this.accountNumber = randomNumber.nextInt(9999999);
        this.userName = "Not specified";
        this.balance = 0;
    }

    
    /**
    * Overloaded constructor for the Account class with a specified user name.
    * Initializes the account with a random account number, given user name, and zero balance.
    * @param user the name of the account user
    */    
    public Account(String user) {
        Random randomNumber = new Random();
        this.accountNumber = randomNumber.nextInt(9999999);
        this.userName = user;
        this.balance = 0;
    }

    
    /**
    * Displays account information including user name, account number, and balance.
    */
    public void display() {
        System.out.println("Account user Name: " + this.userName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Balance: " + this.balance);
    }
    
    
    /**
    * Deposits a specified amount into the account.
    * If the amount is positive, it updates the account balance.
    * @param amount the amount to be deposited
    */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("On account Number " + this.accountNumber + " $" + amount + " is deposited.");
            System.out.println("Account New Balance is now: " + this.balance + ".");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    /**
    * Placeholder method for withdrawing money from the account.
    * This method is overridden in subclasses.
    * @param amount the amount to be withdrawn
    */
    public void withdraw(double amount) {
        // This method should be overridden in subclasses
    }

    /**
    * Returns the current balance of the account.
    * @return the balance of the account
    */
    public double getBalance() {
        return this.balance;
    }

    /**
    * Returns the user name associated with the account.
    * @return the user name of the account
    */
    public String getUserName() {
        return this.userName;
    }
    /**
    * Returns the account number.
    * @return the account number
    */
    public int getAccountNumber() {
        return this.accountNumber;
    }
}
