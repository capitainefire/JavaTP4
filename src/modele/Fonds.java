/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Moi
 */
public class Fonds {
    private double amount;
    private String cle;
    
    public Fonds()
    {
        amount = 0;
        cle = "";
    }
    
    public Fonds(double amount1, String key){
        amount = amount1;
        cle = key;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public String  getKey()
    {
        return cle;
    }
    
}
