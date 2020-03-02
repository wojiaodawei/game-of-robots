package ia.condition;

import modele.Grille;
import modele.Robot;
import ia.arbre.Condition;

/**
 * classe representant la Condition : possibilité de reculer
 * @author 21306226
 */
public class PeutReculer implements Condition{
	/**
	 * teste si le robot r peut reculer, si il n'y a pas un mur derriere lui
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		int[] posSuivante = g.positionPrecedente(r.lireX(), r.lireY(),r.lireOrientation());
		int x=posSuivante[0];
		int y=posSuivante[1];
		if(x>=0 && y>=0 && x<g.nbColonnes() && y<g.nbLignes()){
			return g.contenuCaseEn(x,y)==null;
		}
		return false;
	}
}
