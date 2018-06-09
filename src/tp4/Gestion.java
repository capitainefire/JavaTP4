/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.io.IOException;
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
import modele.Serie;
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
        
        Portefeuille portefeuille = new Portefeuille();
        Serie serie = new Serie();
        Scanner clavier;
        String cle = "";
        double fonds = 0;
        InterfaceConsole console = new InterfaceConsole();
        InterfaceGraphique intergraph = new InterfaceGraphique(portefeuille, serie);
        
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
    }
}
