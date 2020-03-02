package ia.action;

import modele.Robot;
import ia.arbre.Action;

/**
 * Classe representant l'action : activer le bouclier
 * @author 21306226
 */
public class ActiverBouclier implements Action{
	
	/**
	 * execute l'action d'activer le bouclier au robot r
	 * @param r : robot dont le bouclier doit etre active
	 */
	@Override
	public void execute(Robot r){
		r.activerBouclier();
	}

}
