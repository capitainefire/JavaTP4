/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
        
/**
 *
 * @author Moi
 */
public class Serie implements Serializable {
    
    public Serie()
    {
    }
    
    public void Ecrire(Portefeuille portefeuille) throws FileNotFoundException, IOException
    {
    	FileOutputStream fos = new FileOutputStream("Hashfond.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try 
        {
                oos.writeObject(portefeuille.getMapFonds());
                oos.flush();
        } finally 
        {
                oos.close();
                fos.close();
        }
        fos = new FileOutputStream("Hashinstru.ser");
        oos = new ObjectOutputStream(fos);
        try 
        {
                oos.writeObject(portefeuille.getMapInstrument());
                oos.flush();
        } finally 
        {
                oos.close();
                fos.close();
        }
    }
    
    public void Lire(Portefeuille portefeuille) throws FileNotFoundException, IOException
    {
        HashMap<String, Fonds> mapFonds;
        HashMap<String, Instrument> mapInstrument;
        
    	FileInputStream fis = new FileInputStream("Hashfond.ser");
        ObjectInputStream ois= new ObjectInputStream(fis);
        try {
            mapFonds = (HashMap) ois.readObject();
            portefeuille.getMapFonds().clear();
            portefeuille.getMapFonds().putAll(mapFonds);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, ex);
        }
        ois.close();
        fis.close();
        
        fis = new FileInputStream("Hashfond.ser");
        ois= new ObjectInputStream(fis);
        try {
            mapInstrument = (HashMap) ois.readObject();
            portefeuille.getMapFonds().clear();
            portefeuille.getMapInstrument().putAll(mapInstrument);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, ex);
        }
        ois.close();
        fis.close();
    }
}
