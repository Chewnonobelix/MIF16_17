/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tortue;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author bjidée
 */
public class EquipeTortue {
    
    private ArrayList<TortueEquipe> equipe;
    private FeuilleDessin feuille;
    private String nom_equipe;
    
    
    public EquipeTortue(FeuilleDessin feuille, String nom_equipe, int nb, Color color) {
        this.feuille = feuille;
        equipe = new ArrayList();
        this.nom_equipe = nom_equipe;
                
        for(int i = 0; i < nb; i++){
            
            TortueEquipe tortue = new TortueEquipe("tortue"+i,this,color);
            this.equipe.add(tortue);
            feuille.addTortue(tortue);
            
            
            tortue.setPosition(500 / 2, 400 / 2);
            tortue.leverCrayon();
        }        
        
    }

    public ArrayList<TortueEquipe> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<TortueEquipe> equipe) {
        this.equipe = equipe;
    }

    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void setFeuille(FeuilleDessin feuille) {
        this.feuille = feuille;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }
    
    
    
    
}
