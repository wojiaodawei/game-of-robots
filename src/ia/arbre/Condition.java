package ia.arbre;

import modele.Grille;
import modele.Robot;

/**
 * interface representant une condition en general
 * @author 21306226
 */
public interface Condition{
	/**
	 * methode faisant le test de la condition
	 * @param g : la grille de jeu
	 * @param r : le robot en question
	 * @return un boolean : le resultat du test
	 */
	public abstract boolean test(Grille g,Robot r);
	
}
