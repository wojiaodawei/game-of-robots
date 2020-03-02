package modele;

/**
 * classe representant l'entite mouvante missile
 * @author 21306226
 */
public class Missile extends EntiteMouvante{
	
	/**
	 * constructeur logique
	 * @param Name
	 * @param orientation
	 * @param posX
	 * @param posY
	 * @param grille
	 * @param o
	 */
	public Missile(String Name, int orientation, int posX, int posY,Grille grille, Ordonnanceur o){
		super(orientation,posX,posY,grille,o);
	}
	
	/**
	 * le missile ne fait qu'avancer lorsque c'est son tour
	 */
	@Override
	public void tour(){
		avancer();
	}
}
