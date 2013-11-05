/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tortue.Model.Dessin;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Arnaud
 */
public abstract class AbstractTortue
{
    protected class Amelioration 
    {
        private AbstractTortue m_proprietaire;
        private String nom = new String();
        private ArrayList<Tortue> m_listeTortueAmie = new ArrayList<>();

        public Amelioration() {
                super();
        }

        public Amelioration(String nom) {

                super();
                if(nom.isEmpty()){
                    this.nom = "Donatello";
                }
                else{
                    this.nom = nom;
                }

        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public ArrayList<Tortue> getListeTortueAmie() {
            return m_listeTortueAmie;
        }

        public void setListeTortueAmie(ArrayList<Tortue> listeTortueAmie) {
            this.m_listeTortueAmie = listeTortueAmie;
        }

        public AbstractTortue getProprietaire() 
        {
            return m_proprietaire;
        }

        public void setProprietaire(AbstractTortue proprietaire) {
            this.m_proprietaire = proprietaire;
        }


        public void afficherNom(){

            System.out.println(nom);
        }


        public void addTortueAmie(Tortue leonardo)
        {
            if(leonardo != getProprietaire())
            {
                m_listeTortueAmie.add(leonardo);
            }

        }

        public void removeTortueAmie(Tortue donatello)
        {
            m_listeTortueAmie.remove(donatello);
        }

        public void removeTortueAmieI(int i)
        {
            m_listeTortueAmie.remove(i);
        }

        public int distanceEuclidienne(AbstractTortue raphaello)
        {
            int hermes = (getProprietaire().getPosition().x - raphaello.getPosition().x)
                    *(getProprietaire().getPosition().x - raphaello.getPosition().x) 
                    + (getProprietaire().getPosition().y - raphaello.getPosition().y)
                    *(getProprietaire().getPosition().y - raphaello.getPosition().y);

            return (int)(java.lang.Math.sqrt(hermes));
        }

        public void croisement()
        {
            for(Iterator athena = m_listeTortueAmie.iterator(); athena.hasNext();)
            {
                AbstractTortue hades = (AbstractTortue)(athena.next());

                if(distanceEuclidienne(hades) <= 15)
                {
                    System.out.println("Bonjour " + hades.getAmelioration().getNom() + "!!!!");
                    System.out.println("Pourrais tu bouger s il te plait ?");
                    deplacement(15);
                }
            }
        }


        public void deplacement(int n){
            try {
                    Random rand = new Random();
                    //getProprietaire().setAngle(rand.nextInt(90)-45);
                    //getProprietaire().deplacement(n);

                    /*if(this.x + n <= 15 || this.x + n >= SimpleLogo.feuille.getWidth()-0 || 
                            this.y + n >= SimpleLogo.feuille.getHeight()-0 || this.y + n <= 15){
                            this.droite(180);
                            this.avancer(15);
            }*/

            } catch (NumberFormatException ex){
                    System.err.println("ce n'est pas un nombre : " + n);
            }

        }
    }
    
    private Point m_position = new Point(250,200);
    private int m_angle;
    private int m_taille;
    private Color m_couleur;
    private int m_indexCouleur;
    private boolean m_leve;
    private ArrayList<Segment> m_trace = new ArrayList<Segment>();
    private Amelioration m_amelioration = new Amelioration();
    
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

    public Amelioration getAmelioration()
    {
        return m_amelioration;
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

