/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tortue.Controleur.ControlerMain;
import tortue.Controleur.Jeu.ControleurJeu;
import tortue.Model.Dessin.Tortue;
import tortue.Vue.MainFrame;
import tortue.Vue.Nouveau;

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
        if(c.matches("Nouveau"))
        {
            Nouveau n = new Nouveau();
            n.setVisible(true);
        }
        
        if(m_dessin != null)
        {
            Tortue courante = m_dessin.getTortueCourante();

            switch (c) 
            {
                case "Effacer":
                    m_dessin.reset();
                    break;

                case "Quitter":
                    System.exit(0);
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
                    if(courante != null) 
                    {
                        m_dessin.nextTortue();
                    }
                }
                break;
                case "Creer":
                    m_dessin.creerTortue();
                    break;
            }

            ControlerMain.getMainWindow().getFeuille().repaint();
        }
    }
}
