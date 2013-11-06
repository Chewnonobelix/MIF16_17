/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Arnaud
 */
public class Panier 
{
    static final public int taille = 100;
    
    private Point m_position;
    
    public Panier()
    {
        Random r = new Random();
        
        m_position = new Point();
        
        m_position.x = r.nextInt(550);
        m_position.y = r.nextInt(250);
    }

    public Point getPosition() {
        return m_position;
    }
    
    
}
