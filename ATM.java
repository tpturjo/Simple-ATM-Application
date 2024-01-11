                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  /**
 * The ATM class - An ATM interface.
 * @author (Tridib Paul Turjo)
 * @version (01.04.2023)
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ATM {
    private Bank bank;
    private String user;
    private JFrame frame;

    /**
    * Constructor for the ATM class.
    * Initializes the ATM with a user and sets up the bank and the interface.
    * @param user the user name for the ATM session
    */
    public ATM(String user) {
        this.user = user;
        createBankInfo();
        makeFrame();
    }
    
    /**
    * Sets up the initial bank information for testing.
    */
    private void createBankInfo() {
        bank = new Bank("Canada");
        bank.add(new Saving(user));
        bank.add(new Cheque(user));
    }

    /**
    * Creates the main frame of the ATM interface.
    */
    private void makeFrame() {
        frame = new JFrame("ATM for " + user);
        Container contentPane = frame.getContentPane();
        makeMenuBar(frame);
        listAccounts();
        frame.pack();
        frame.setVisible(true);
    }

    /**
    * Sets up the menu bar for the ATM interface.
    * @param frame the frame to which the menu bar is added
    */
    private void makeMenuBar(JFrame frame) {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // Accounts menu
        JMenu menu = new JMenu("Accounts");
        menubar.add(menu);
        JMenuItem allAccountsItem = new JMenuItem("All Accounts...");
        allAccountsItem.addActionListener(e -> listAccounts());
        menu.add(allAccountsItem);

        // Help menu
        menu = new JMenu("Help");
        menubar.add(menu);
        JMenuItem aboutItem = new JMenuItem("About...");
        aboutItem.addActionListener(e -> about());
        menu.add(aboutItem);
        JMenuItem exitItem = new JMenuItem("Exit...");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);
    }
    
    /**
    * Lists all accounts associated with the user in the ATM interface.
    */
    private void listAccounts() {
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        contentPane.setLayout(new GridLayout(0, 6));
        List<Account> accounts = bank.getAccounts(user);
        for (Account acc : accounts) {
            drawAccount(acc);
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
    * Draws the account information on the ATM interface for each account.
    * @param acc the account to be displayed
    */
    private void drawAccount(Account acc) {
        Container contentPane = frame.getContentPane();
        JLabel label = new JLabel(acc instanceof Saving ? "Saving Account" : "Cheque Account");
        contentPane.add(label);

        JLabel accNumberLabel = new JLabel("Account: " + acc.getAccountNumber());
        contentPane.add(accNumberLabel);

        JLabel balanceLabel = new JLabel(" Balance: ");
        contentPane.add(balanceLabel);

        JTextField balanceField = new JTextField(String.valueOf(acc.getBalance()));
        contentPane.add(balanceField);
        balanceField.setEditable(false);

        JButton depositButton = new JButton("Deposit");
        contentPane.add(depositButton);
        depositButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Input deposit amount: ", 0);
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    acc.deposit(amount);
                    balanceField.setText(String.valueOf(acc.getBalance()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
            }
        });

        JButton withdrawButton = new JButton("Withdraw");
        contentPane.add(withdrawButton);
        withdrawButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Input withdrawal amount: ", 0);
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    acc.withdraw(amount);
                    balanceField.setText(String.valueOf(acc.getBalance()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
            }
        });
    }

    /**
    * Displays the about information in the ATM interface.
    */
    private void about() {
        JOptionPane.showMessageDialog(frame, user + "@" + bank.getBankName(), "About", JOptionPane.INFORMATION_MESSAGE);
    }
}
