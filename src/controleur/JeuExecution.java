package controleur;

import modele.Ordonnanceur;

/**
 * Classe representant la tache a executer par le thread du jeu et qui realise l'interface Runnable
 * @author 21306226
 */
public class JeuExecution implements Runnable{
	/**
	 * represente l'ordonnanceur
	 */
	Ordonnanceur o; 
	/**
	 * Constructeur logique de JeuExecution
	 * @param o l'ordonnanceur
	 */
	protected JeuExecution(Ordonnanceur o){
		this.o=o;
	}
	
	/**
	 * action a effectuer lorsque le thread est active/appele et qui lance ainsi le deroulement du jeu
	 */
    public void run()
    {
    	o.tour();
    }
}