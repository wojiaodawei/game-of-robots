package modele;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * classe representant l'ordonnanceur du jeu
 * @author 21306226
 */
public class Ordonnanceur{
	/**
	 * liste d'itérateurs de listes d'entites mouvantes
	 * un itérateur de liste contient un robot plus toutes les entites mouvantes qu'il genere
	 */
	ArrayList<ListIterator<EntiteMouvante>> listeIterateurs = new ArrayList<ListIterator<EntiteMouvante>>();
	/**
	 * liste des robots en vie dans le jeu
	 */
	ArrayList<Robot> listeRobots = new ArrayList<Robot>();
	/**
	 * liste des entites mortes 
	 */
	ArrayList<EntiteMouvante> listeMorts = new ArrayList<EntiteMouvante>();
	/**
	 * grille de jeu
	 */
	Grille g;
	/**
	 * liste d'observeurs (interfaces graphiques)
	 */
	ArrayList<Observeur> observeurs = new ArrayList<Observeur>();
	/**
	 * observeur qui attend la fin du jeu
	 */
	Observeur finDeJeu;
	/**
	 * compteur de tour pour faire jouer "equipe" par "equipe"
	 */
	int compteur=0;
	
	/**
	 * constructeur logique
	 * @param g : {@link #g}
	 */
	public Ordonnanceur(Grille g){
		this.g=g;
	}
	
	/**
	 * ajoute un observeur a l'ordonnanceur
	 * @param l : un observeur
	 */
	public void ajouterListener(Observeur l){
		observeurs.add(l);
	}
	
	/**
	 * ajoute un observeur de fin de jeu a l'ordonnanceur
	 * @param l : un observeur
	 */
	public void ajouterListenerDeFin(Observeur l){
		finDeJeu=l;
	}
	
	/**
	 * previent les observeurs d'un changement
	 */
	public void prevenirListener(){
		for(Observeur o : observeurs){
			o.metToiAjour(g.lireGrille());
		}
	}
	
	/**
	 * previent l'observeur de fin de jeu que le jeu est fini
	 * @param nomGagnant : nom du robot gagnant
	 */
	public void prevenirListenerFin(String nomGagnant){
		finDeJeu.finDePartie(nomGagnant);
	}
	
	/**
	 * controle le deroulement du jeu
	 * fait jouer chaque entite chacun son tour
	 */
	public void tour(){
		while(!fin()){
			compteur=compteur%listeIterateurs.size();
			try{Thread.sleep(50);}
			catch(InterruptedException e){}
			ListIterator<EntiteMouvante> it = listeIterateurs.get(compteur);
			if(!it.hasNext()){
				while(it.hasPrevious()){
					it.previous();
				}
			}
			EntiteMouvante entiteQuiJoue = it.next();	
			if(!listeMorts.contains(entiteQuiJoue)){
				entiteQuiJoue.tour();
				prevenirListener();
				compteur++;
			}
			else{
				compteur++; //si on tombe sur une entite qui est morte, tanpis au tour de l'equipe suivante...
			}
		}
		prevenirListenerFin(listeRobots.get(0).lireNom());
	}

	/**
	 * teste si c'est la fin du jeu si il ne reste qu'un seul robot
	 * @return vrai ou faux
	 */
	public boolean fin(){
		return listeRobots.size()<2;
	}
 
	/**
	 * supprime une entite mouvante de l'ordonnanceur
	 * @param e
	 */
	public void supprimEntite(EntiteMouvante e){
		listeMorts.add(e);
		if(e instanceof Robot && listeRobots.contains(e)){
			listeRobots.remove(e);
		}
	}	

	/**
	 * ajoute une nouvelle entite mouvante a l'ordonnanceur
	 * @param nouvelle : entite mouvante a ajouter
	 */
	public void ajouterEntite(EntiteMouvante nouvelle){
		if(nouvelle instanceof Robot){
			listeRobots.add((Robot)nouvelle);
			ListIterator<EntiteMouvante> it = new ArrayList<EntiteMouvante>().listIterator(); 
			it.add(nouvelle);
			listeIterateurs.add(it);
		}
		else{
			listeIterateurs.get(compteur).add(nouvelle);
		}
	}
}
