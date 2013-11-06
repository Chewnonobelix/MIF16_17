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
    public static final int deplacement = 10;
    
    private EquipeTortue m_equipe;
    private Balle m_balle;
    
    public TortueEquipe(EquipeTortue e) 
    {
        setLeve(true);
        m_equipe = e;
        setCouleur(e.getCouleur());
        Point pos = new Point();
        
        Random r = new Random();
        r.setSeed(0);
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
        if(Balle.getBalle().getPossesseur() == null)
        {
            if(getPosition().distance(Balle.getBalle().getPos()) <= 15)
            {
                m_balle = Balle.getBalle();
                m_balle.setPossesseur(this);
            }
        }
        
        if(t.hasBalle() && getEquipe().getMembreEquipe().contains(t))
        {
            prendBalle(t);
        }
    }
    
    public void prendBalle(TortueEquipe adversaire)
    {
        setBalle(Balle.getBalle());
        getBalle().setPossesseur(this);
        adversaire.setBalle(null);
    }
         
    public void but()
    {
        Point posPanier = JeuEquipe.panier.getPosition();

        if(hasBalle() && getPosition().x >= posPanier.x &&
                getPosition().x < posPanier.x + Panier.taille &&
                getPosition().y >= posPanier.y &&
                getPosition().y < posPanier.y + Panier.taille )
        {
            getEquipe().scorePP();
        }
    }
    public void deplacement()
    {
        but();
        
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
		setAngle(rand.nextInt(360));
		this.avancer(TortueEquipe.deplacement);
			
				
	} 
        catch (NumberFormatException ex)
        {
		System.err.println("ce n'est pas un nombre : " + TortueEquipe.deplacement);
	}
	
    }
}

