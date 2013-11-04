/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tortue;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author bjidée
 */
public class JeuEquipe {
    
    private FeuilleDessin feuille;
    private int score;
    private JTextArea area;

    public JeuEquipe(FeuilleDessin feuille) {
        this.feuille = feuille;
        this.score = 0;
        area = new JTextArea();
        this.feuille.add(area);
        area.setBounds(2,2,10,15);
        
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
    public void lancePartie(Timer timer){
        
        EquipeTortue equipe1 = new EquipeTortue(feuille,"equipe1",10,Color.green);
        EquipeTortue equipe2 = new EquipeTortue(feuille,"equipe2",10,Color.blue);
                
        TortueEquipe temp2 = (TortueEquipe)feuille.getTortues().get(0);
        temp2.setBalle(true);
        
        timer = new Timer();      
        
	timer.schedule (new TimerTask() {
            public void run()
            {
                TortueEquipe temp = null;
                TortueEquipe temp2 = null;
                TortueEquipe recoit_balle = null;
                int dist_min = 500;
                        
                area.repaint();
                area.setText(""+score);
                
                
            	for(int i = 0; i < feuille.getTortues().size(); i++){
            
                    temp = (TortueEquipe)feuille.getTortues().get(i);
                    temp.deplacement(20);                 
                    feuille.repaint();
                
                }
                
                for(int i = 0; i < feuille.getTortues().size(); i++){
                    
                    
                    temp = (TortueEquipe)feuille.getTortues().get(i);
                    
                    if(temp.isBalle()){
                        
                        for(int j = 0; j < feuille.getTortues().size(); j++){
                            
                            temp2 = (TortueEquipe)feuille.getTortues().get(j);
                            
                            if(temp != temp2){
                                
                                if(temp.distanceEuclidienne(temp2) < dist_min){
                                    
                                    dist_min = temp.distanceEuclidienne(temp2);
                                    recoit_balle = temp2;
                                    
                                }
                                    
                            }
                            
                            
                        }
                        
                        break;
                    }
                }
                
                if(temp.getEquipe().getNom_equipe().equals(recoit_balle.getEquipe().getNom_equipe())){
                    
                    score++;
                    temp.setBalle(false);
                    recoit_balle.setBalle(true);
                    recoit_balle.deplacement(30);
                    
                }
                else if(temp.distanceEuclidienne(recoit_balle) <= 15){
                    
                    score = 0;
                    temp.setBalle(false);
                    recoit_balle.setBalle(true);
                    recoit_balle.deplacement(30);
                }               
                
                System.out.println(""+score);
                
            }     
        }, 0, 1000);
    }

}