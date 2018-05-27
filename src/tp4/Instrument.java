/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
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
        Comparer compare = new Comparer();
        
        arrayFonds.sort((Comparator<? super Fonds>) compare);
        arrayFonds.forEach(item -> System.out.println(item));
    }
    
    public boolean rechercherFdansI(String cleFonds)
    {
        boolean Dedans = false;
        for (int i = 0; i < arrayFonds.size(); i++)
        {
            if(arrayFonds.get(i).getKey() == cleFonds)
            {
                Dedans = true;
            }
        }
        return Dedans;
    }
    
    public ArrayList<Fonds> getArrayFonds(){
        return arrayFonds;
    }

}
