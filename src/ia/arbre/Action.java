package ia.arbre; 

import modele.Robot;

/**
 * interface representant une action en general
 * @author 21306226
 */
public interface Action{
	/**
	 * execute l'action en question a un certain robot r
	 * @param r : le robot qui doit executer l'action
	 */
	public void execute(Robot r);
	
}
