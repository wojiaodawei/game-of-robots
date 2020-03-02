package ia.arbre;

import modele.Grille;
import modele.Robot;

/**
 * classe representant un Noeud qui realise Composant aussi
 * @author 21306226
 */
public class Noeud implements Composant{
	/**
	 * Condition du Noeud
	 */
	Condition c;
	
	/**
	 * constructeur logique
	 * @param c : Condition du Noeud
	 */
	public Noeud(Condition c){
		this.c=c;
	}
	
	/**
	 * methode qui fait le test de la condition
	 * @param g : grille du jeu
	 * @param r : robot en question
	 */
	@Override
	public void action(Grille g, Robot r) {
		c.test(g,r);
	}
}
