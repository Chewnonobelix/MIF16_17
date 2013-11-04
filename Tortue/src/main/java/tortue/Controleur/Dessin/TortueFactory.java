/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Controleur.Dessin;

import Pattern.AbstractFactory;
import tortue.Model.Dessin.Tortue;
/**
 *
 * @author Arnaud
 */
public class TortueFactory implements AbstractFactory<Tortue>
{
    public Tortue create() 
    {
        return new Tortue();
    }
}
