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
import modele.Portefeuille;
        
/**
 *
 * @author Moi
 */
public class Serie implements Serializable {
    
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
    
    public void Lire(String fileName, Portefeuille portefeuille) throws FileNotFoundException, IOException
    {
    	FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois= new ObjectInputStream(fis);
        portefeuille.getMapFonds ();
    }
}
