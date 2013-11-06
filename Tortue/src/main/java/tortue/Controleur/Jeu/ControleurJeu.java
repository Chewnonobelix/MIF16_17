/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Jeu;

import tortue.Controleur.AbstractControleur;
import tortue.Model.Jeu.JeuDeBalle;
import tortue.Model.Jeu.JeuEquipe;

/**
 *
 * @author Arnaud
 */
public class ControleurJeu extends AbstractControleur
{
    private JeuDeBalle m_jeu = null;

    public ControleurJeu() 
    {
        m_jeu = new JeuEquipe();
    }

    
    @Override
    public void exec()
    {
        if(m_jeu != null)
        {
            m_jeu.exec();
        }
    }
    
}
