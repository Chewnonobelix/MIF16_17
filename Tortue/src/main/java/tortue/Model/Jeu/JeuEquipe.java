/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Chewnonobelix
 */
public class JeuEquipe extends JeuDeBalle
{

    private ArrayList<EquipeTortue> m_listeEquipe = new ArrayList<>();
    
    @Override
    public void exec() 
    {
        Timer time = new Timer();
        
        time.schedule (new TimerTask() {
            public void run()
            {
        
                for(Iterator it = m_listeEquipe.iterator(); it.hasNext();)
                {
                    EquipeTortue e = (EquipeTortue)it.next();

                    for(Iterator it2 = e.getMembreEquipe().iterator(); it2.hasNext();)
                    {
                        TortueEquipe t = (TortueEquipe)it2.next();

                        t.deplacement();
                    }
                }
                notifier();
            }}, 0, 100);
    }

    public ArrayList<EquipeTortue> getListeEquipe() 
    {
        return m_listeEquipe;
    }

    public void setListeEquipe(ArrayList<EquipeTortue> listeEquipe) 
    {
        m_listeEquipe = listeEquipe;
    }
    
    public void addEquipe(EquipeTortue e)
    {
        if(!getListeEquipe().contains(e))
        {
            getListeEquipe().add(e);
        }
    }
    
    public void removeEquipe(EquipeTortue e)
    {
        getListeEquipe().remove(e);
    }
}
