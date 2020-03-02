package ia.action;

import ia.arbre.Action;
import modele.Robot;

/**
 * classe representant l'action : tirer un missile
 * @author 21306226
 */
public class TirerMissile implements Action{
	/**
	 * execute l'action de tirer un missile au robot r
	 * @param r : robot qui doit tirer un missile
	 */
	@Override
	public void execute(Robot r){
		r.tirerMissile();
	}

}
