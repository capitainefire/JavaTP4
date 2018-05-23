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
    
    public void ajouter(Fonds fonds, String key){
        arrayFonds.add(fonds);
        cle = key;
    }
   
    public void trier()
    {
        Comparer compare = new Comparer();
        
        arrayFonds.sort((Comparator<? super Fonds>) compare);
        arrayFonds.forEach(item -> System.out.println(item));
    }
    
    public ArrayList<Fonds> getArrayFonds(){
        return arrayFonds;
    }

}
