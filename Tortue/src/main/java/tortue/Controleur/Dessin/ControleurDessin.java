/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import java.awt.Point;
import java.util.ArrayList;
import tortue.Controleur.AbstractControleur;
import tortue.Model.Dessin.*;

/**
 *
 * @author Arnaud
 */
public class ControleurDessin extends AbstractControleur
{
    private ArrayList<ConcreteTortue> m_tabTortue;
    private ConcreteTortue m_tortueCourante;
    private TortueFactory m_factory;
    
    public ControleurDessin() 
    {
        m_tabTortue = new ArrayList<ConcreteTortue>();
        m_factory = new TortueFactory();
    }

    @Override
    public void exec() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void reset()
    {
        //TODO
    }
    
    
    // avancer de n pas
    public void avancer(int dist) 
    {
        int x = m_tortueCourante.getPosition().x;
        int y = m_tortueCourante.getPosition().y;
                
            int newX = (int) Math.round(x+dist*Math.cos(AbstractTortue.ratioDegRad*m_tortueCourante.getAngle()));
            int newY = (int) Math.round(y+dist*Math.sin(AbstractTortue.ratioDegRad*m_tortueCourante.getAngle()));

            if (m_tortueCourante.isLeve() == false) 
            {
                m_tortueCourante.deplacement(new Point(newX, newY));
            }

            m_tortueCourante.getPosition().x = newX;
            m_tortueCourante.getPosition().y = newY;
    }


    
    // aller a droite
   public void droite(int ang) 
   {
            m_tortueCourante.setAngle((m_tortueCourante.getAngle() + ang)%360);
    }

    // aller a gauche
    public void gauche(int ang) 
    {
            m_tortueCourante.setAngle((m_tortueCourante.getAngle() - ang)%360);
   }

    // baisser le crayon pour dessiner
    public void baisserCrayon() 
    {
            m_tortueCourante.setLeve(false);
    }

    // lever le crayon pour ne plus dessiner
    public void leverCrayon() 
    {
            m_tortueCourante.setLeve(true);
     }

    //TODO
    
    // pour changer de couleur de dessin
    /*public void couleur(int n) {
            coul = n % 12;
    }

    public void couleurSuivante() {
            couleur(coul+1);
    }*/

    /** quelques classiques */

    public void carre() 
    {
            for (int i=0;i<4;i++) 
            {
                    avancer(100);
                    droite(90);
            }
    }

    public void rectangle(int longueur, int largeur) 
    {

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
            for (int j=0;j<a;j++) 
            {
                    avancer(n);
                    droite(360/a);
            }
    }

    public void spiral(int n, int k, int a) 
    {
            for (int i = 0; i < k; i++) 
            {
                    //couleur(coul+1);
                    avancer(n);
                    droite(360/a);
                    n = n+1;
            }
    }

    public void maison() 
    {

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
        int dir = m_tortueCourante.getAngle();
        for(int zeus = 0; zeus < nbBranche; zeus ++)
        {
            avancer(taille);
            leverCrayon();
            avancer(-taille);
            baisserCrayon();
            dir += artemis;
            m_tortueCourante.setAngle(dir);
        }
    }
}
