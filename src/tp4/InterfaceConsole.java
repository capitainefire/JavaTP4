/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Moi
 */
public class InterfaceConsole {
    
    public InterfaceConsole()
    {
        
    }
    
    public void afficherInstrument(Portefeuille portefeuille)
    {
        Set<String> cles = portefeuille.getMapInstrument().keySet();
        Iterator<String> it = cles.iterator();
        String iter = "";
        
        while(it.hasNext())
        {
            iter = it.next();
            System.out.println("La cle est : " + iter);
            Instrument valeur = portefeuille.getMapInstrument().get(iter);
            
            System.out.println("Le nombre total de fonds est : " + valeur.getArrayFonds().size());
            
            double cpt = 0;
                        
            for(int i=0; i< valeur.getArrayFonds().size();i++)
            {
                cpt += valeur.getArrayFonds().get(i).getAmount();
            }
            System.out.println("La somme totale des motants des fonds est : " + cpt);
        }
        
    }
    
    public int rechercher(String cleFonds)
    {
        int untruc = 0;
        return untruc;
    }
    
}
