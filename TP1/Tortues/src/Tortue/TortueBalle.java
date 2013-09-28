package Tortue;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Classe qui h�rite de la classe TortueAmelioree.
 * Elle est dessin�e sous forme de disque. Elle connait la tortue (TortueAmelioree ou TortueEquipe) qui la poss�de. 
 */
public class TortueBalle extends TortueAmelioree{

	// tortue qui me possède (la balle)
    private Boolean balle;

	
    public TortueBalle(String nom) {
	
        super();
    }

    public Boolean getBalle() {
        return balle;
    }

    public void setBalle(Boolean balle) {
        this.balle = balle;
    }
	
        

    // On redéfinit la méthode drawTurtle pour que ce soit un disque	
	
    /*public void drawTurtle (Graphics graph) {
		
        double r=Math.sqrt( rp*rp + rb*rb );
	double theta=ratioDegRad*(-this.dir);
		
	Point p = new Point(this.x,this.y);
		
	Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),(int) Math.round(p.y-r*Math.sin(theta)));
	
	graph.setColor(Color.gray);
	graph.fillOval(p2.x-5, p2.y-5, 10, 10);
	
	}*/
	
}
