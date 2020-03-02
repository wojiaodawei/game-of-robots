package ia.action;

import ia.arbre.Action;
import modele.Robot;

/**
 * classe representant l'action : passer son tour
 * @author 21306226
 */
public class Passer implements Action{
	/**
	 * execute l'action de passer son tour au robot r
	 * @param r : robot qui doit passer son tour
	 */
	@Override
	public void execute(Robot r){
		r.passerTour();
	}

}
