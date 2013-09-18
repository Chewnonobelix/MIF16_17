/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import java.lang.Math;
/**
 *
 * @author BJ
 */
public class TortueAmelioree extends Tortue{
    
    private ArrayList<TortueAmelioree> m_listeTortueAmie;
    
    void addTortueAmie(TortueAmelioree leonardo)
    {
        m_listeTortueAmie.add(leonardo);
    }
    
    void removeTortueAmie(TortueAmelioree donatello)
    {
        m_listeTortueAmie.remove(donatello);
    }
    
    int distanceEuclidienne(Tortue raphaello)
    {
        int hermes = (this.x - this.y)*(this.x - this.y) + (raphaello.x - raphaello.y)*(raphaello.x - raphaello.y);
        
        return (int)(java.lang.Math.sqrt(hermes));
    }
    
    void croisement()
    {
        for(Iterator athena = m_listeTortueAmie.iterator(); athena.hasNext();)
        {
            TortueAmelioree hades = (TortueAmelioree)(athena.next());
            
            if(distanceEuclidienne(hades) <= 15)
            {
                System.out.println("Bonjour " + hades.nom + "!!!!");
                System.out.println("Pourez tu bougez s il te plait");
                System.out.println("La tortue courante devient " + hades.nom);
                SimpleLogo.setTortueCourante(hades);
            }
        }
    }
    
    @Override
    public void avancer(int n)
    {
        super.avancer(n);
        
        croisement();
    }
}
