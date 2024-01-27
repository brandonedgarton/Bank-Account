import java.util.Scanner;

public class BankSavingsAccountInfo {
    public static void main(String args[]) {
        String input = "";

        Scanner keyboard = new Scanner(System.in);

        double balance = getDoubleInput("Enter your beginning balance: ", keyboard);
        double apr = getDoubleInput("Enter your interest rate(whole number): ", keyboard);
        keyboard.nextLine();

        SavingsAccount newAccount = new SavingsAccount(balance, apr);

        do {
            displayMenu();

            System.out.print("Choose a menu option: ");
            input = menuSelection(keyboard, newAccount);

        } while (input.toLowerCase().charAt(0) != 'e');
    }

    private static double getDoubleInput(String prompt, Scanner scanner){
        System.out.println(prompt);
        while(!scanner.hasNextDouble()){
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print(prompt);
            scanner.nextDouble();
        }
        return scanner.nextDouble();
    }

    private static String menuSelection(Scanner keyboard, SavingsAccount newAccount) {
        String input = keyboard.nextLine();

        switch (input.toUpperCase().charAt(0)) {
            case 'D':
                handleDeposit(keyboard, newAccount);
                break;

            case 'W':
                handleWithdrawal(keyboard, newAccount);
                break;

            case 'B':
                displayBalance(newAccount);
                break;

            case 'M':
                processMonthly(newAccount);
                break;

            case 'E':
                displayExitMessage(newAccount);
                break;

            default:
                System.out.println("Invalid choice! Try again!");
                break;
        }
        return input;
    }

    private static void handleDeposit(Scanner keyboard, SavingsAccount newAccount) {
        double amount = getDoubleInput("Enter the amount you want to Deposit: $", keyboard);
        keyboard.nextLine();
        if (amount >= 0) {
            newAccount.deposit(amount);
        } else {
            System.out.println("Invalid: Must enter positive value");
        }
    }

    private static void handleWithdrawal(Scanner keyboard, SavingsAccount newAccount) {
        double amount = getDoubleInput("Enter the amount you want to Withdraw: $", keyboard);
        keyboard.nextLine();
        if (amount >= 0) {
            newAccount.withdraw(amount);
        } else {
            System.out.println("Invalid: Must enter positive value");
        }
    }

    private static void displayBalance(SavingsAccount newAccount) {
        System.out.printf("Your Balance is: $%.2f", newAccount.getBalance());
        System.out.println();
    }

    private static void processMonthly(SavingsAccount newAccount) {
        newAccount.monthlyService();
        System.out.printf("Your Balance after Monthly processing is: $%.2f", newAccount.getBalance());
        System.out.println();
    }

    private static void displayExitMessage(SavingsAccount newAccount) {
        System.out.printf("Balance: $%.2f", newAccount.getBalance());
        System.out.println();
        System.out.println("Thank You For Your Business!");
    }

    private static void displayMenu() {
        System.out.println("Enter D to make a Deposit");
        System.out.println("Enter W to make a Withdrawal");
        System.out.println("Enter B for your Balance");
        System.out.println("Enter M for your Monthly Process");
        System.out.println("Enter E to Exit");
    }
}
