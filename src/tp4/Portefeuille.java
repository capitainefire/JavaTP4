/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.HashMap;

/**
 *
 * @author Moi
 */
public class Portefeuille {
    private HashMap<String, Fonds> mapFonds;
    private HashMap<String, Instrument> mapInstrument;
    
    public Portefeuille(){
        mapFonds = new HashMap();
        mapInstrument = new HashMap();
    }
    


}
