package ia.condition;

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant une sorte de tautologie realisant une Condition
 * @author 21306226
 */
public class ToujoursVrai implements Condition{
	/**
	 * renvoie toujours vrai
	 */
	@Override
	public boolean test(Grille g,Robot r){
		return true;
	}
}
