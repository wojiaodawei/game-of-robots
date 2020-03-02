package controleur;
import modele.*;
import vue.VuePrincipale;

import java.util.ArrayList;
import java.util.HashMap;

import ia.IAParDefaut;
import ia.StrategieAbstraite;

/**
 * Classe representant le controleur
 * @author 21306226
 */
public class Controleur{
	/**
	 * le thread/processus du jeu
	 */
	Thread thread;
	/**
	 * la vue principale
	 */
	protected VuePrincipale vue;
	/**
	 * l'ordonnanceur du jeu possedant un accesseur : {@link #getOrdonnanceur()}
	 */
	Ordonnanceur o;
	/**
	 * la grille de jeu
	 */
	Grille grille;
	/**
	 * la taille de la {@link #grille} de jeu
	 */
	protected int taille;
	/**
	 * nombre de robots dans la {@link #grille}
	 */
	protected int nbRobots;
	/**
	 * liste de robots de taille {@link #nbRobots} 
	 */
	protected ArrayList<Robot> listeRobots;
	
	/**
	 * Constructeur par defaut creant la vue principale et lancant l'interaction graphique avec l'utilisateur pour parametrer le jeu
	 */
	public Controleur(){
		vue = new VuePrincipale(this);
		vue.lancerFenetreAccueil();
	}
	
	/**
	 * accesseur de l'{@link #o}
	 * @return {@link #o}
	 */
	public Ordonnanceur getOrdonnanceur(){
		return o;
	}
	
	/**
	 * commencer la partie 
	 * @param taille : {@link #taille}
	 * @param nbRobots : {@link #nbRobots}
	 */
	public void commencer(int taille,int nbRobots){
		listeRobots = new ArrayList<Robot>();
		Robot.listeStrats.put("IA par defaut",new IAParDefaut("IA par defaut"));
		this.taille=taille;
		this.nbRobots=nbRobots;
		grille = new Grille(taille,taille);
		o = new Ordonnanceur(grille); 
		ajouterRobots(taille,nbRobots);
		vue.nouveauPlateau(taille,taille);
		jouer();		
	}

	/**
	 * ajout des robots en fonction de :
	 * @param taille : {@link #taille}
	 * @param nbRobots : {@link #nbRobots}
	 */
	public void ajouterRobots(int taille,int nbRobots){
		for(int r=0;r<nbRobots;++r){
			int posX=(int)(Math.random() * taille);
			int posY=(int)(Math.random() * taille);
			while(grille.contenuCaseEn(posX, posY)!=null){
				posX=(int)(Math.random() * taille);
				posY=(int)(Math.random() * taille);
			}
			int orientation = (int)(Math.random() * 4);
			Robot rob = new Robot("Robot"+(r+1),orientation,posX,posY,grille,o);
			listeRobots.add(rob);
			o.ajouterEntite(rob);
		}
	}
	
	/**
	 * cree un thread, lui ajoute une tache (celle de jouer), et execute celle-ci
	 */
	public void jouer(){
		thread =new Thread(new JeuExecution(o));
		thread.start();
	}
	
	/**
	 * recommencer une partie
	 */
	public void recommencer(){
		thread.stop();
		vue = new VuePrincipale(this);
		vue.lancerFenetreAccueil();
	}
	
	/**
	 * met le jeu en pause
	 */
	public void pause(){
		thread.stop();
	}
	
	/**
	 * reprend la partie la ou elle s'est arrete
	 */
	public void reprendre(){
		jouer();	
	}
	
	/**
	 * accesseur sur la liste de robots du jeu {@link #listeRobots}
	 * @return {@link #listeRobots}
	 */
	public  ArrayList<Robot> lireRobots(){
		return listeRobots;
	}
	
	/**
	 * accesseur sur la liste de strategies des robots
	 * @return le dictionnaire de strategies qui est de la forme {"nom":strategie}
	 */
	public HashMap<String,StrategieAbstraite> lireListeStrats(){
		return Robot.listeStrats;
	}
	
	/**
	 * permet d'ajouter une strategie au dictionnaire de strategies
	 * @param nom : nom de l'IA
	 * @param strategie : strategie
	 */
	public void ajouterStrat(String nom,StrategieAbstraite strategie){
		Robot.listeStrats.put(nom,strategie);
	}
	
	/**
	 * permet de changer la strategie d'un robot
	 * @param r : le robot en question
	 * @param strategie : la strategie qu'il va appliquer
	 */
	public void changerStratRobot(Robot r, String strategie){ //a appeler quand utilisateur change ia dans combobox pour un robot
		r.changerStrategie(strategie);
	}	
}
