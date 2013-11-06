/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Vue.Dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Iterator;
import tortue.Controleur.Dessin.ControleurDessin;
import tortue.Model.Dessin.AbstractTortue;
import tortue.Model.Dessin.Segment;
import tortue.Model.Dessin.Tortue;
import tortue.Vue.AbstractFeuille;

/**
 *
 * @author Arnaud
 */
public class FeuilleDessin extends AbstractFeuille 
{

    /**
     * Creates new form FeuilleDessin
     */
    private Dimension m_dim;
    
    public FeuilleDessin() 
    {
        initComponents();
    }

    public Dimension getdim() 
    {
        return m_dim;
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Color c = g.getColor();

        m_dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0,0,m_dim.width, m_dim.height);
        g.setColor(c);

        showTurtles(g);
    }
	
    public void showTurtles(Graphics g) 
    {         
        for(Iterator it = ControleurDessin.getTabTortue().iterator();it.hasNext();)
        {
            AbstractTortue t = (AbstractTortue)it.next();
            
            drawTurtle(g, t);
        }
    }
    
    private void drawTurtle(Graphics graph, AbstractTortue t)
    {
        if (graph==null)
            return;
		
		// Dessine les segments
        for(Iterator it = t.getTrace().iterator();it.hasNext();) 
        {
                Segment seg = (Segment) it.next(); 
                graph.setColor(seg.getColor());
                graph.drawLine(seg.getStart().x, seg.getStart().y, seg.getEnd().x, seg.getEnd().y);
        }

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(t.getPosition().x,t.getPosition().y);
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=Tortue.ratioDegRad*(-t.getAngle());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)Tortue.rb / (float)Tortue.rp );
        //Rayon de la fleche
        double r=Math.sqrt( Tortue.rp*Tortue.rp + Tortue.rb*Tortue.rb );
        //Sens de la fleche

        //Pointe
        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                                         (int) Math.round(p.y-r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
          (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
          (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

        arrow.addPoint(p2.x,p2.y);
        graph.setColor(Color.green);
        graph.fillPolygon(arrow);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
