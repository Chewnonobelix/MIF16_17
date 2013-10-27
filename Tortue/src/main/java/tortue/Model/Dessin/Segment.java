/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Dessin;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Arnaud
 */
public class Segment
{
    private Point m_start, m_end;
    private Color m_color;

    public Segment() 
    {
        m_start = new Point(0,0);
        m_end = new Point(0,0);
    }

    public void setColor(Color color) 
    {
        m_color = color;
    }

    public void setEnd(Point  end) 
    {
        m_end = end;
    }

    public void setStart(Point start) 
    {
        m_start = start;
    }

    public Color getColor() 
    {
        return m_color;
    }

    public Point getEnd()
    {
        return m_end;
    }

    public Point getStart()
    {
        return m_start;
    }
}