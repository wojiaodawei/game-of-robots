package ia.arbre;

import modele.Grille;
import modele.Robot;

/**
 * classe representant une feuille action qui realise Composant
 * @author 21306226
 */
public class Feuille implements Composant{
	/**
	 * Action de cette Feuille
	 */
	Action action;
	
	/**
	 * Constructeur logique
	 * @param action : Action de la Feuille
	 */
	public Feuille(Action action){
		this.action = action ;
	}
	
	/**
	 * execute l'action de {@link #action}
	 * @param g : grille de jeu
	 * @param r : robot en question
	 */
	public void action(Grille g,Robot r){
		action.execute(r);
	}
}
