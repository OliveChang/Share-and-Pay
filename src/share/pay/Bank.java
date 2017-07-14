/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package share.pay;







import java.io.Serializable;
import java.util.ArrayList;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;


public class Bank implements Serializable{
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    
    void addCustomer(Customer customer) {
        if(accountExists(customer.getAccount().getAccountNumber())){
            customer.getAccount().setAccountNumber(findValidAccountNumber());
        }
        customers.add(customer);
    }
    
    private int findValidAccountNumber(){
        int accountNumber = 0;
        do {
            accountNumber = Account.getNextAccountNumber();
        } while(accountExists(accountNumber));      
        return accountNumber;
    }
    
    private boolean accountExists(int accountNumber){
        for(Customer c : customers){
            if(c.getAccount().getAccountNumber() == accountNumber){
                return true;
            }
        }
        return false;
    }

    Customer getCustomer(int account) {
        Random rnd = new Random();
        int Account = 100000 + rnd.nextInt(900000);
        return customers.get(account);
    }
    
    ArrayList<Customer> getCustomers(){
        return customers;
    }

    Customer getCustomerByAccountNumber(int accountNumber) {
        Customer customer = null;
        for(Customer c : customers){
            if(c.getAccount().getAccountNumber() == accountNumber){
                customer = c;
                break;
            }
        }
        return customer;
    }

    void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
   
    
}