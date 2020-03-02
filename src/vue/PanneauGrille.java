package vue;

import java.awt.Graphics;

import javax.swing.JPanel;
import controleur.Controleur;

import java.awt.Color;
import modele.*;

public class PanneauGrille extends JPanel implements Observeur{
	private int longueur;
	private int largeur;
	private Graphics g;
	private int tailleCase;
	private int horizontal_shift;
	private int vertical_shift;
	public PanneauGrille (int longueur,int largeur,Controleur c) {
		this.longueur=longueur;
		this.largeur=largeur;
		c.getOrdonnanceur().ajouterListener(this);
	}
	public int smallest (int int1, int int2) {
		if (int1 <= int2) {return int1;}
		else {return int2;}
	}
	public void paintComponent(Graphics g){
		this.g=g;
		int height = getHeight();
		int width = getWidth();
		tailleCase = smallest((width/longueur), (height/largeur));
		
		horizontal_shift = (width - (longueur * tailleCase))/2;
		vertical_shift = (height - (largeur * tailleCase))/2;
		
		for(int j = 0; j < largeur; j++)
		{
			for(int i = 0; i < longueur; i++)
			{
				g.setColor(Color.white);
				g.fillRect(i*tailleCase + horizontal_shift, j*tailleCase + vertical_shift, tailleCase, tailleCase);
				g.setColor(Color.black);
				g.drawRect(i*tailleCase + horizontal_shift, j*tailleCase + vertical_shift, tailleCase, tailleCase);
			}
		}
	}

	public void miseAJour(Entite[][] grille){		
		for(int i = 0; i < largeur; i++)
		{
			for(int j = 0; j < longueur; j++)
			{
				afficher(grille[i][j],i,j);	
			}
		}
	}

	public void afficher(Entite entite, int x, int y){
		g=getGraphics();
		if(entite==null){
			g.setColor(Color.white);
			g.fillRect(x*tailleCase + horizontal_shift, y*tailleCase + vertical_shift, tailleCase, tailleCase);			
		}
		else if(entite instanceof Robot){
			RobotSprite robot = new RobotSprite(((EntiteMouvante)entite).lireOrientation());
			g.drawImage(robot.lireImage(), x*tailleCase + horizontal_shift, y*tailleCase + vertical_shift, tailleCase, tailleCase, robot);
		}else if(entite instanceof Missile){
			MissileSprite missile = new MissileSprite(((EntiteMouvante)entite).lireOrientation());
			g.drawImage(missile.lireImage(), x*tailleCase + horizontal_shift, y*tailleCase + vertical_shift, tailleCase, tailleCase, missile);
		}else if(entite instanceof Laser){
			LaserSprite laser = new LaserSprite(((EntiteMouvante)entite).lireOrientation());
			g.drawImage(laser.lireImage(), x*tailleCase + horizontal_shift, y*tailleCase + vertical_shift, tailleCase, tailleCase, laser);
		}else if(entite instanceof Mur){
			g.setColor(Color.darkGray);
			g.fillRect(x*tailleCase + horizontal_shift, y*tailleCase + vertical_shift, tailleCase, tailleCase);
		}
		g.setColor(Color.black);
		g.drawRect(x*tailleCase + horizontal_shift, y*tailleCase + vertical_shift, tailleCase, tailleCase);
	}
	@Override
	public void metToiAjour(Entite[][] grille) {
		System.out.println("aozkaozzod");
		miseAJour(grille);
	}
	@Override
	public void finDePartie(String gagnant) {}
}
