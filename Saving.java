
/**
 * @author (Tridib Paul Turjo)
 * @version (19.03.2023)
 */
public class Saving extends Account {
    private static final double eachTimeCharge = 3.9;
    /**
    * Default constructor for the Saving class.
    * Calls the superclass constructor to initialize the Saving account.
    */
    public Saving() {
        super();
    }

    /**
     * Overloaded constructor for the Saving class with a specified user name.
     * Calls the superclass constructor to initialize the Saving account with the given user name.
     * @param user the name of the account user
     */
    public Saving(String user) {
        super(user);
    }

    /**
    * Overridden method to withdraw a specified amount from the Saving account.
    * Charges a transaction fee and updates the balance if sufficient funds are available.
    * @param amount the amount to be withdrawn
    */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount + eachTimeCharge > this.balance) {
            System.out.println("Error: Not enough balance.");
        } else {
            this.balance -= (amount + eachTimeCharge);
            System.out.println("Transaction successful. $" + amount + " withdrawn from the account. $3.9 charged for the transaction.");
            System.out.println("Your account new balance: " + this.balance);
        }
    }
}
