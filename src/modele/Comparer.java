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
public class Comparer implements Comparable<Fonds>{
    
    private Fonds fonds;
    private double montant;
    
    /* Constructeur */
    public Comparer()
    {
        fonds = new Fonds();
        montant = fonds.getAmount();
    }
    
    /** Equals */
    @Override
    public boolean equals(Object o)
    {
        
        System.out.println("app");
        /* Tester */
        if( (o instanceof Fonds) && (o.equals(montant) == true) )
        {
            return true;
        }
        else{
            return false;
        }    
        
    }

    @Override
    public int compareTo(Fonds o) {
        if(montant > o.getAmount())
        {
            return 1;
        }
        else
        if(equals(fonds) == true)
        {
            return 0;
        }
        else{
            return -1;
        }
    }
    
}
