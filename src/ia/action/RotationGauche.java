package ia.action;

import ia.arbre.Action;
import modele.Robot;

/**
 * classe representant l'action : rotation de 90degres sur la gauche
 * @author 21306226
 */
 public class RotationGauche implements Action{
	/**
	 * execute l'action de tourner sur la gauche de 90degres au robot r
	 * @param r : robot qui doit tourner de 90degres sur la gauche
	 */
	@Override
	public void execute(Robot r){
		r.rotationGauche();
	}
}
