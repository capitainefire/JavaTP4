/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;

/**
 *
 * @author Moi
 */
public class Instrument {
    private ArrayList<Fonds> arrayFonds;
    
    public Instrument(){
        arrayFonds = new ArrayList<Fonds>();
    }
    
    public void ajouter(Fonds fonds){
        arrayFonds.add(fonds);
    }
    
    ArrayList<Fonds> getArrayFonds(){
        return arrayFonds;
    }
}
