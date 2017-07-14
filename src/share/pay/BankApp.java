/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package share.pay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yvc5283
 */
public class BankApp {
    
    private ArrayList<PersonalChecking> checkingList;
    private ArrayList<PersonalSaving> savingList;
    private Scanner in = new Scanner(System.in);
    
    
    public BankApp(ArrayList<PersonalChecking> checkingList,ArrayList<PersonalSaving> savingList)
    {
        this.checkingList = checkingList;
        this.savingList = savingList;
    
        //
    }
    
    public void accessMenu()
    {
        System.out.println("Available accounts: ");
        for(PersonalChecking pc : checkingList)
        {
            System.out.println(pc.getAccountNumber());
        }
        for(PersonalSaving ps : savingList)
        {
            System.out.println(ps.getAccountNumber());
        }
       
        
        String input = in.next();
        String pinInput;
        if(input.equalsIgnoreCase("exit"))
        {System.out.println("Exiting to main bank menu");
            return;
        }
       
                    
            }
        }
       