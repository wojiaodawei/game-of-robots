package ia; 

import ia.arbre.Action;
import ia.arbre.Composite;
import ia.arbre.Condition;
import ia.arbre.Feuille;
import ia.arbre.Noeud;

import java.util.ArrayList;

import modele.Grille;
import modele.Robot;

/**
 * interface strategie abstraite implementant le design pattern Strategy
 * @author 21306226 
 */
public interface StrategieAbstraite{

	/**
	 * liste de composites
	 */
	ArrayList<Composite> listeComposites = new ArrayList<Composite>();
	
	/**
	 * ajouter a l'arbre un noeud Condition
	 * @param c : un Noeud Condition
	 */
	void ajouterNoeudCondition(Noeud c);
	
	/**
	 * ajouter a l'arbre deux feuilles actions
	 * @param gauche : Feuille Action a ajouter a gauche
	 * @param droite : Feuille Action a ajouter a droite
	 */
	void ajouterActions(Feuille gauche,Feuille droite);
	
	/**
	 * ajouter a l'arbre une feuille
	 * @param action : une Feuille Action
	 */
	void ajouterFeuille(Feuille action);
	
	/**
	 * parcourir l'arbre 
	 * @param g : la grille de jeu
	 * @param r : le robot executant cette strategie
	 */
	void action(Grille g,Robot r);
	
	/**
	 * lit la racine de l'arbre pour un futur editeur d'IA ou il sera possible de modifier une IA existante
	 * @return un composite : la racine
	 */
	Composite lireRacine();
	
}
