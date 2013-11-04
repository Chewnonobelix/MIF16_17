/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tortue.Model.Dessin.Tortue;
import tortue.Vue.MainFrame;

/**
 *
 * @author Arnaud
 */
public class ListenerProcedureBase implements ActionListener
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
        String c = e.getActionCommand();
        // actions des boutons du haut
        Tortue courante = m_dessin.getTortueCourante();
        
        switch (c) 
        {
            case "Effacer":
                m_dessin.reset();
                break;
                
            case "Avancer":
                if(courante != null) 
                {
                    try 
                    {
                        int v = Integer.parseInt(m_frame.getInputValue());
                        courante.avancer(v);
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.err.println("ce n'est pas un nombre : " + m_frame.getInputValue());
                    }
               }
                break;
                
            case "Droite":
                if(courante != null) 
                {
                    try 
                    {
                        int v = Integer.parseInt(m_frame.getInputValue());
                        courante.droite(v);
                    } 
                    catch (NumberFormatException ex)
                    {
                        System.err.println("ce n'est pas un nombre : " + m_frame.getInputValue());
                    }
                }
                break;
                
            case "Gauche":
                if(courante != null) 
                {
                    try {
                        int v = Integer.parseInt(m_frame.getInputValue());
                        courante.gauche(v);
                    } catch (NumberFormatException ex) {
                        System.err.println("ce n'est pas un nombre : " + m_frame.getInputValue());
                    }
                }
                break;
                
            case "Lever":
                if(ControleurDessin.getTortueCourante() != null) 
                {
                    ControleurDessin.getTortueCourante().leverCrayon();
                }
                break;
                
            case "Baisser":
                if(ControleurDessin.getTortueCourante() != null) 
                {
                    ControleurDessin.getTortueCourante().baisserCrayon();
                }    
                break;
                
            case "Nom":
                /*if(courante != null) {
                    ((TortueAmelioree) courante).afficherNom();
                }*/
                break;
            case "Changer":
            {
                /*if(courante != null) {
                    changerTortueBouton();
                }*/
            }
            break;
            case "Creer":
                //creerTortueBouton();
                break;
        }
        
        MainFrame.getFeuille().repaint();
    }
    
}
