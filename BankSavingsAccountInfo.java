import java.util.Scanner;

public class BankSavingsAccountInfo {
    public static void main(String args[]) {
        double balance;
        double apr;
        String input = "";

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your beginning balance: ");
        balance = keyboard.nextDouble();

        System.out.print("Enter your interest rate(whole number): ");
        apr = keyboard.nextDouble();
        keyboard.nextLine();

        SavingsAccount newAccount = new SavingsAccount(balance, apr);

        do {
            menu();

            System.out.print("Choose a menu option: ");
            input = keyboard.nextLine();

            switch (input.toUpperCase().charAt(0)) {
                case 'D':
                    System.out.print("Enter the amount you want to Deposit: $");
                    double amount = keyboard.nextDouble();
                    keyboard.nextLine();
                    if (amount < 0) {
                        System.out.println("Invalid: Must enter positive value");
                    } else {
                        newAccount.deposit(amount);
                    }
                    break;

                case 'W':
                    System.out.print("Enter the amount you want to withdraw: $");
                    amount = keyboard.nextDouble();
                    keyboard.nextLine();
                    if (amount < 0) {
                        System.out.println("Invalid: Must enter positive value");
                    } else {
                        newAccount.withdraw(amount);
                    }
                    break;

                case 'B':
                    System.out.println("Your Balance is: " + newAccount.getBalance());
                    break;

                case 'M':
                    newAccount.monthlyService();
                    System.out.println("Your Balance after Monthly processing is: " + newAccount.getBalance());
                    break;

                case 'E':
                    System.out.println("Balance: $" + newAccount.getBalance());
                    System.out.println("Thank You For Your Business!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again!");
                    break;
            }
        } while (input.toLowerCase().charAt(0) != 'e');
    }

    private static void menu() {
        System.out.println("Enter D to make a Deposit");
        System.out.println("Enter W to make a Withdrawal");
        System.out.println("Enter B for your Balance");
        System.out.println("Enter M for your Monthly Process");
        System.out.println("Enter E to Exit");
    }
}