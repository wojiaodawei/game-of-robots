package modele;

/**
 * classe representant l'entite laser qui, pourrait en fait ne pas etre mouvante
 * @author 21306226
 */
public class Laser extends EntiteMouvante{
	int posSuivX;
	int posSuivY;
	int distance=1;

	/**
	 * constructeur logique du laser
	 * le laser se cree sur une case voire sur 2 si c'est possible(si il ne sort pas de la grille de jeu)
	 * @param orientation
	 * @param x
	 * @param y
	 * @param grille
	 * @param o
	 */
	public Laser(int orientation, int x, int y, Grille grille, Ordonnanceur o){
		super(orientation, x, y, grille, o);
		int[] posSuivante = grille.positionSuivante(x, y, orientation);
		posSuivX=posSuivante[0];
		posSuivY=posSuivante[1];
		if(posSuivX>=0 && posSuivX<grille.nbColonnes() && posSuivY>=0 && posSuivY<grille.nbLignes()){
			Entite e = grille.contenuCaseEn(posSuivX,posSuivY);
			if( e != null){
				e.detruire();
			}
			distance++;
			grille.remplirGrille(posSuivX,posSuivY,this);	
		}
	}

	/**
	 * lorsque c'est au tour du laser dans l'ordonnanceur, le laser disparait
	 */
	@Override
	public void tour(){
		if(distance==2){
			grille.remplirGrille(posSuivX,posSuivY,null);
		}
		detruire();
	}
}
