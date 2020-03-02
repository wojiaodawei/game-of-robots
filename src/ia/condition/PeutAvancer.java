package ia.condition;

import modele.Grille;
import modele.Robot;
import ia.arbre.Condition;

/**
 * classe representant la Condition : possibilité d'avancer
 * @author 21306226
 */
public class PeutAvancer implements Condition{
	/**
	 * teste si le robot r n'est pas bloqué sur un bord de la grille
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		int[] posSuivante = g.positionSuivante(r.lireX(), r.lireY(),r.lireOrientation());
		int x=posSuivante[0];
		int y=posSuivante[1];
		if(x>=0 && y>=0 && x<g.nbColonnes() && y<g.nbLignes()){
			return g.contenuCaseEn(x,y)==null;
		}
		return false;
	}
}
