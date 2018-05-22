/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

/**
 *
 * @author Moi
 */
public class Fonds {
    private double amount;
    
    public Fonds()
    {
        amount = 0;
    }
    
    public Fonds(double amount1){
        amount = amount1;
    }
    
    double getAmount(){
        return amount;
    }
    
}
