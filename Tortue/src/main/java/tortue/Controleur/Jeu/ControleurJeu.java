/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Jeu;

import tortue.Controleur.AbstractControleur;
import tortue.Controleur.ControlerMain;
import tortue.Model.Jeu.JeuDeBalle;
import tortue.Model.Jeu.JeuEquipe;
import tortue.Vue.Jeu.Terrain;
import tortue.Vue.MainFrame;

/**
 *
 * @author Arnaud
 */
public class ControleurJeu extends AbstractControleur
{
    private JeuDeBalle m_jeu = null;
    private Terrain m_terrain;

    public ControleurJeu() 
    {
        m_terrain = new Terrain();
        m_jeu = new JeuEquipe();
        m_jeu.addObserver(m_terrain);
        
        ControlerMain.getMainWindow().setFeuille(m_terrain);
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
