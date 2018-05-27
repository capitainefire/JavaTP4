/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Moi
 */
public class Instrument {
    private ArrayList<Fonds> arrayFonds;
    private String cle;
    
    public Instrument(){
        arrayFonds = new ArrayList<Fonds>();
        cle = "";
    }
    
    public Instrument(String key){
        arrayFonds = new ArrayList<Fonds>();
        cle = key;
    }
    
    public void ajouter(Fonds fonds){
        arrayFonds.add(fonds);
    }
   
    public void trier()
    {
       // Fonds d'un instrument tries par montant
        Collections.sort(arrayFonds);
    }
    
    public boolean rechercherFdansI(String cleFonds)
    {
        boolean Dedans = false;
        for (int i = 0; i < arrayFonds.size(); i++)
        {
            if(arrayFonds.get(i).getKey().equals(cleFonds))
            {
                Dedans = true;
            }
        }
        return Dedans;
    }
    
    public ArrayList<Fonds> getArrayFonds(){
        return arrayFonds;
    }

    public String getCle() {
        return cle;
    }
}
