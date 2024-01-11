/**
 * mainatin withdarw mwthod
 * calculate all the fees
 * for minimBalance and overLimitCharge
 * @author (Tridib Paul Turjo)
 * @version (18.03.2023)
 */
public class Cheque extends Account {
    private static final double minimumBalance = 1000;
    private static final double overLimitCharge = 5;

    /**
    * Default constructor for the Cheque class.
    * Calls the superclass constructor to initialize the Cheque account.
    */
    public Cheque() {
        super();
    }

    /**
    * Overloaded constructor for the Cheque class with a specified user name.
    * Calls the superclass constructor to initialize the Cheque account with the given user name.
    * @param user the name of the account user
    */
    public Cheque(String user) {
        super(user);
    }

    /**
    * Overridden method to withdraw a specified amount from the Cheque account.
    * Applies an over-limit charge if the balance falls below the minimum after withdrawal.
    * @param amount the amount to be withdrawn
    */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Transaction Failed: Insufficient balance in the account.");
        } else {
            if (this.balance - amount < minimumBalance) {
                this.balance -= overLimitCharge;
                System.out.println("Your account balance is below the minimum balance. $5 Over-Limit service charged.");
            }
            this.balance -= amount;
            System.out.println("Transaction successful. $" + amount + " withdrawn from the account.");
            System.out.println("Your account new balance: " + this.balance);
        }
    }
}
