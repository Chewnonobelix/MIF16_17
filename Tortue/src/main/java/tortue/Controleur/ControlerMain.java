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
    static public ListenerProcedureAvance avance = new ListenerProcedureAvance();
    static public ListenerProcedureBase base = new ListenerProcedureBase();
    static public ListenerCombo combo = new ListenerCombo();
    
    public ControlerMain() 
    {       
        m_mainWindow = new MainFrame(base, avance, combo);
        avance.setFrame(m_mainWindow);
        base.setFrame(m_mainWindow);
        m_mainWindow.setVisible(true);
    } 

    public static MainFrame getMainWindow() 
    {
        return m_mainWindow;
    }

    public static void setControleur(AbstractControleur controleur) 
    {
        ControlerMain.m_controleur = controleur;
    }
    
    static public void nouveau(String c)
    {
                ControlerMain.base.setControleur(null);
                ControlerMain.avance.setControleur(null);
                ControlerMain.combo.setDessin(null);
                
                if(c.matches("Dessin"))
                {
                    ControleurDessin a = new ControleurDessin();
                    ControlerMain.setControleur(a);
                    ControlerMain.base.setControleur(a);
                    ControlerMain.avance.setControleur(a);
                    ControlerMain.combo.setDessin(a);
                }
                else if(c.matches("Jeu"))
                {
                    ControleurJeu a = new ControleurJeu();
                    ControlerMain.setControleur(a);
                    a.exec();
                }
    }
}
