package ia.action;

import ia.arbre.Action;
import modele.Robot;

/**
 * Classe representant l'action : avancer d'une case
 * @author 21306226
 */
public class Avancer implements Action{
	
	/**
	 * execute l'action d'avancer d'une case au robot r
	 * @param r : robot qui doit avancer d'une case
	 */
	@Override
	public void execute(Robot r){
		r.avancer();
	}

}
