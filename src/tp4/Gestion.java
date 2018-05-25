/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amandine
 */
public class Gestion {
    /** main
     * @param args */
    public static void main(String[] args) {
        Portefeuille portefeuille = new Portefeuille();
        Scanner clavier;
        String cle = "";
        double fonds = 0;
        System.out.print("Entrez la cle : ");
        clavier = new Scanner(System.in);
        cle = clavier.nextLine();
        System.out.print("Entrez le montant : ");
        clavier = new Scanner(System.in);
        fonds = clavier.nextDouble();
        
        try {
            portefeuille.ajouterFdansF("a", 10);
            portefeuille.ajouterFdansF("b", 20);
        } catch (FondsExistant ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        try {
            portefeuille.rechercheFonds(cle);
            FondsExistant e = new FondsExistant();
        } catch (FondsInexistant ex) {
            try {
                portefeuille.ajouterFdansF(cle, fonds);
            } catch (FondsExistant ex1) {
                ex1 = new FondsExistant();
            }
        }
        
        Set<String> cles = portefeuille.getMapFonds().keySet();
        System.out.println("Taille du set : " + cles.size());
        Iterator<String> it = cles.iterator();
        String iter = "";
        
        while(it.hasNext())
        {
            iter = it.next();
            System.out.println("La cle est : " + iter);
            System.out.println("amount : " + portefeuille.getMapFonds().get(iter).getAmount());
        }
        
        
        Instrument instrument = new Instrument();
        //instrument.trier();
    }

}
