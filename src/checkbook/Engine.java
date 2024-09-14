/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkbook;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author AMSY
 */
public class Engine {

    private Map<String, Double> transactionHistory;
    private List<String> transactions;
    private double balance;

    public Engine() {
        this.transactions = new ArrayList<>();
        this.transactionHistory = new HashMap<>();
        this.balance = 0.0;
    }
    
    
    //    deposit Method
    public void deposit(double amount) {
//        Date currentDate = new Date();
        if (amount > 0) {
            balance += amount;
            String deposit = "Balance :" + amount  ;
            transactionHistory.put(deposit, amount);
            transactions.add(deposit);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
//    withdrawal Method
    public boolean withdraw(double amount) {
//         Date currentDate = new Date();
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
               
                String with = "Balance :" + -amount ;
                transactionHistory.put(with,-amount );
                transactions.add(with);
                return true;
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid withdrawal amount");
        }
        return false;
    }
    
    //    GetBalance Method
    public double getBalance() {
        return balance;
    }
    
    
    //    printTransactionHistor Method
    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
         Deque<Map.Entry<String, Double>> transactionDeque = new LinkedList<>(transactionHistory.entrySet());
        if  (transactionDeque.isEmpty()) {
            System.out.println("No transactions yet");
        } else {
              while (!transactionDeque.isEmpty()) {
                Map.Entry<String, Double> entry = transactionDeque.pollLast();
                double amount = entry.getValue();
                String transactionDescription = amount >= 0 ? "+" + amount : "-" + Math.abs(amount);
                System.out.println(transactionDescription);
            }
        }
    }

}
