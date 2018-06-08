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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.TitledBorder;
import modele.Fonds;
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
        bouton[4] = new JButton("Ajout d un fond");
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
            } catch (IOException ex) {
                Logger.getLogger(InterfaceGraphique.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane pan2 = new JOptionPane();
            pan2.showMessageDialog(null, "Sérialisation des 2 Hashmaps", "Sérialisation ", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        // Si la source de l action est l activation du bouton 1
        // De-serialiser les objets du portefeuille d un fichier
        if (e.getSource() == bouton[1]) 
        {
            bouton[1].setText("Vous avez appuyer sur le bouton 1");
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
            //le "PAGE_AXIS" permet d'afficher tout a la suite verticalement
            //pour tout afficher horizontalement c'est LINE_AXIS
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

            //Rectangle Informations
            panajoutf = new JPanel();
            panajoutf.setLayout(new BoxLayout(panajoutf, BoxLayout.PAGE_AXIS));
            panajoutf.setBorder(new TitledBorder(null, "Ajout d'un fond", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panajoutf.setPreferredSize(new Dimension(this.getWidth(), 300));       
            panajoutf.setBackground(new Color(187,164,230));
        }
        
        if (e.getSource() == bouton[9])
        {
            System.exit(0);
        }
    }

}
