package ia.condition; 

import ia.arbre.Condition;
import modele.Grille;
import modele.Robot;

/**
 * classe representant la negation d'une Condition
 * @author 21306226
 */
public class Negation implements Condition{
	/**
	 * condition sur laquelle il faut appliquer la negation
	 */
	Condition c;	
	/**
	 * constructeur logique 
	 * @param c : la condition {@link #c}
	 */
	public Negation(Condition c){
		this.c=c;
	}
	
	/**
	 * teste la negation de la condition en question
	 */
	@Override
	public boolean test(Grille g,Robot r){
		return !(c.test(g,r));
	}
	

}
