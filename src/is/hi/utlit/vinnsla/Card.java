/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.utlit.vinnsla;

/**
 *
 * @author Styrmir Óli
 */
public class Card {
    private String number;
    private int pin;
    
    public Card(String newNumber, int newPin) {
        newNumber = number;
        newPin = pin;
    }
    public String getNumber() {
        return number;
    }
    public int getPin() {
        return pin;
    }
}
