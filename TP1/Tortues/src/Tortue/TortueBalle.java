package Tortue;




import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Iterator;


/**
 * Classe qui h�rite de la classe TortueAmelioree.
 * Elle est dessin�e sous forme de disque. Elle connait la tortue (TortueAmelioree ou TortueEquipe) qui la poss�de. 
 */
public class TortueBalle extends TortueAmelioree{

	protected boolean balle;

	// tortue qui me possède (la balle)


	
    public TortueBalle(String nom) {
	
        super();

        if(nom == "null"){
            this.nom = "Donatello";
        }
        else{
            this.nom = nom;
        }
        balle = false;
    }

    public boolean isBalle() {
        return balle;
    }

    public void setBalle(boolean balle) {
        this.balle = balle;
    }
   

    // On redéfinit la méthode drawTurtle pour que ce soit un disque s'il a la balle
	
    public void drawTurtle (Graphics graph) {
	
        if(balle){
            double r = Math.sqrt( rp*rp + rb*rb );
            double theta = ratioDegRad * (-this.dir);
		
            Point p = new Point(this.x,this.y);
		
            Point p2 = new Point((int) Math.round(p.x+r*Math.cos(theta)),(int) Math.round(p.y-r*Math.sin(theta)));
	
            graph.setColor(Color.red);
            graph.fillOval(p2.x-5, p2.y-5, 10, 10);
        }
        else{
            if (graph==null)
			return;
		
		// Dessine les segments
		for(Iterator it = listSegments.iterator();it.hasNext();) {
			Segment seg = (Segment) it.next();
			seg.drawSegment(graph);
		}

		//Calcule les 3 coins du triangle a partir de
		// la position de la tortue p
		Point p = new Point(x,y);
		Polygon arrow = new Polygon();

		//Calcule des deux bases
		//Angle de la droite
		double theta=ratioDegRad*(-dir);
		//Demi angle au sommet du triangle
		double alpha=Math.atan( (float)rb / (float)rp );
		//Rayon de la fleche
		double r=Math.sqrt( rp*rp + rb*rb );
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
        
	
    }
    
	
}
