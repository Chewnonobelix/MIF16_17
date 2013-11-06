/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import java.awt.Point;
import tortue.Model.Dessin.AbstractTortue;

/**
 *
 * @author Chewnonobelix
 */
public class Balle 
{
    static private Balle m_singleton = null;
    
    private AbstractTortue m_possesseur = null;
    private Point m_pos = new Point(300,200);
    
    private Balle()
    {    
    }
    
    public static Balle getBalle()
    {
        if(m_singleton == null)
        {
            m_singleton = new Balle();
        }
        
        return m_singleton;
    }

    public AbstractTortue getPossesseur()
    {
        return m_possesseur;
    }

    public void setPossesseur(AbstractTortue possesseur) 
    {
        if(possesseur == null)
        {
            setPos((Point)m_possesseur.getPosition().clone());
        }
        else
        {
            setPos(null);
        }
        
        m_possesseur = possesseur;
    }

    public void setPos(Point pos) 
    {
        this.m_pos = pos;
    }

    public Point getPos() {
        return m_pos;
    }
    
    
}
