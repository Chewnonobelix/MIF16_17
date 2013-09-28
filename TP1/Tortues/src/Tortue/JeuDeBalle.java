/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tortue;

import static Tortue.SimpleLogo.feuille;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author bjidée
 */
public class JeuDeBalle {
    
    private FeuilleDessin feuille;
    
    private ArrayList<Tortue> joueurs;

    public JeuDeBalle(FeuilleDessin feuille, ArrayList<Tortue> joueurs) {
        this.feuille = feuille;
        this.joueurs = joueurs;
    }

    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void setFeuille(FeuilleDessin feuille) {
        this.feuille = feuille;
    }

    public ArrayList<Tortue> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Tortue> joueurs) {
        this.joueurs = joueurs;
    }
    
    public void lancePartie(Timer timer){
        
	timer.schedule (new TimerTask() {
            public void run()
            {
                TortueAmelioree temp = null;
                
            	for(int i = 0; i < 15; i++){
            
                    temp = (TortueAmelioree)feuille.getTortues().get(i);
                    temp.deplacement(20);
                    temp.croisement();
                    feuille.repaint();
                
                }
            }
        }, 0, 500);
    }
    
    
}
