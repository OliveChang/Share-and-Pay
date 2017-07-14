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
class overdraw extends Exception {

    public overdraw() {
        super("You have insufficient funds to complete the transaction.");
    }
    
}