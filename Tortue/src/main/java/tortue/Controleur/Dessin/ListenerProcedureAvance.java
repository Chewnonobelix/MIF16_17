/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tortue.Controleur.ControlerMain;
import tortue.Model.Dessin.Tortue;
import tortue.Vue.MainFrame;

/**
 *
 * @author Arnaud
 */
public class ListenerProcedureAvance implements ActionListener
{
    ControleurDessin m_dessin;
    MainFrame m_frame;
    
    public void setControleur(ControleurDessin c)
    {
        m_dessin = c;
    }
    
    public void setFrame(MainFrame f)
    {
        m_frame = f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(m_dessin != null)
        {
            String c = e.getActionCommand();
            // actions des boutons du haut
            Tortue courante = m_dessin.getTortueCourante();
            switch (c) 
            {
                case "Proc1":
                    if(courante != null)
                    {
                        courante.carre();
                    }
                    break;
                case "Proc2":
                    if(courante != null)
                    {
                        courante.poly(60,8);
                    }
                    break;
                case "Proc3":
                    if(courante != null)
                    {
                        courante.spiral(50,40,6);
                    }
                    break;
                case "Proc4":
                    if(courante != null)
                    {
                        courante.maison();
                    }
                    break;
                case "Proc5":
                    if(courante != null)
                    {
                        courante.etoile(8,100);
                    }
                    break;
                case "Proc6":
                    //proc6();
                    break;
                case "Proc7":
                    //proc7();
                    break;

                case "Proc8":
                    //proc8();
                    break;



            }
            ControlerMain.getMainWindow().getFeuille().repaint();
        }
    }
    
    
}
