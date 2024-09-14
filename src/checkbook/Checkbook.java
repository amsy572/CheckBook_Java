/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package checkbook;

import java.util.Scanner;

/**
 *
 * @author AMSY
 */
public class Checkbook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWelcome In");
        
        Engine engine = new Engine();

        while (true) {
            System.out.println("\nUSER MENU");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    performDeposit(engine);
                    break;
                case 2:
                    performWithdrawal(engine);
                    break;
                case 3:
                    checkBalance(engine);
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
//   performDeposit Method

    public static void performDeposit(Engine engine) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        double amount = scanner.nextDouble();
        engine.deposit(amount);
        System.out.println("Amount deposited successfully");
    }
    
    //    performWithdrawal Method
    public static void performWithdrawal(Engine engine) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw: ");
        double amount = scanner.nextDouble();
        boolean success = engine.withdraw(amount);
        if (success) {
            System.out.println("Amount withdrawn successfully");
        } else {
            System.out.println("Unable to withdraw amount");
        }
    }
    
    
    //    checkBalance Method
    public static void checkBalance(Engine engine) {
        System.out.println("\nBalance: " + engine.getBalance());
        engine.printTransactionHistory();
    }

   

}
