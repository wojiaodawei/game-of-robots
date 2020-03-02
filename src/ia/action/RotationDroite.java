package ia.action;

import modele.Robot;
import ia.arbre.Action;

/**
 * classe representant l'action : rotation de 90degres sur la droite
 * @author 21306226
 */
public class RotationDroite implements Action {
	/**
	 * execute l'action de tourner sur la droite de 90degres au robot r
	 * @param r : robot qui doit tourner de 90degres sur la droite
	 */
	@Override
	public void execute(Robot r){
		r.rotationDroite();
	}
}
