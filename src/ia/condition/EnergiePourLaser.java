package ia.condition;

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant la Condition : assez d'energie pour tirer au laser
 * @author 21306226
 */
public class EnergiePourLaser implements Condition{
		/**
		 * teste si le robot r a assez d'energie pour tirer au laser
		 * @param g : grille de jeu
		 * @param r : robot en question
		 * @return resultat : un booleen
		 */
		@Override
		public boolean test(Grille g,Robot r){
			return r.lireEnergie()>=75;
		}
}
