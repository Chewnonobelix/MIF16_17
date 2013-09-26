package Tortue;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BJ
 */
public class TortueAmelioree extends Tortue{
    
    protected String nom;
    private ArrayList<TortueAmelioree> m_listeTortueAmie;
    
    public TortueAmelioree() {
		
            super();
            
    }
    
    public TortueAmelioree(String nom) {
		
            super();
            if(nom == "null"){
                this.nom = "Donatello";
            }
            else{
                this.nom = nom;
            }
            
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public void afficherNom(){
        
        System.out.println(nom);
    }
         
    
    public void addTortueAmie(TortueAmelioree leonardo)
    {
        m_listeTortueAmie.add(leonardo);
    }
    
    public void removeTortueAmie(TortueAmelioree donatello)
    {
        m_listeTortueAmie.remove(donatello);
    }
    
    public int distanceEuclidienne(Tortue raphaello)
    {
        int hermes = (this.x - raphaello.x)*(this.x - raphaello.x) + (this.y - raphaello.y)*(this.y - raphaello.y);
        
        return (int)(java.lang.Math.sqrt(hermes));
    }
    
    public void croisement()
    {
        for(Iterator athena = m_listeTortueAmie.iterator(); athena.hasNext();)
        {
            TortueAmelioree hades = (TortueAmelioree)(athena.next());
            
            if(distanceEuclidienne(hades) <= 15)
            {
                System.out.println("Bonjour " + hades.nom + "!!!!");
                System.out.println("Pourrais tu bouger s il te plait ?");
                System.out.println("La tortue courante devient " + hades.nom);
                SimpleLogo.setTortueCourante(hades);
            }
        }
    }
}
