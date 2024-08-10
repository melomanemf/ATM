//import the necessary classes for using arraylist and list
import java.util.ArrayList;
//import the necessary classes for using list
import java.util.List;
//import the necessary classes for using scanner
import java.util.Scanner;

/**
 * This class stimulates the basic functions of an ATM machine.
 */
public class ATM {
    //declare a private variable to store the account balance
    private double balance;
   //declare a private variable to store the pIN
    private String pin;
    //declare a private variable to store the transaction history
    private List<String> transactionHistory;
/**
 * constructor to initialize the ATM object with initial balance and PIN.
 * 
 * @param initial balance the initial balance in the account.
 * @param initialpin the initial PIN for the account.
 */
    public ATM(double initialBalance, String initialPin) {
        //initialize the balance with initial balance
        this.balance = initialBalance;
        //initialize the pin with the initial PIN
        this.pin = initialPin;
        //initialize the transaction history as an empty Arraylist
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * method to check the account balance.
     */
    public void checkBalance() {
      //print the current balance to the console
       System.out.println("Your current balance is: $" + balance);
    }

    /**
     * method to Withdraw cash from the Account.
     *
     * @param amount amount to withdraw
     */
    public void withdraw(double amount) {
       //check if the amount to withdraw is greater than the balance
        if (amount > balance) {
          //print an error message if the amount exceeds the balance
           System.out.println("Insufficient funds.");
        } else {
            //subtract the amount from the balance
            balance -= amount;
            //add the withdrawal transaction to the transaction history
            transactionHistory.add("Withdrawal: $" + amount);
            //print a success message with reamaining balance
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        }
    }

    /**
     *  method to Deposit cash into the account
     *
     * @param amount amount to deposit.
     */
    public void deposit(double amount) {
//add the amount to the balance
        balance += amount;
       //add the deposit transaction to the transaction history
        transactionHistory.add("Deposit: $" + amount);
        //print a success message with the new balance
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    /**
     * method to  Change  the PIN
     *
     * @param newPin new PIN
     */
    public void changePin(String newPin) {
       //update the pin with the new pin
        pin = newPin;
        //print a success message
        System.out.println("PIN changed successfully.");
    }

    /**
     * Method to Display transaction history.
     */
    public void displayTransactionHistory() {
        //print a header for the transaction history
        System.out.println("Transaction History:");
        //iterate over each transaction in the transaction history
        for (String transaction : transactionHistory) {
            //print the transaction
            System.out.println(transaction);
        }
    }
/**
 * main method to run the ATM simulation.
 * 
 * @param args command-line arguments(not used).
 */
    public static void main(String[] args) {
        //create a new ATM object with an initial balance and PIN
        ATM atm = new ATM(1000.0, "1234");
       //create a new scanner object to read user input
        Scanner scanner = new Scanner(System.in);

       //loop indefinitely untill the user chooses to exit
        while (true) {
           //print the main menu
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            //prompt the user to enter their choice
            System.out.print("Enter your choice: ");
        //read the user's choice as an integer
         int choice = scanner.nextInt();

            //use a switch statement to handle the user's choice
            switch (choice) {
                //case1:check balance
                case 1:
                    //call the check balance method to display the current balance
                    atm.checkBalance();
                    //break out of the switch statement
                    break;
                //case2:withdraw cash
                case 2:
                    //prompt the user to enter the anount to withdraw
                    System.out.print("Enter amount to withdraw: $");
                    //read the amount to withdraw  as double
                    double withdrawAmount = scanner.nextDouble();
//call the withdraw method to withdraw the specified amount
                    atm.withdraw(withdrawAmount);
                    //break out of the switch statement
                    break;
                //case3:deposit cash
                case 3:
                    //prompt the user to enter the anount to deposit
                    System.out.print("Enter amount to deposit: $");
                    //read the amount to deposit as double
                    double depositAmount = scanner.nextDouble();
                    //call the deposit  method to deposit  the specified amount
                    atm.deposit(depositAmount);
                    //break out of the switch statement
                    break;
                //case4:change PIN
                case 4:
                   //prompt the user to enter the new PIN 
                    System.out.print("Enter new PIN: ");
                   //read the new pin as string 
                    String newPin = scanner.next();
                    //call the change pin method to update the PIN
                    atm.changePin(newPin);
                     //break out of the switch statement
                    break;
                //case5:transactionhistory
                case 5:
                    //call the displaytransactionhistory method to display the transaction history
                    atm.displayTransactionHistory();
                    //break out of the switch statement
                    break;
                //case6:Exit
                case 6:
                   //print a message indicating that the program is Exiting
                    System.out.println("Exiting...");
                    //return from the main method to exit the program
                    return;
               //default case:/Invalid choice
                default:
                    //print an error message indicating that the choice is invalid
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
