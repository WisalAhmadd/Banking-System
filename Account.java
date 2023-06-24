/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybanksystem;

import java.awt.Color;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Touseef Khattak
 */
public class Account implements Comparable , Serializable
{
    // Variables here

    static int nextAccNo = 10;

    int accNo;
    String Owner;
    City city;
    char gender;
    double balance;
    Date openDate;
    
    public Account()
    {
        
    }

    public Account(String Owner, City city, char gender) {
        accNo = nextAccNo;
        nextAccNo += 10;
        this.Owner = Owner;
        this.city = city;
        this.gender = gender;
        
        balance = 0.0;
        openDate = null;
    }

    public Account(int accNo, String Owner, City city, double balance ,char gender) {
        this.accNo = accNo;
        this.Owner = Owner;
        this.city = city;
        this.gender = gender;
        setBalance(balance);
    }

    public static int getNextAccNo() {
        return nextAccNo;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getOwner() {
        return Owner;
    }

    public City getCity() {
        return city;
    }

    public char getGender() {
        return gender;
    }

    public Date getOpenDate() {
        return openDate;
    }

    
    
    @Override
    public String toString() {
        return accNo + " " + Owner + " " + city.CityName +" " +  gender + " " + balance ;
    }

    public double getBalance() {
        return balance;
    }

    
    
    public void setBalance(double balance) {
        this.balance = balance > 0.0 ? balance : 0.0;
    }
    
    
    
    
    
    
    
    
    @Override
    public int compareTo(Object o) {
        return this.Owner.compareTo(((Account) o) .Owner);    
    }
    
    public void deposit(double amount)
    {
        if (amount > 0)
        {
            setBalance(balance+amount);
        }
        
//          table.setBackground(Color.WHITE);

    }
    
      
   public double withdraw(double amount) {
    if (amount > 0) {
        if (amount < balance) {
            setBalance(balance - amount);
        } else {
            amount = balance;
            setBalance(0.0);
        }
        return amount;
    }
    return 0.0;
  }


        
}
                      
    

    
    
    

