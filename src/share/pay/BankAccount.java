/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package share.pay;

/**
 *
 * @author yvc5283
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public abstract class BankAccount {
    
    protected int accountNumber;
    protected String joinDate;
    protected double balance;
    protected int pin;
    
    
    public BankAccount(int pin){
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        joinDate = dateFormat.format(new Date());
        this.balance = 0;
        Random rand = new Random();
        this.accountNumber = Double.valueOf(Math.random()*10000000).intValue();
        this.pin = pin;
        
    }
    
    
    public abstract int getAccountNumber();
    public abstract double getBalance();
    public abstract String getJoinDate();
    public abstract int getPin();
    public abstract void displayInfo();

    
}
