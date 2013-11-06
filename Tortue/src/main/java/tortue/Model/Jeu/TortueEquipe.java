/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import java.awt.Point;
import java.util.Iterator;
import java.util.Random;
import tortue.Model.Dessin.AbstractTortue;

/**
 *
 * @author Chewnonobelix
 */
public class TortueEquipe extends AbstractTortue
{
    public static final int deplacement = 5;
    
    private EquipeTortue m_equipe;
    private Balle m_balle;
    
    public TortueEquipe(EquipeTortue e) 
    {
        setLeve(true);
        m_equipe = e;
        setCouleur(e.getCouleur());
        Point pos = new Point();
        
        Random r = new Random();
        int tp = r.nextInt(400);
        pos.x = tp;
        
        tp = r.nextInt(600);
        pos.y = tp;
    }

    public Balle getBalle()
    {
        return m_balle;
    }

    public EquipeTortue getEquipe()
    {
        return m_equipe;
    }

    public void setBalle(Balle balle)
    {
        m_balle = balle;
    }

    public void setEquipe(EquipeTortue equipe) 
    {
        m_equipe = equipe;
    }
    
    public boolean hasBalle()
    {
        return getBalle() == null;
    }
    
    public void croise(TortueEquipe t)
    {
        if(t.hasBalle() && !getEquipe().getMembreEquipe().contains(t))
        {
            prendBalle(t);
        }
    }
    
    public void prendBalle(TortueEquipe adversaire)
    {
        setBalle(Balle.getBalle());
        adversaire.setBalle(null);
    }
            
    public void deplacement()
    {
        for(Iterator it = JeuDeBalle.getListeJoueur().iterator(); it.hasNext();)
        {
            TortueEquipe t = (TortueEquipe)it.next();
            
            if(getPosition().distance(t.getPosition()) <= 15)
            {
                croise(t);
            }
        }
        
        try 
        {
		Random rand = new Random();
		setAngle(rand.nextInt(90)-45);
		this.avancer(TortueEquipe.deplacement);
			
		/*if(getPosition().x + TortueEquipe.deplacement <= 15 ||
                        getPosition().x + TortueEquipe.deplacement >= SimpleLogo.feuille.getWidth()-0 || 
                        getPosition().y + TortueEquipe.deplacement >= SimpleLogo.feuille.getHeight()-0 || 
                        getPosition().y + TortueEquipe.deplacement <= 15)
                {
			this.droite(180);
			this.avancer(15);
                }*/		
	} 
        catch (NumberFormatException ex)
        {
		System.err.println("ce n'est pas un nombre : " + TortueEquipe.deplacement);
	}
	
    }
}

