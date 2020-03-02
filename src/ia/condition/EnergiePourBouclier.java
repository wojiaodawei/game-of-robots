package ia.condition;

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant la Condition : energie pour activer un bouclier
 * @author 21306226
 */
public class EnergiePourBouclier implements Condition{
	/**
	 * teste si le robot r a assez d'energie pour activer son bouclier
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		return r.lireEnergie()>=25;
	}
}
