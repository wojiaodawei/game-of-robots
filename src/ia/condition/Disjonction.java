package ia.condition; 

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant une disjonction de conditions realisant une Condition
 * @author 21306226
 */
public class Disjonction implements Condition{
	/**
	 * premiere Condition
	 */
	Condition condition1;
	/**
	 * seconde Condition
	 */
	Condition condition2;
	
	/**
	 * constructeur logique
	 * @param c1 : premiere Condition {@link #condition1}
	 * @param c2 : seconde Condition {@link #condition2}
	 */
	public Disjonction(Condition c1,Condition c2){
		condition1=c1;
		condition2=c2;
	}
	
	/**
	 * test la disjonction des tests des deux conditions (si l'un des deux tests est vrai)
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		return condition1.test(g,r) || condition2.test(g,r);
	}
	
	
}
