package ia.action;

import ia.arbre.Action;
import modele.Robot;

/**
 * classe representant l'action : reculer d'une case
 * @author 21306226
 */
public class Reculer implements Action{
	/**
	 * execute l'action de reculer d'une case au robot r
	 * @param r : robot qui doit reculer d'une case
	 */
	@Override
	public void execute(Robot r){
		r.reculer();
	}

}
