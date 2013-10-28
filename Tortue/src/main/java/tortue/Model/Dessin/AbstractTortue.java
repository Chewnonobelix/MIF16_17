/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Dessin;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Arnaud
 */
public abstract class AbstractTortue
{
    private Point m_position;
    private int m_angle;
    private int m_taille;
    private Color m_couleur;
    private boolean m_leve;
    private ArrayList<Segment> m_trace;
    
    // Attributs statiques	
    public static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche
    public static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)
        
    public AbstractTortue() 
    {
        m_trace = new ArrayList<Segment>();
        m_position = new Point();
        reset();
    }

    public boolean isLeve() 
    {
        return m_leve;
    }

    public int getAngle() 
    {
        return m_angle;
    }

    public Color getCouleur() 
    {
        return m_couleur;
    }

    public int getTaille() 
    {
        return m_taille;
    }

    public void setLeve(boolean leve)
    {
        m_leve = leve;
    }
    
    public void setAngle(int angle)
    {
        m_angle = angle;
    }

    public void setCouleur(Color couleur) 
    {
        m_couleur = couleur;
    }

    public void setTaille(int taille)
    {
        m_taille = taille;
    }

    public Point getPosition() 
    {
        return m_position;
    }

    protected void setPosition(Point position) 
    {
        m_position = position;
    }

    public ArrayList<Segment> getTrace() 
    {
        return m_trace;
    }
    
    public Segment getLastSegment()
    {
        if(!getTrace().isEmpty())
        {
            return getTrace().get(getTrace().size() - 1);
        }
        
        return null;
    }
    
    protected void addSegment(Segment seg)
    {
        getTrace().add(seg);
    }
    
    public void deplacement(Point end)
    {
        Point debut = getPosition();
        Segment seg = new Segment();
        seg.setStart(debut);
        seg.setEnd(end);
        seg.setColor(getCouleur());
        addSegment(seg);
        setPosition(end);
    }
    
    public void reset()
    {
        getTrace().clear();
        getPosition().x = 0;
        getPosition().y = 0;
        //setCouleur(Color.decode(Color.BLACK.toString()));
        setAngle(-90);
        setLeve(false);
    }
}

