package ia; 
import ia.arbre.Action;

import ia.arbre.Composite;
import ia.arbre.Condition;
import ia.arbre.Feuille;
import ia.arbre.Noeud;
import ia.condition.ToujoursVrai;
import modele.Grille;
import modele.Robot;

/**
 * strategie concrete realisant l'interface strategie abstraite
 * @author 21306226
 */
public class StrategieConcrete implements StrategieAbstraite{
	/**
	 * nom de la strategie
	 */
	final String nom;

	/**
	 * constructeur logique
	 * @param nom : {@link #nom} de la strategie
	 */
	public StrategieConcrete(String nom){
		this.nom=nom;
		listeComposites.add(new Composite(new Noeud(new ToujoursVrai())));
	}
	
	/**
	 * ajouter a l'arbre un noeud Condition
	 * @param condition : un Noeud Condition
	 */
	@Override
	public void ajouterNoeudCondition(Noeud condition){
		Composite comp = new Composite(condition);
		listeComposites.get(listeComposites.size()-1).ajouterComposant(comp);
		listeComposites.add(comp);
	}
	
	/**
	 * ajouter a l'arbre deux feuilles actions
	 * @param gauche : Feuille Action a ajouter a gauche
	 * @param droite : Feuille Action a ajouter a droite
	 */
	@Override
	public void ajouterActions(Feuille gauche,Feuille droite){
		listeComposites.get(listeComposites.size()-1).ajouterComposant(gauche);
		listeComposites.get(listeComposites.size()-1).ajouterComposant(droite);
		listeComposites.remove(listeComposites.size()-1);
	}
	
	/**
	 * ajouter a l'arbre une feuille
	 * @param action : une Feuille Action
	 */
	@Override
	public void ajouterFeuille(Feuille action){
		listeComposites.get(listeComposites.size()-1).ajouterComposant(action);
		/*if(compteur%2==0){
			listeComposites.remove(listeComposites.size()-1);
		}*/
		//listeComposites.remove(listeComposites.size()-1);
	}

	/**
	 * commence a parcourir l'arbre en partant de la racine
	 * @param g : la grille de jeu
	 * @param r : le robot executant cette strategie
	 */
	@Override
	public void action(Grille g,Robot r){
		listeComposites.get(0).action(g,r);
	}

	/**
	 * lit la racine de l'arbre pour un futur editeur d'IA ou il sera possible de modifier une IA existante
	 * @return un composite : la racine
	 */
	@Override
	public Composite lireRacine() {
		return listeComposites.get(0);
	}
}
