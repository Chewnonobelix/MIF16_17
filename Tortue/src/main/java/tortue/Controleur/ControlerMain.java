/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur;

import Pattern.AbstractFactory;
import tortue.Controleur.Dessin.ControleurDessin;
import tortue.Vue.MainFrame;
/**
 *
 * @author Arnaud
 */
public class ControlerMain 
{
    private AbstractControleur m_controleur;
    private MainFrame m_mainWindow;

    public ControlerMain() 
    {
        m_controleur = new ControleurDessin();
        m_mainWindow = new MainFrame();
        m_mainWindow.setVisible(true);
    }
    
    
    
}
