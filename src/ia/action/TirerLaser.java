package ia.action;

import ia.arbre.Action;
import modele.Robot;

/**
 * classe representant l'action : tirer au laser
 * @author 21306226
 */
public class TirerLaser implements Action{
	/**
	 * execute l'action de tirer au laser au robot r
	 * @param r : robot qui doit tirer au laser
	 */
	@Override
	public void execute(Robot r){
		r.tirerLaser();
	}

}
