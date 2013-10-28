/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import Pattern.AbstractFactory;
import tortue.Model.Dessin.ConcreteTortue;
/**
 *
 * @author Arnaud
 */
public class TortueFactory implements AbstractFactory<ConcreteTortue>
{
    public ConcreteTortue create() 
    {
        return new ConcreteTortue();
    }
}
