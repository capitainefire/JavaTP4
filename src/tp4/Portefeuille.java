/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
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
    
    public double rechercheFonds(String cleFonds) throws FondsInexistant
    {  
        if(mapFonds.get(cleFonds) != null)
        {
            return mapFonds.get(cleFonds).getAmount();
        }
        else {
            throw new FondsInexistant();
        }
    }
    
    public ArrayList<Fonds> rechercheInstrument(String cleInstrument) throws InstrumentInexistant
    {  
        if(mapInstrument.get(cleInstrument) != null)
        {
            return mapInstrument.get(cleInstrument).getArrayFonds();
        }
        else {
            throw new InstrumentInexistant();
        }
    }
    
    public void ajouterFdansF(String cleFonds, double montantFonds) throws FondsExistant
    {
        if(mapFonds.get(cleFonds) == null)
        {
            Fonds tmpFonds = new Fonds(montantFonds, cleFonds);
            mapFonds.put(cleFonds,tmpFonds);
        }
        else {
            throw new FondsExistant();
        }
    }
    
    public void ajouterFdansI(String cleInstrument, Fonds nouveauFonds)
    {
        mapInstrument.get(cleInstrument).ajouter(nouveauFonds, cleInstrument);
    }
    
    public void supprimerFonds(String cleFonds) throws FondsInexistant
    {
        rechercheFonds(cleFonds);
        mapFonds.remove(cleFonds);        
    }
    
    
    public HashMap<String, Fonds> getMapFonds() {
        return mapFonds;
    }

    public HashMap<String, Instrument> getMapInstrument() {
        return mapInstrument;
    }
}
