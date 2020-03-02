package ia.condition;

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant la Condition : ennemi sur la grille devant moi (a n'importe quelle distance)
 * @author 21306226
 */
public class EnnemiDevantMoi implements Condition{
	/**
	 * teste si il y a un ennemi devant le robot r
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		int o = r.lireOrientation();
		int[] posSuivante = g.positionSuivante(r.lireX(), r.lireY(),o);
		int x=posSuivante[0];
		int y=posSuivante[1];
		while(x>=0 && y>=0 && x<g.nbColonnes() && y<g.nbLignes()){
			if(g.contenuCaseEn(x,y) instanceof Robot){
				return true;
			}
			posSuivante = g.positionSuivante(x,y,o);
			x=posSuivante[0];
			y=posSuivante[1];
		}
		return false;
	}
}
