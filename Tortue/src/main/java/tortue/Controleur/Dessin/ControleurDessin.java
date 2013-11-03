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
    static private ArrayList<ConcreteTortue> m_tabTortue;
    static private ConcreteTortue m_tortueCourante;
    static private TortueFactory m_factory;
    
    public ControleurDessin() 
    {
        m_tabTortue = new ArrayList<ConcreteTortue>();
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
        //TODO
    }

    public static ArrayList<ConcreteTortue> getTabTortue()
    {
        return m_tabTortue;
    }
    
    public static void setTortueCourante(ConcreteTortue tortueCourante) 
    {
        m_tortueCourante = tortueCourante;
    }
    
    public static ConcreteTortue getTortueCourante()
    {
        return m_tortueCourante;
    }
    public static void addTortue(ConcreteTortue leonardo)
    {
        m_tabTortue.add(leonardo);
    }
    
    public static void removeTortue(ConcreteTortue raphaello)
    {
        m_tabTortue.remove(raphaello);
    }
}
