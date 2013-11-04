/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import tortue.Controleur.AbstractControleur;
import tortue.Controleur.ControlerMain;
import tortue.Model.Dessin.*;
import tortue.Vue.MainFrame;

/**
 *
 * @author Arnaud
 */
public class ControleurDessin extends AbstractControleur
{
    static private ArrayList<Tortue> m_tabTortue;
    static private Tortue m_tortueCourante;
    static private TortueFactory m_factory;
    
    public ControleurDessin() 
    {
        m_tabTortue = new ArrayList<Tortue>();
        m_factory = new TortueFactory();
        addTortue(m_factory.create());
        setTortueCourante(getTabTortue().get(0));
    }

    @Override
    public void exec() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void reset()
    {
        m_tabTortue.clear();
        System.out.println(m_tabTortue.size());
        m_tortueCourante = m_factory.create();
        m_tabTortue.add(m_tortueCourante);
        MainFrame.getFeuille().repaint();
    }

    public static ArrayList<Tortue> getTabTortue()
    {
        return m_tabTortue;
    }
    
    public static void setTortueCourante(Tortue tortueCourante) 
    {
        m_tortueCourante = tortueCourante;
    }
    
    public static Tortue getTortueCourante()
    {
        return m_tortueCourante;
    }
    public static void addTortue(Tortue leonardo)
    {
        m_tabTortue.add(leonardo);
    }
    
    public static void removeTortue(Tortue raphaello)
    {
        m_tabTortue.remove(raphaello);
    }
}
