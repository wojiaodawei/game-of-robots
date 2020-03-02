package ia.arbre; 

import java.util.ArrayList;

import modele.Grille;
import modele.Robot;

/**
 * classe representant un composite qui realise Composant
 * @author 21306226
 */

public class Composite implements Composant{
	/**
	 * Noeud de condition : le composite
	 */
	Noeud c;
	
	/**
	 * liste des Composants fils de ce composite
	 */
	protected ArrayList<Composant> composantsFils = new ArrayList<Composant>();
	
	/**
	 * constructeur logique
	 * @param condition : le noeud condition definissant ce composite
	 */
	public Composite(Noeud condition){
		this.c=condition;
	}

	/**
	 * methode permettant d'ajouter un composant fils a ce composite
	 * @param composant : fils a ajouter
	 */
	public void ajouterComposant(Composant composant)
	{
		composantsFils.add(composant);
	}
	
	/**
	 * methode permettant de supprimer un composant fils
	 * @param composant : fils a supprimer
	 */
	public void supprComposant(Composant composant)
	{
		composantsFils.remove(composant);
	}
	
	/**
	 * action du composite ayant le meme objectif que celle de composant
	 */
	@Override
	public void action(Grille g, Robot r)
	{		
		if(c.c.test(g,r)){
			composantsFils.get(0).action(g,r);
		}
		else{
			composantsFils.get(1).action(g,r);
		}
	}
	
	/**
	 * accesseur sur les fils du composite
	 * @return la liste des fils du composite {@link #composantsFils}
	 */
	public ArrayList<Composant> getFils(){
		return composantsFils;
	}

}


