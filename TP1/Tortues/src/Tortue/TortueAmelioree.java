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
    
}
