
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tortue;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author bjidée
 */
public class JeuDeBalle {
    
    private FeuilleDessin feuille;
    

    public JeuDeBalle(FeuilleDessin feuille) {
        this.feuille = feuille;
    }

    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void setFeuille(FeuilleDessin feuille) {
        this.feuille = feuille;
    }
    
    public void lancePartie(Timer timer){
           
        TortueBalle temp = null;
        
        for(int i = 0; i < 20; i++){
            
            TortueBalle tortue = new TortueBalle("tortue"+i);
            feuille.addTortue(tortue);
            
            tortue.setPosition(500 / 2, 400 / 2);
            tortue.leverCrayon();
        }
        
        
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(20 - 0 + 1) + 0;
        
        ((TortueBalle)feuille.getTortue(nombreAleatoire)).setBalle(true);          
            
        timer = new Timer();      
        
	timer.schedule (new TimerTask() {
            public void run()
            {
                TortueBalle temp = null;
                TortueBalle temp2 = null;
                
            	for(int i = 0; i < feuille.getTortues().size(); i++){
            
                    temp = (TortueBalle)feuille.getTortues().get(i);
                    temp.deplacement(20);                 
                    feuille.repaint();
                
                }
                for(int i = 0; i < feuille.getTortues().size(); i++){
                    
                    temp = (TortueBalle)feuille.getTortues().get(i);
                    
                    if(temp.isBalle()){
                        
                        for(int j = 0; j < feuille.getTortues().size(); j++){
                            
                            temp2 = (TortueBalle)feuille.getTortues().get(j);
                            
                            if(temp != temp2 && temp.distanceEuclidienne(temp2) <= 15){
                                                              
                                temp.setBalle(false);
                                temp2.setBalle(true);
                                temp2.deplacement(30);
                                break;                            
                                
                            }
                        }
                        
                    }
                }
                feuille.repaint();
                
            }
        }, 0, 500);
    }
    
    
}
