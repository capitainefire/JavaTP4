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
    public void afficherInstrument(Portefeuille portefeuille)
    {
        Set cles = portefeuille.getMapInstrument().keySet();
        Iterator it = cles.iterator();
        
        while(it.hasNext())
        {
            double cpt = 0;
            
            String cle = (String) it.next();
            Instrument valeur = portefeuille.getMapInstrument().get(cle);
            
            System.out.println("La cle est : " + cle);
            System.out.println("Le nombre total de fonds est : " + valeur.getArrayFonds().size());
            
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
