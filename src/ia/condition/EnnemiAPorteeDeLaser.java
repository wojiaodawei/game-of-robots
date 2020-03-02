package ia.condition;

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant la Condition : ennemi a portee de laser 
 * @author 21306226
 */
public class EnnemiAPorteeDeLaser implements Condition{
	/**
	 * teste si un robot est a portee de laser
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
			int[] posSuivante2 = g.positionSuivante(x,y,r.lireOrientation());
			int x2=posSuivante2[0];
			int y2=posSuivante2[1];
			if(x2>=0 && y2>=0 && x2<g.nbColonnes() && y2<g.nbLignes()){
				return (g.contenuCaseEn(x, y) instanceof Robot || g.contenuCaseEn(x2, y2) instanceof Robot);
			}
			return g.contenuCaseEn(x, y) instanceof Robot;
		}
		return false;
	}
}