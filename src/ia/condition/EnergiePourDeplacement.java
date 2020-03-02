package ia.condition;

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant la Condition : assez d'energie pour un deplacement (avant ou arriere)
 * @author 21306226
 */
public class EnergiePourDeplacement implements Condition{
	/**
	 * teste si le robot r a assez d'energie pour se deplacer
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		return r.lireEnergie()>=10;
	}
}