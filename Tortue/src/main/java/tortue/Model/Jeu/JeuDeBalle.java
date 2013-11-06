/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import java.util.ArrayList;

/**
 *
 * @author Chewnonobelix
 */
public abstract class JeuDeBalle 
{
    static private ArrayList<TortueEquipe> m_listeJoueur = new ArrayList<TortueEquipe>();

    public static ArrayList<TortueEquipe> getListeJoueur() 
    {
        return m_listeJoueur;
    }
    
    public static void addJoueur(TortueEquipe t)
    {
        if(!getListeJoueur().contains(t))
        {
            getListeJoueur().add(t);
        }
    }
    
    public static void removeJoueur(TortueEquipe t)
    {
        getListeJoueur().remove(t);
    }
    
    public abstract void exec();
}
