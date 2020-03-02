package ia;

import ia.condition.*;
import ia.action.*;
import ia.arbre.Composant;
import ia.arbre.Composite;
import ia.arbre.Feuille;
import ia.arbre.Noeud;

/**
 * Classe representant la strategie par defaut appliquee a chaque robot en debut de jeu
 * @author 21306226 
 */
public class IAParDefaut extends StrategieConcrete{

	/**
	 * Constructeur logique 
	 * @param nom : nom de la strategie
	 */
	public IAParDefaut(String nom) {
		super(nom);
		/**
		 * Ajout des conditions et des actions en respectant un parcours de profondeur
		 */
		this.ajouterNoeudCondition(new Noeud(new EnnemiDevantMoi()));
		this.ajouterNoeudCondition(new Noeud(new EnnemiAPorteeDeLaser()));
		this.ajouterActions(new Feuille(new TirerLaser()),new Feuille(new TirerMissile()));
		this.ajouterNoeudCondition(new Noeud(new EnergiePourDeplacement()));
		this.ajouterNoeudCondition(new Noeud(new PeutAvancer()));
		this.ajouterActions(new Feuille(new Avancer()),new Feuille(new RotationGauche()));
		this.ajouterFeuille(new Feuille(new Passer()));
	}

}
