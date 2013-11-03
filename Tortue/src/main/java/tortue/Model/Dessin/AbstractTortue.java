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
    private Point m_position = new Point(250,200);
    private int m_angle;
    private int m_taille;
    private Color m_couleur;
    private int m_indexCouleur;
    private boolean m_leve;
    private ArrayList<Segment> m_trace = new ArrayList<Segment>();
    
    // Attributs statiques	
    public static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche
    public static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)
        
    public AbstractTortue() 
    {
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

    public void setCouleur(int couleur) 
    {
        m_indexCouleur = couleur%12;
        m_couleur = decodeColor(m_indexCouleur);
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
        getPosition().x = 250;
        getPosition().y = 200;
        setCouleur(0);
        setAngle(-90);
        setLeve(false);
    }
    
    public void couleurSuivante() 
    {
        setCouleur(m_indexCouleur + 1);
    }
    
    protected Color decodeColor(int c) 
    {
        switch(c) 
        {
            case 1: return(Color.blue);
            case 2: return(Color.cyan);
            case 3: return(Color.darkGray);
            case 4: return(Color.red);
            case 5: return(Color.green);
            case 6: return(Color.lightGray);
            case 7: return(Color.magenta);
            case 8: return(Color.orange);
            case 9: return(Color.gray);
            case 10: return(Color.pink);
            case 11: return(Color.yellow);
            default : return(Color.black);
        }
    }
}

