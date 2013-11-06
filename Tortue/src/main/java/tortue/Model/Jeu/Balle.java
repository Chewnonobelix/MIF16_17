/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import tortue.Model.Dessin.AbstractTortue;

/**
 *
 * @author Chewnonobelix
 */
public class Balle 
{
    static private Balle m_singleton = null;
    
    AbstractTortue m_possesseur = null;
    
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
        m_possesseur = possesseur;
    }
}
