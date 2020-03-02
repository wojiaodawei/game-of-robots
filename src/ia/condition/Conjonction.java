package ia.condition; 

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant une conjonction de conditions realisant une Condition
 * @author 21306226
 */
public class Conjonction implements Condition{
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
	public Conjonction(Condition c1,Condition c2){
		condition1=c1;
		condition2=c2;
	}

	/**
	 * test la conjonction des tests des deux conditions (si LES deux tests sont vrais)
	 * @param g : grille de jeu
	 * @param r : robot en question
	 * @return resultat : un booleen
	 */
	@Override
	public boolean test(Grille g,Robot r){
		return condition1.test(g,r) && condition2.test(g,r);
	}
	

}
