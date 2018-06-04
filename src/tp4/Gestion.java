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
import modele.FondsExistant;
import modele.FondsInexistant;
import modele.Instrument;
import modele.InstrumentInexistant;
import modele.Portefeuille;
import vue.InterfaceConsole;
import vue.InterfaceGraphique;

/**
 *
 * @author Amandine
 */
public class Gestion {
    /** main
     * @param args */
    public static void main(String[] args) {
        
        InterfaceGraphique intergraph = new InterfaceGraphique();
        
        Portefeuille portefeuille = new Portefeuille();
        Scanner clavier;
        String cle = "";
        double fonds = 0;
        
        //Ajout de fonds et d'instruments test
        try {
            portefeuille.ajouterFdansF("a", 10);
            portefeuille.ajouterFdansF("b", 20);
            portefeuille.ajouterFdansF("c", 30);
            portefeuille.ajouterFdansF("d", 40);
        } catch (FondsExistant ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        Instrument A = new Instrument("InstruA");
        portefeuille.ajouterIdansI("InstruA", A);
        Instrument B = new Instrument("InstruB");
        portefeuille.ajouterIdansI("InstruB", B);
        
        portefeuille.ajouterFdansI("InstruA", portefeuille.getMapFonds().get("a"));
        portefeuille.ajouterFdansI("InstruA", portefeuille.getMapFonds().get("b"));
        portefeuille.ajouterFdansI("InstruA", portefeuille.getMapFonds().get("c"));
        portefeuille.ajouterFdansI("InstruB", portefeuille.getMapFonds().get("b"));
        portefeuille.ajouterFdansI("InstruB", portefeuille.getMapFonds().get("d"));
        
        //Ajout d'un fond par l'utilisateur
        System.out.print("Entrez la cle pour le fonds : ");
        clavier = new Scanner(System.in);
        cle = clavier.nextLine();
        System.out.print("Entrez le montant : ");
        clavier = new Scanner(System.in);
        fonds = clavier.nextDouble();
        
        try {
            portefeuille.rechercheFonds(cle);
            FondsExistant e = new FondsExistant();
        } catch (FondsInexistant ex) {
            try {
                portefeuille.ajouterFdansF(cle, fonds);
            } catch (FondsExistant ex1) {
                ex1 = new FondsExistant();
                System.out.println("Le fonds n'a donc pas été créé.");
            }
        }
        
        portefeuille.ajouterFdansI("InstruB", portefeuille.getMapFonds().get(cle));
        
        //Affichage des fonds
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
        
        //Création d'un nouvel instrument par l'utilisateur
        String cleI;
        System.out.print("Entrez la cle pour l'instrument : ");
        clavier = new Scanner(System.in);
        cleI = clavier.nextLine();   
        
        try {
            portefeuille.rechercheInstrument(cleI);
            System.out.println("Cet instrument existe déjà.");
        } catch (InstrumentInexistant ex2) {
            Instrument tmpInstru = new Instrument(cleI);
            portefeuille.ajouterIdansI(cleI, tmpInstru);
        }
        portefeuille.getMapInstrument().get(cleI).ajouter(portefeuille.getMapFonds().get(cle));
        
        //Affichage des instruments
        InterfaceConsole console = new InterfaceConsole();
        console.afficherInstrument(portefeuille);
        
        System.out.println("");
        String cleRecherche;
        System.out.print("Entrez la cle du fonds dont vous voulez connaitre le pourcentage dans chaque instrument : ");
        clavier = new Scanner(System.in);
        cleRecherche = clavier.nextLine();
        
        console.rechercher(cleRecherche, portefeuille);        
        
        InterfaceConsole vue = new InterfaceConsole();
        
        System.out.println("Rentrer la clé d'un instrument afin d'afficher ses fonds triés : ");
        String cleAfficheInstrument = clavier.nextLine();
        vue.AfficheFondsTrie(portefeuille ,cleAfficheInstrument);
        
        System.out.println("Rentrer la clé d'un fond que vous voulez supprimer : ");
        clavier = new Scanner(System.in);
        String cleSuppr = clavier.nextLine();
        portefeuille.supprimerFonds(cleSuppr);
        
        System.out.println("Rentrer la clé d'un instrument que vous voulez supprimer : ");
        clavier = new Scanner(System.in);
        String cleISuppr = clavier.nextLine();
        portefeuille.supprimerInstrument(cleISuppr);
        
        System.out.println("Affichage des fonds");
        cles = portefeuille.getMapFonds().keySet();
        System.out.println("Taille du set : " + cles.size());
        it = cles.iterator();
        iter = "";
        
        while(it.hasNext())
        {
            iter = it.next();
            System.out.println("La cle est : " + iter);
        }
        System.out.println("Affichage des instruments");
        console.afficherInstrument(portefeuille);
    }

}
