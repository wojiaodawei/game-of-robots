package ia.arbre;

import modele.Grille;
import modele.Robot;

/**
 * interface representant un composant 
 * @author 21306226
 */
public interface Composant 
{
	/**
	 * action qui fait le test de la condition puis execute l'action du fils gauche ou du fils droit en fonction du test
	 * @param g : grille du jeu
	 * @param r : robot a qui on applique les actions des composants de l'arbre
	 */
	public void action(Grille g,Robot r);
}
