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
public class Fonds implements Comparable<Fonds>{
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
    
     /** Equals */
    
    public boolean equals(Fonds fonds)
    {
        boolean egual = false;
        
        /* Tester */
        if(this.amount == fonds.getAmount())
        {
            egual = true;
        }
        else{
            egual = false;
        }
        
        return egual;
    }
    
    @Override
    public int compareTo(Fonds o) {
        
        int resultat = -1;
        
        if(this.amount > o.getAmount())
        {
            resultat = 1;
        }
        else
        if(equals(o) == true)
        {
            resultat = 0;
        }
        else{
            resultat = -1;
        }
        
        return resultat;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public String  getKey()
    {
        return cle;
    }
    
}
