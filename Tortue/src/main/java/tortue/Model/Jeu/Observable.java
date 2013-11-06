/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Jeu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Chewnonobelix
 */
public class Observable 
{
    private ArrayList<Observer> m_listeObserver = new ArrayList<Observer>();
    
    public void addObserver(Observer o)
    {
        m_listeObserver.add(o);
    }
    
    public void removeObserver(Observer o)
    {
        m_listeObserver.remove(o);
    }
    
    public void notifier()
    {
        for(Iterator it = m_listeObserver.iterator(); it.hasNext();)
        {
            Observer o = (Observer)it.next();
            o.notification();
        }
    }
}
