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
    private ArrayList<Tortue> m_listeTortueAmie;
    
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

    public ArrayList<Tortue> getM_listeTortueAmie() {
        return m_listeTortueAmie;
    }

    public void setM_listeTortueAmie(ArrayList<Tortue> m_listeTortueAmie) {
        this.m_listeTortueAmie = m_listeTortueAmie;
    }

    
    public void afficherNom(){
        
        System.out.println(nom);
    }
         
    
    public void addTortueAmie(Tortue leonardo)
    {
        if(leonardo != this){
            m_listeTortueAmie.add(leonardo);
        }
        
    }
    
    public void removeTortueAmie(Tortue donatello)
    {
        m_listeTortueAmie.remove(donatello);
    }
    
    public void removeTortueAmieI(int i)
    {
        m_listeTortueAmie.remove(i);
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
                hades.deplacement(15);
            }
        }
    }
    

    public void deplacement(int n){
	try {
		Random rand = new Random();
		this.droite(rand.nextInt(90)-45);
		this.avancer(n);
			
		if(this.x + n <= 15 || this.x + n >= SimpleLogo.feuille.getWidth()-0 || 
                        this.y + n >= SimpleLogo.feuille.getHeight()-0 || this.y + n <= 15){
			this.droite(180);
			this.avancer(15);
        }
			
	} catch (NumberFormatException ex){
		System.err.println("ce n'est pas un nombre : " + n);
	}
	
    }
}
