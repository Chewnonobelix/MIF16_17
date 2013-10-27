/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur;

import java.util.ArrayList;
import tortue.Model.Dessin.*;
/**
 *
 * @author Arnaud
 */
public class ControleurDessin extends AbstractControleur
{
    private ArrayList<ConcreteTortue> m_tabTortue;

    public ControleurDessin() 
    {
        m_tabTortue = new ArrayList<ConcreteTortue>();
    }
    
    public void reset()
    {
        //TODO
    }
    
    //TODO
    // avancer de n pas
    /*public void avancer(int dist) {
            int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*dir));
            int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*dir));

            if (crayon==true) {
                    Segment seg = new Segment();

                    seg.ptStart.x = x;
                    seg.ptStart.y = y;
                    seg.ptEnd.x = newX;
                    seg.ptEnd.y = newY;
                    seg.color = decodeColor(coul);

                    listSegments.add(seg);
            }

            x = newX;
            y = newY;
    }



    // aller a droite
    public void droite(int ang) {
            dir = (dir + ang) % 360;
    }

    // aller a gauche
    public void gauche(int ang) {
            dir = (dir - ang) % 360;
    }

    // baisser le crayon pour dessiner
    public void baisserCrayon() {
            crayon = true;
    }

    // lever le crayon pour ne plus dessiner
    public void leverCrayon() {
            crayon = false;
    }

    // pour changer de couleur de dessin
    public void couleur(int n) {
            coul = n % 12;
    }

    public void couleurSuivante() {
            couleur(coul+1);
    }

    /** quelques classiques */

    /*public void carre() {
            for (int i=0;i<4;i++) {
                    avancer(100);
                    droite(90);
            }
    }

    public void rectangle(int longueur, int largeur) {

            avancer(longueur);
            droite(90);
            avancer(largeur);
            droite(90);
            avancer(longueur);
            droite(90);
            avancer(largeur);
            droite(90);
    }

    public void poly(int n, int a) //n largeur des coté, a nombre de sommet 
    {
            for (int j=0;j<a;j++) {
                    avancer(n);
                    droite(360/a);
            }
    }

    public void spiral(int n, int k, int a) {
            for (int i = 0; i < k; i++) {
                    couleur(coul+1);
                    avancer(n);
                    droite(360/a);
                    n = n+1;
            }
    }

    public void maison() {

            // Murs
            carre();

            //Toit
            avancer(100);
            droite(30);
            poly(100,3);

            //Fenêtre
            leverCrayon();
            droite(60);
            avancer(40);
            droite(90);
            avancer(20);
            baisserCrayon();
            poly(30,4);

            //Porte
            leverCrayon();
            avancer(80);
            gauche(90);
            avancer(20);
            gauche(90);
            baisserCrayon();
            rectangle(50,30);

    }

    public void etoile(int nbBranche, int taille)
    {
        int artemis = 360/nbBranche; //Angle des branches
        dir = 0;
        for(int zeus = 0; zeus < nbBranche; zeus ++)
        {
            avancer(taille);
            leverCrayon();
            avancer(-taille);
            baisserCrayon();
            dir += artemis;
        }
    }*/
}
