/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.TitledBorder;
import modele.Fonds;
import modele.FondsExistant;
import modele.FondsInexistant;
import modele.Instrument;
import modele.InstrumentInexistant;
import modele.Portefeuille;
import modele.Serie;

/**
 *
 * @author Amandine
 */
public class InterfaceGraphique extends JFrame implements ActionListener {

    private JPanel pan;
    private JPanel panajoutf;
    
    private JButton bouton[];
    private Scanner clavier = new Scanner(System.in);
    private Portefeuille portefeuille;
    private Serie serie;
    
    public InterfaceGraphique(Portefeuille Pportefeuille, Serie Pserie)
    {
        portefeuille = Pportefeuille;
        serie = Pserie;
        
        // Titre
        this.setTitle("Menu");
        
        // Taille de la fenetre
        this.setSize(800,500);
        
        // Fenetre au milieu de l'ecran
        this.setLocationRelativeTo(null);

        // On instancie un objet JPanel
        pan = new JPanel();
        pan.setLayout(new GridLayout(10,1));
        
        // On instancie nos bouton
        bouton = new JButton[10];

        bouton[0] = new JButton("Serialiser le portefeuille dans un fichier");
        bouton[1] = new JButton("De-serialiser les objets du portefeuille d un fichier");
        bouton[2] = new JButton("Recherche d un fond");
        bouton[3] = new JButton("Recherche d un instrument");
        bouton[4] = new JButton("Ajout d un nouveau fond dans un instrument");
        bouton[5] = new JButton("Suppression d un fond");
        bouton[6] = new JButton("Ajout d un instrument");
        bouton[7] = new JButton("Suppression d un instrument");
        bouton[8] = new JButton("Statistiques");
        bouton[9] = new JButton("Quitter la fenetre d accueil");
        
        for(int i=0; i<bouton.length; i++)
        {
            // Ajout du bouton sur pan
            pan.add(bouton[i]);
        }
        
        // On recupere le contenant et on lui ajoute les boutons
        this.getContentPane().add(pan);

        //On appelle les fonctions pour l'activation des Boutons
        for(int i=0; i<bouton.length; i++)
        {
            // Ajout du bouton sur pan
            bouton[i].addActionListener(this);
        }

        // On ferme le programme en fermant la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // On previent notre fenetre que notre JPanel sera son content pane
        this.setContentPane(pan);
        
        //On affiche la Fenetre
        this.setVisible(true);
        
    }
    
    // Fonction nous permettant de donner des instructions aux Boutons
    public void actionPerformed(ActionEvent e)
    {
        // Si la source de l action est l activation du bouton 0
        // Serialiser le portefeuille dans un fichier
        if (e.getSource() == bouton[0]) 
        {
            try {
                serie.Ecrire(portefeuille);
                JOptionPane pan2 = new JOptionPane();
                pan2.showMessageDialog(null, "Sérialisation des 2 Hashmaps", "Sérialisation ", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceGraphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        // Si la source de l action est l activation du bouton 1
        // De-serialiser les objets du portefeuille d un fichier
        if (e.getSource() == bouton[1]) 
        {
            try {
                serie.Lire(portefeuille);
                JOptionPane pan2 = new JOptionPane();
                pan2.showMessageDialog(null, "Désérialisation des 2 Hashmaps", "Sérialisation ", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceGraphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
  
        
        // Si la source de l action est l activation du bouton 2
        // Recherche d'un fond
        if (e.getSource() == bouton[2]) 
        {
            JOptionPane pan2 = new JOptionPane();
            JOptionPane pan21 = new JOptionPane();
            String nom = pan2.showInputDialog(null, "Veuillez saisir la clé du fond que vous recherchez : ", JOptionPane.QUESTION_MESSAGE);
            try {
                double montant = portefeuille.rechercheFonds(nom);
                pan21.showMessageDialog(null, "Valeur de ce fonds " + montant, "Fonds " + nom, JOptionPane.INFORMATION_MESSAGE);
            } catch (FondsInexistant ex) {
                pan21.showMessageDialog(null, "Le fonds n'a pas été trouvé", "Fonds inexistant", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        // Si la source de l action est lactivation du bouton 3
        // Recherche d'un instrument
        if (e.getSource() == bouton[3])
        {
            JOptionPane pan2 = new JOptionPane();
            JOptionPane pan21 = new JOptionPane();
            ArrayList<Fonds> ListFonds;
            String fonds = "";
            String nom = pan2.showInputDialog(null, "Veuillez saisir la clé de l'instrument que vous recherchez : ", JOptionPane.QUESTION_MESSAGE);
            try {
                ListFonds = portefeuille.rechercheInstrument(nom);
                for(int i=0; i<ListFonds.size(); i++)
                {
                    fonds += "Fonds " + ListFonds.get(i).getKey() + " de valeur : " + ListFonds.get(i).getAmount() + "\n";
                }
                pan21.showMessageDialog(null, fonds, "Instrument " + nom, JOptionPane.INFORMATION_MESSAGE);
            
            } catch (InstrumentInexistant ex) {
                pan21.showMessageDialog(null, "L'instrument n'a pas été trouvé", "Instrument inexistant", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Si la source de l action est l activation du bouton 4
        // Ajout d un fond
        if (e.getSource() == bouton[4]) 
        {
            JOptionPane pan2 = new JOptionPane();
            JOptionPane pan21 = new JOptionPane();
            
            
            String nom = pan2.showInputDialog(null, "Veuillez saisir la clé du fonds que voulez créer : ", JOptionPane.QUESTION_MESSAGE);
            String montant = pan2.showInputDialog(null, "Veuillez saisir le montant du fonds que voulez créer : ", JOptionPane.QUESTION_MESSAGE);
            double montant1 = Double.parseDouble(montant);
        
            try {
                portefeuille.rechercheFonds(nom);
                FondsExistant lol1 = new FondsExistant();
            } catch (FondsInexistant ex) {
                try {
                    portefeuille.ajouterFdansF(nom, montant1);
                    String instru = pan2.showInputDialog(null, "Veuillez saisir l'instrument dans lequel vous voulez ajouter ce nouveau fond : ", JOptionPane.QUESTION_MESSAGE);
                    portefeuille.ajouterFdansI(instru, portefeuille.getMapFonds().get(nom));
                } catch (FondsExistant ex1) {
                    ex1 = new FondsExistant();
                   pan21.showMessageDialog(null, "Le fonds n'a pas été créé.", "Fonds déjà existant", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        // Si la source de l action est l activation du bouton 4
        // Suppression d un fonds
        if (e.getSource() == bouton[5]) 
        {
            JOptionPane pan2 = new JOptionPane();
            
            String cleSuppr = pan2.showInputDialog(null, "Veuillez saisir la clé du fonds que voulez supprimer : ", JOptionPane.QUESTION_MESSAGE);
            portefeuille.supprimerFonds(cleSuppr);
        }
        
        // Si la source de l action est l activation du bouton 4
        // Ajout d un instrument
        if (e.getSource() == bouton[6]) 
        {
            JOptionPane pan2 = new JOptionPane();
            JOptionPane pan21 = new JOptionPane();            
            
            String cleI = pan2.showInputDialog(null, "Veuillez saisir la clé de l'instrument que voulez créer : ", JOptionPane.QUESTION_MESSAGE);        
            try {
                portefeuille.rechercheInstrument(cleI);
                pan21.showMessageDialog(null, "L'instrument n'a pas été créé.", "Instrument déjà existant", JOptionPane.ERROR_MESSAGE);
            } catch (InstrumentInexistant ex2) {
                Instrument tmpInstru = new Instrument(cleI);
                portefeuille.ajouterIdansI(cleI, tmpInstru);
            }            
        }
        
        // Si la source de l action est l activation du bouton 4
        // Suppression d un instrument
        if (e.getSource() == bouton[7]) 
        {
            JOptionPane pan2 = new JOptionPane();
            
            String cleSuppr = pan2.showInputDialog(null, "Veuillez saisir la clé de l'instrument que voulez supprimer : ", JOptionPane.QUESTION_MESSAGE);
            portefeuille.supprimerInstrument(cleSuppr);
        }
        
        if (e.getSource() == bouton[8])
        {
            JOptionPane pan2 = new JOptionPane();
            JOptionPane pan21 = new JOptionPane();
            String fonds = "";
            String nom = pan2.showInputDialog(null, "Veuillez saisir la clé du fonds dont vous voulez connaître le pourcentage : ", JOptionPane.QUESTION_MESSAGE);
            double pourcentage = 0;
            try {
                portefeuille.rechercheFonds(nom);
                
                Set<String> cles = portefeuille.getMapInstrument().keySet();
                Iterator<String> it = cles.iterator();
                String iter = "";

                while(it.hasNext())
                {
                    iter = it.next();
                    Instrument valeur = portefeuille.getMapInstrument().get(iter);
                    double cpt = 0;
                    pourcentage = 0;
                    if(valeur.rechercherFdansI(nom))
                    {
                        // Somme
                        for(int i=0; i< valeur.getArrayFonds().size();i++)
                        {
                            cpt += valeur.getArrayFonds().get(i).getAmount();
                        }
                        pourcentage = portefeuille.getMapFonds().get(nom).getAmount();
                        pourcentage = (pourcentage/cpt)*100;
                        fonds += "Le pourcentage du fonds " + nom + " dans l'instrument " + iter + " est de : " + pourcentage + "\n";
                    }
                }          
                
                if(fonds == "")
                {
                    pan21.showMessageDialog(null, "Ce fonds n'est dans aucun instrument.", "Problème", JOptionPane.INFORMATION_MESSAGE);;
                    
                }
                else
                {
                    pan21.showMessageDialog(null, fonds, "Pourcentage du fonds " + nom, JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (FondsInexistant ex) {
                pan21.showMessageDialog(null, "Le fonds n'a pas été trouvé", "Fonds inexistant", JOptionPane.ERROR_MESSAGE);
            }

              
        }
        
        if (e.getSource() == bouton[9])
        {
            System.exit(0);
        }
    }

}
