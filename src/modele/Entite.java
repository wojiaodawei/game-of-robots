package modele;

/**
 * classe representant une Entite(mur,robot,missile,laser)
 * @author 21306226
 */
public class Entite{
	/**
	 * grille de jeu
	 */
	Grille grille;
	/**
	 * position en x de l'entite
	 */
	protected int posX;
	/**
	 *  position en y de l'entite
	 */
	protected int posY;
	/**
	 * nombre de vies du joueur(initialise a 1 dans notre jeu pour le moment)
	 */
	protected int vie=1;
	
	/**
	 * constructeur logique
	 * @param x : {@link #posX}
	 * @param y : {@link #posY}
	 * @param g : {@link #grille}
	 */
	public Entite(int x, int y,Grille g){
		Entite e = g.contenuCaseEn(x, y);
		if(e!=null){
			e.detruire();
		}
		g.remplirGrille(x, y, null);
		g.remplirGrille(x, y, this);
		posX = x;
		posY = y;
		this.grille=g;
	}
	
	/**
	 * accesseur sur x
	 * @return {@link #posX}
	 */
	public int lireX(){
		return posX;
	}
	
	/**
	 * accesseur sur y
	 * @return {@link #posY}
	 */
	public int lireY(){
		return posY;
	}
	
	/**
	 * accesseur sur le nombre de vies de l'entite
	 * @return {@link #vie}
	 */
	public int lireVie(){
		return vie;
	}
	
	/**
	 * mutateur sur x
	 * @param x : {@link #posX}
	 */
	public void changerX(int x){
		posX = x;
		return;
	}
	
	/**
	 * mutateur sur y
	 * @param y : {@link #posY}
	 */
	public void changerY(int y){
		posY = y;
		return;
	}

	/**
	 * affecte un degat de vie a l'entite (=enleve 1 point de vie)
	 */
	public void degat(){
		vie = vie - 1;
		if(vie==0){
			this.detruire();
		}
	}
	
	/**
	 * detruit l'entite, la supprime de la grille de jeu
	 */
	public void detruire(){
		grille.remplirGrille(posX,posY,null);
	}
	
}
