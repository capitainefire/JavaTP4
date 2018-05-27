/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public double rechercher(String cleFonds, Portefeuille portefeuille)
    {
        double pourcentage = 0;
        try {
            portefeuille.rechercheFonds(cleFonds);
        } catch (FondsInexistant ex) {
            System.out.println("Ce fonds n'existe pas");
        }
        
        Set<String> cles = portefeuille.getMapInstrument().keySet();
        Iterator<String> it = cles.iterator();
        String iter = "";
        
        while(it.hasNext())
        {
            iter = it.next();
            Instrument valeur = portefeuille.getMapInstrument().get(iter);
            double cpt = 0;
            
            if(valeur.rechercherFdansI(cleFonds))
            {                
                // Somme
                for(int i=0; i< valeur.getArrayFonds().size();i++)
                {
                    cpt += valeur.getArrayFonds().get(i).getAmount();
                }
                
            }
            pourcentage = (portefeuille.getMapFonds().get(cleFonds).getAmount()/cpt)*100;
            System.out.println("Le pourcentage du fonds " + cleFonds + " dans l'instrument " + iter + " est de : " + pourcentage);
        }
        return pourcentage;
    }
    
}
