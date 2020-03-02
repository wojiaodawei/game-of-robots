package ia.condition;

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant la Condition : possibilité de tirer
 * @author 21306226
 */
public class PeutTirer implements Condition{
	/**
	 * teste si le robot r peut tirer, c'est a dire si il au moins une case est libre devant lui
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		int[] posSuivante = g.positionSuivante(r.lireX(), r.lireY(),r.lireOrientation());
		int x=posSuivante[0];
		int y=posSuivante[1];
		return (x>=0 && y>=0 && x<g.nbColonnes() && y<g.nbLignes());
	}
}