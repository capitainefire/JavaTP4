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
import java.util.Scanner;
import javax.swing.border.TitledBorder;
import modele.Instrument;
import modele.InstrumentInexistant;
import modele.Portefeuille;

/**
 *
 * @author Amandine
 */
public class InterfaceGraphique extends JFrame implements ActionListener {

    private JPanel pan;
    private JPanel panajoutf;
    
    private JButton bouton[];
    private Scanner clavier = new Scanner(System.in);
    private Portefeuille portefeuille = new Portefeuille();
    
    public InterfaceGraphique()
    {
        // Titre
        this.setTitle("Menu");
        
        // Taille de la fenetre
        this.setSize(800,500);
        
        // Fenetre au milieu de l'ecran
        this.setLocationRelativeTo(null);

        // On instancie un objet JPanel
        pan = new JPanel();
        
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
            bouton[0].setText("Vous avez appuyer sur le bouton 0");
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
            bouton[2].setText("Vous avez appuyer sur le bouton 2");
        }
        
        
        
        // Si la source de l action est lactivation du bouton 3
        // Recherche d'un instrument
        if (e.getSource() == bouton[3])
        {
            String cleI;
            System.out.println("Entrez la cle pour l'instrument : ");
            cleI = clavier.nextLine();   
        
            try {
                portefeuille.rechercheInstrument(cleI);
                for(int i=0; i<portefeuille.rechercheInstrument(cleI).size(); i++)
                {
                    //bouton[1].setText(portefeuille.rechercheInstrument(cleI)[i]);
                }
                
            } catch (InstrumentInexistant ex2) {
                
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
    }

}
