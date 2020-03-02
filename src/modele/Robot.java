package modele; 

import ia.IAParDefaut;
import ia.StrategieAbstraite;

import java.util.HashMap;

/**
 * classe Robot qui permet d'implementer un robot avec ses attributs
 * de vie, d'energie et un booleen bouclier et toutes les
 * actions qui caracterisent un robot
 * un robot est une entite mouvante orientee
 * @author 21306226
 */

public class Robot extends EntiteMouvante{

	protected int energie=100;
	protected final int energieMax = 100;
	/**
	 * nom du robot
	 */
	protected String nom;
	
	/**
	 * dictionnaire static des IA existantes 
	 */
	public static HashMap<String,StrategieAbstraite> listeStrats = new HashMap<String,StrategieAbstraite>();
	
	protected boolean bouclier = false;
	
	protected StrategieAbstraite strategie;
	
	public Robot(String nom, int orientation, int x, int y,Grille grille,Ordonnanceur o){
		super(orientation,x,y,grille,o);
		this.nom=nom;
		strategie=this.listeStrats.get("IA par defaut");
	}	
	
	public void diminuerEnergie(int nouvelleEnergie) {
        energie -= nouvelleEnergie;
    }
	
	public void changerStrategie(String nom){
		strategie=Robot.listeStrats.get(nom);
	}
	
	public StrategieAbstraite lireStrategie(){
		return strategie;
	}
	
	public HashMap<String,StrategieAbstraite> lireListeStrats(){
		return listeStrats;
	}
	
	//Accesseurs//

	public int lireEnergie(){
		return energie;
	}

	public int lireEnergieMax(){
		return energieMax;
	}
	
	public String lireNom(){
		return nom;
	}
	
	public boolean lireBouclier(){
		return bouclier;
	}

	public void ecrireBouclier(boolean activite){
		bouclier = activite;
	}

	//Methode qui permet de tirer un laser.
	public void tirerLaser(){
		int[] posSuivante = grille.positionSuivante(posX, posY, orientation);
		if(this.energie>=75 && posSuivante[0]>=0 && posSuivante[0]<grille.nbColonnes() && posSuivante[1]>=0 && posSuivante[1]<grille.nbLignes()){
			this.energie -= 75;
			Laser laser = new Laser(orientation,posSuivante[0],posSuivante[1],grille,o);
			o.ajouterEntite(laser);
		}
		else{
			this.passerTour();
		}
	}
	
	//Methode qui permet de tirer un missile.
	//Sachant que le robot PEUT en tirer un
	public void tirerMissile(){
		int[] posSuivante = grille.positionSuivante(posX, posY, orientation);
		if(this.energie>=50 && posSuivante[0]>=0 && posSuivante[0]<grille.nbColonnes() && posSuivante[1]>=0 && posSuivante[1]<grille.nbLignes()){
			this.energie -= 50;
			Missile missile = new Missile("missile",orientation,posSuivante[0],posSuivante[1],grille,o);
			o.ajouterEntite(missile); //ajouter a l'ordonnanceur
		}
		else{
			this.passerTour();
		}
	}


	//Methode qui permet d'activer son bouclier.
	//On test si a chaque debut de ton tour le bouclier est
	//a true, on le passe a false.
	public void activerBouclier(){
		if(this.energie>=25){
			this.energie -= 25;
			this.ecrireBouclier(true);
		}
		else{
			this.passerTour();
		}
	}
	
	//Methode qui permet de passer son tour pour recuperer toute son
	// energie
	public void passerTour(){
		if(this.energie>(this.energieMax-25)){
			this.energie=100;
		}
		this.energie += 25; 
	}
	
	
	//Permet au robot de faire une rotation maximal de 90° en
	//fonction de son orientation.
	//Consomme 1 unité d'energie
	public void rotationGauche(){
		if(this.energie>=5){
			this.energie -= 5;
			this.orientation=(this.orientation+3)%4;
			System.out.println("orientation "+this.orientation);
		}
		else{
			this.passerTour();
		}
	}

	public void rotationDroite(){
		if(this.energie>=5){
			this.energie -= 5;
			this.orientation=(this.orientation+1)%4;	
		}
		else{
			this.passerTour();
		}
	}
	
	@Override
	public void degat(){
		if(!this.lireBouclier()){
			vie = vie - 1;
		}
		if(vie==0){
			this.detruire();
		}
	}

	@Override
    public void avancer() {
        int[] posSuivante = grille.positionSuivante(posX, posY, orientation);
        int prochainX = posSuivante[0];
        int prochainY = posSuivante[1];
        
        if (this.energie >= 10 && prochainX >= 0 && prochainX < grille.nbColonnes() && prochainY >= 0 && prochainY < grille.nbLignes()) {
            this.energie -= 10;
            if(grille.contenuCaseEn(prochainX, prochainY) instanceof Laser){
                this.detruire();
                Entite entite = grille.contenuCaseEn(prochainX, prochainY);
                ((Laser)entite).tour();
            }
            else{
                grille.deplacer(this, posX, posY, prochainX, prochainY);
                posX = prochainX;
                posY = prochainY;
            }
        } 
        else {
            this.passerTour();
        }
    }


	public void reculer(){
		int[] posSuivante = grille.positionPrecedente(posX, posY, orientation);
		int prochainX=posSuivante[0];
		int prochainY=posSuivante[1];
		if(this.energie>=10 && prochainX>=0 && prochainX<grille.nbColonnes() && prochainY>=0 && prochainY<grille.nbLignes()){
			this.energie-=10;
			grille.deplacer(this, posX,posY,prochainX,prochainY);
			posX=prochainX;
			posY=prochainY;
		}
		else{
			this.passerTour();
		}
	}
	
	@Override
	public void tour(){
		if(bouclier){
			this.ecrireBouclier(false);
		}
		//demande a son IA actuelle quoi faire
		strategie.action(grille,this);
	}
	
}
