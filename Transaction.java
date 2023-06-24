
package mybanksystem;


import java.io.Serializable;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Touseef Khattak
 */
public class Transaction implements Comparable<Transaction>,Serializable{
    
    private static int next = 0 ;
    int transactionNumber;
    Account acc;
    LocalDate Date;
    char operation;
    Double amount; 

    public Transaction(Account acc, LocalDate Date, Double amount,char operation) {
        this.acc = acc;
        this.Date = Date;
        this.operation = operation;
        this.amount = amount;
        transactionNumber = next++;
        
    }

    
    
    
    
    
    @Override
    public int compareTo(Transaction o) {
       return this.transactionNumber - o.transactionNumber;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionNumber=" + transactionNumber + ", acc=" + acc + ", Date=" + Date + ", operation=" + operation + ", amount=" + amount + '}';
    }
    
    

    public int getTransactionNumber() {
        return transactionNumber+=1;
    }

    public Account getAcc() {
        return acc;
    }

    public LocalDate getDate() {
        return Date;
    }

    public char getOperation() {
        return operation;
    }

    public Double getAmount() {
        return amount;
    }
    
    
    
    
}
