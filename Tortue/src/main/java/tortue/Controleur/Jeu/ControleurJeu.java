/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Jeu;

import java.awt.Color;
import tortue.Controleur.AbstractControleur;
import tortue.Controleur.ControlerMain;
import tortue.Model.Jeu.EquipeTortue;
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
    static private JeuDeBalle m_jeu = null;
    private Terrain m_terrain;

    public ControleurJeu() 
    {
        m_terrain = new Terrain();
        m_jeu = new JeuEquipe();
        m_jeu.addObserver(m_terrain);
        
        ControlerMain.getMainWindow().setFeuille(m_terrain);
        
        EquipeTortue e = new EquipeTortue();
        e.setCouleur(Color.blue);
        ((JeuEquipe)m_jeu).addEquipe(e);
        e = new EquipeTortue();
        e.setCouleur(Color.red);
        ((JeuEquipe)m_jeu).addEquipe(e);
        e = new EquipeTortue();
        e.setCouleur(Color.green);
        ((JeuEquipe)m_jeu).addEquipe(e);
        e = new EquipeTortue();
        e.setCouleur(Color.orange);
        ((JeuEquipe)m_jeu).addEquipe(e);
    }

    public static JeuDeBalle getJeu() 
    {
        return m_jeu;
    }

    
    @Override
    public void exec()
    {
        System.out.println("Exec Controler");
        if(m_jeu != null)
        {
            m_jeu.exec();
        }
    }
    
}
