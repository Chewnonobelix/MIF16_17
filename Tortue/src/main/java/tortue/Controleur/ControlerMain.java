/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur;

import Pattern.AbstractFactory;
import tortue.Controleur.Dessin.ControleurDessin;
import tortue.Controleur.Dessin.ListenerCombo;
import tortue.Controleur.Dessin.ListenerProcedureAvance;
import tortue.Controleur.Dessin.ListenerProcedureBase;
import tortue.Controleur.Jeu.ControleurJeu;
import tortue.Vue.MainFrame;
/**
 *
 * @author Arnaud
 */
public class ControlerMain 
{
    static private AbstractControleur m_controleur;
    static private MainFrame m_mainWindow;

    public ControlerMain() 
    {
        ListenerProcedureAvance avance = new ListenerProcedureAvance();
        ListenerProcedureBase base = new ListenerProcedureBase();
        ListenerCombo combo = new ListenerCombo();
        
        m_controleur = new ControleurJeu();
        m_mainWindow = new MainFrame(base, avance, combo);
        System.out.println(m_mainWindow);
        System.out.println(m_mainWindow.getFeuille());
        base.setControleur((ControleurDessin)m_controleur);
        base.setFrame(m_mainWindow);
        avance.setControleur((ControleurDessin)m_controleur);
        avance.setFrame(m_mainWindow);
        m_mainWindow.setVisible(true);
        m_controleur.exec();
    } 

    public static MainFrame getMainWindow() 
    {
        return m_mainWindow;
    }
    
}
