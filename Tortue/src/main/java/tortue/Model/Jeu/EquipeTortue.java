/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Chewnonobelix
 */
public class EquipeTortue 
{
    public static final int tailleEquipe = 11;
    private String m_nomEquipe;
    private Color m_couleur = Color.BLACK;
    private ArrayList<TortueEquipe> m_membreEquipe = new ArrayList<>();

    public EquipeTortue() 
    {
        for(int i = 1; i <= tailleEquipe; i++)
        {
            TortueEquipe t = new TortueEquipe(this);
            m_membreEquipe.add(t);
            JeuDeBalle.addJoueur(t);
        }
    }

    public Color getCouleur() 
    {
        return m_couleur;
    }

    public ArrayList<TortueEquipe> getMembreEquipe()
    {
        return m_membreEquipe;
    }

    public String getNomEquipe()
    {
        return m_nomEquipe;
    }

    public void setCouleur(Color couleur) 
    {
        m_couleur = couleur;
    }

    public void setMembreEquipe(ArrayList<TortueEquipe> membreEquipe)
    {
        m_membreEquipe = membreEquipe;
    }

    public void setNomEquipe(String nomEquipe) 
    {
        m_nomEquipe = nomEquipe;
    }
    
    public int tailleEquipe()
    {
        return getMembreEquipe().size();
    }
    
    public void addMembre(TortueEquipe t)
    {
        if(!getMembreEquipe().contains(t))
        {
            getMembreEquipe().add(t);
        }
    }
    
    public void removeMembre(TortueEquipe t)
    {
        getMembreEquipe().remove(t);
    }
}
