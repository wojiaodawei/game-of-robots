package modele;

/**
 * classe representant une entite qui bouge (missile,laser,robot)
 * @author 21306226
 */
public class EntiteMouvante extends Entite{

	/**
	 * orientation de l'entite
	 */
	protected int orientation;
	/**
	 * ordonnanceur du jeu
	 */
	protected Ordonnanceur o;
	/**
	 * position suivante en y
	 */
	protected int prochainY;
	/**
	 * position suivante en x
	 */
	protected int prochainX;
	/**
	 * boolean sur l'etat vital de l'entite
	 */
	protected boolean vivant;
	
	/**
	 * constructeur logique
	 * @param orientation : {@link #orientation}
	 * @param x : position actuelle en x
	 * @param y : position actuelle en y
	 * @param grille : grille du jeu
	 * @param o : {@link #o}
	 */
	public EntiteMouvante(int orientation, int x, int y,Grille grille, Ordonnanceur o){
		super(x,y,grille);
		this.o=o;
		this.orientation=orientation;
		vivant=true;
	}

	/**
	 * accesseur sur l'orientation de l'entite
	 * @return {@link #orientation}
	 */
	public int lireOrientation(){
		return orientation;
	}
	
	/**
	 * detruit l'entite : la supprime de la grille et la supprime de l'ordonnanceur
	 * l'entite n'est donc plus vivante
	 */
	@Override
	public void detruire(){
		grille.remplirGrille(posX,posY,null);
		o.supprimEntite(this);
		vivant=false;
	}
	
	/**
	 * accesseur sur la vie de l'entite
	 * @return {@link #vie}
	 */
	public boolean estVivant(){
		return vivant;
	}
	
	/**
	 * methode avancer pour une entite mouvante
	 */
	public void avancer(){
		int[] posSuivante = grille.positionSuivante(posX, posY, orientation);
		int prochainX=posSuivante[0];
		int prochainY=posSuivante[1];
		if(prochainX<0 || prochainX>=grille.nbColonnes() || prochainY<0 || prochainY>=grille.nbLignes()){ //si le missile sort de la map
			this.detruire();
		}
		else{
			grille.deplacer(this, posX,posY,prochainX,prochainY);
			posX=prochainX;
			posY=prochainY;
		}
	}
	
	public void tour(){};

}
