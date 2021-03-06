/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package share.pay;

import java.util.Random;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.get;

/**
 *
 * @author yvc5283
 */
public class AddAccountMenu extends javax.swing.JDialog {

    private Bank bank;
    private Customer customer;

    /**
     * Creates new form AddAccountMenu
     */
    public AddAccountMenu(java.awt.Frame parent, boolean modal, Bank bank) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = bank;
        customer = null;
    }


  



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FNlbl = new javax.swing.JLabel();
        FNtxt = new javax.swing.JTextField();
        LNlbl = new javax.swing.JLabel();
        LNtxt = new javax.swing.JTextField();
        Accountlbl = new javax.swing.JLabel();
        Accounttxt = new javax.swing.JTextField();
        SSNlbl = new javax.swing.JLabel();
        SSNtxt = new javax.swing.JTextField();
        DOBlbl = new javax.swing.JLabel();
        DOBtxt = new javax.swing.JTextField();
        AccountTypelbl = new javax.swing.JLabel();
        AccountTypeBox = new javax.swing.JComboBox();
        Balancelbl = new javax.swing.JLabel();
        Balancetxt = new javax.swing.JTextField();
        Submitbtn = new javax.swing.JButton();
        Cancelbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Account");
        setPreferredSize(new java.awt.Dimension(350, 350));
        getContentPane().setLayout(new java.awt.GridLayout(8, 2, 5, 5));

        FNlbl.setText("FirstName:");
        getContentPane().add(FNlbl);

        FNtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNtxtActionPerformed(evt);
            }
        });
        getContentPane().add(FNtxt);

        LNlbl.setText("LastName:");
        getContentPane().add(LNlbl);
        getContentPane().add(LNtxt);

        Accountlbl.setText("Account#:");
        getContentPane().add(Accountlbl);

        Accounttxt.setEditable(false);
        getContentPane().add(Accounttxt);

        SSNlbl.setText("SSN:");
        getContentPane().add(SSNlbl);
        getContentPane().add(SSNtxt);

        DOBlbl.setText("DOB:");
        getContentPane().add(DOBlbl);
        getContentPane().add(DOBtxt);

        AccountTypelbl.setText("AccountType:");
        getContentPane().add(AccountTypelbl);

        AccountTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Checking", "Saving" }));
        AccountTypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountTypeBoxActionPerformed(evt);
            }
        });
        getContentPane().add(AccountTypeBox);

        Balancelbl.setText("Balance:");
        getContentPane().add(Balancelbl);

        Balancetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BalancetxtActionPerformed(evt);
            }
        });
        getContentPane().add(Balancetxt);

        Submitbtn.setText("Submit");
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Submitbtn);

        Cancelbtn.setText("Cancel");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelbtn);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccountTypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountTypeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccountTypeBoxActionPerformed

    private void FNtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNtxtActionPerformed

    private void BalancetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BalancetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BalancetxtActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void SubmitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitbtnActionPerformed
        String firstname = "", lastname = "", ssn = "", DOB = "";
        double Balance = 0;
        StringBuilder warnings = new StringBuilder();
        if(FNtxt.getText().isEmpty()){
            warnings.append("First Name Required.\n");
        } else {
            firstname = FNtxt.getText();
        }
        if(LNtxt.getText().isEmpty()){
            warnings.append("Last Name Required.\n");
        } else {
            lastname = LNtxt.getText();
        }
        if(!SSNtxt.getText().matches("(\\d+-?)+")){
            warnings.append("SSN must be a number.\n");
        } else {
            ssn = SSNtxt.getText();
        }
        
        if(!DOBtxt.getText().matches("(\\d+-?)+")){
            warnings.append("DOB must be a number.\n");
        } else {
            DOB = DOBtxt.getText();
        }
        if(Balancetxt.getText().isEmpty()){
            warnings.append("Initial Balance Required.\n");
        } else {
            try {
                Balance = Double.parseDouble(Balancetxt.getText());
            }
            catch(NumberFormatException ex){
                warnings.append("Initial Balance Required.\n");
            }
        }
        
       if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warnings", JOptionPane.WARNING_MESSAGE);
        } else {
            Account account = null;
            if(AccountTypeBox.getSelectedItem().toString() == "Checking"){
             account = new Checking (Balance);
            }
            else if (AccountTypeBox.getSelectedItem().toString() == "Saving"){
             account = new Saving (Balance);
            }
            customer = new Customer (firstname, lastname, ssn, account);
            bank.addCustomer(customer);
            this.dispose();
       }

    }//GEN-LAST:event_SubmitbtnActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AccountTypeBox;
    private javax.swing.JLabel AccountTypelbl;
    private javax.swing.JLabel Accountlbl;
    private javax.swing.JTextField Accounttxt;
    private javax.swing.JLabel Balancelbl;
    private javax.swing.JTextField Balancetxt;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JLabel DOBlbl;
    private javax.swing.JTextField DOBtxt;
    private javax.swing.JLabel FNlbl;
    private javax.swing.JTextField FNtxt;
    private javax.swing.JLabel LNlbl;
    private javax.swing.JTextField LNtxt;
    private javax.swing.JLabel SSNlbl;
    private javax.swing.JTextField SSNtxt;
    private javax.swing.JButton Submitbtn;
    // End of variables declaration//GEN-END:variables
    Customer getCustomer() {
        return customer;
    }

}
