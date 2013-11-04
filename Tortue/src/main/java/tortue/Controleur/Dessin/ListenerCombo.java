/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Chewnonobelix
 */
public class ListenerCombo implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JComboBox cb = (JComboBox) e.getSource();
        int n = cb.getSelectedIndex();
        ControleurDessin.getTortueCourante().setCouleur(n);
    }
    
}
