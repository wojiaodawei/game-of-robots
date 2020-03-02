package modele;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * classe representant la grille de jeu
 * @author 21306226
 */
public class Grille{
	/**
	 * tableau 2D d'entites
	 */
	protected Entite[][] grille;
	/**
	 * longueur de {@link #grille}
	 */
	int longueur=0;
	/**
	 * largeur de {@link #grille}
	 */
	int largeur=0;
	
	/**
	 * constructeur logique
	 * @param nLong : {@link #longueur}
	 * @param nLarg : {@link #largeur}
	 */
	public Grille(int nLong,int nLarg){
		longueur=nLong;
		largeur=nLarg;
		grille = new Entite[longueur][largeur];
	}
	
	/**
	 * affiche la grille dans la console
	 */
	public void afficheGrille(){
		for(int i=0;i<largeur;i++){
			for(int j=0;j<longueur;j++){
				System.out.print(grille[j][i]+"  ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * remplir la grille de jeu d'une entite en position (x,y)
	 * @param x : position x de l'entite val
	 * @param y : position y de l'entite val
	 * @param val : l'entite val
	 */
	public void remplirGrille(int x,int y, Entite val){
		grille[x][y]=val;
	}
	
	/**
	 * deplace une entite e d'une position (x1,y1) à (x2,y2)
	 * @param e : l'entite a deplacer
	 * @param x1 : x initial
	 * @param y1 : y initial
	 * @param x2 : x final
	 * @param y2 : y final
	 */
	public void deplacer(EntiteMouvante e,int x1,int y1,int x2, int y2){
		Entite ent = grille[x2][y2];
		if(ent!=null){
			ent.degat();
			e.detruire();
		}
		else{
			remplirGrille(x1,y1,null);
			remplirGrille(x2,y2,e);
			e.changerX(x2);
			e.changerY(y2);
		}	
	}
	
	/**
	 * calcule la position suivante d'une entite en fonction de sa position actuelle et de son orientation
	 * @param x : x actuel
	 * @param y : y actuel
	 * @param orientation : orientation de l'entite en question
	 * @return : liste : {prochainX,prochainY}
	 */
	public int[] positionSuivante(int x,int y,int orientation){
		int prochainX=x;
		int prochainY=y;
		switch(orientation){
			case 0: prochainY=y-1; //Nord
					break;
			case 1:	prochainX=x+1; //Est
					break;
			case 2:	prochainY=y+1; //Sud
					break;
			default: prochainX=x-1; //Ouest
					break;
		}	
		int[] couplePosSuiv = {prochainX,prochainY};
		return couplePosSuiv;
	}
	
	/**
	 * calcule la position precedente d'une entite en fonction de sa position actuelle et de son orientation
	 * c'est la position suivante si l'entite recule...
	 * @param x : x actuel
	 * @param y : y actuel
	 * @param orientation : orientation de l'entite en question
	 * @return : liste : {precedentX,precedentY}
	 */
	public int[] positionPrecedente(int x,int y,int orientation){
		int prochainX=x;
		int prochainY=y;
		switch(orientation){
			case 0: prochainY=y+1; //Nord
					break;
			case 1:	prochainX=x-1; //Est
					break;
			case 2:	prochainY=y-1; //Sud
					break;
			default: prochainX=x+1; //Ouest
					break;
		}	
		int[] couplePosSuiv = {prochainX,prochainY};
		return couplePosSuiv;
	}
	
	/**
	 * accesseur sur la largeur de la grille
	 * @return {@link #largeur}
	 */
	public int nbLignes(){
		return largeur;
	}
	
	/**
	 * accesseur sur la longueur de la grille
	 * @return {@link #longueur}
	 */
	public int nbColonnes(){
		return longueur;
	}
	
	/**
	 * renvoie le contenu de la case en position (posX,posY)
	 * @param posX : position x de la case
	 * @param posY : position y de la case
	 * @return null si il n'y a rien, sinon l'entite presente dans cette case
	 */
	public Entite contenuCaseEn(int posX,int posY){
		return grille[posX][posY];
	}
	
	/**
	 * accesseur sur la grille
	 * @return {@link #grille}
	 */
	public Entite[][] lireGrille() {
		return grille;
	}
	
	/**
	 * scan toutes les entites presentes dans un perimetre donne, par rapport a un joueur
	 * METHODE EN COURS DE CONSTRUCTION 
	 * @param x : x du point de depart 
	 * @param y : y du point de depart 
	 * @param perimetre : perimetre de scan
	 * @return une liste d'entites detectees dans ces environs
	 */
	public ArrayList<Entite> radar(int x,int y,int perimetre){ 
		ArrayList<Entite> res=new ArrayList<Entite>();
		if(perimetre==0){
			return res;
		}
		for(int o=0;o<4;++o){
			int[] posSuivante=this.positionSuivante(x,y,o);
			Entite e = this.contenuCaseEn(posSuivante[0],posSuivante[1]);
			if(e!=null){
				res.add(e);
			}
			res.addAll(radar(posSuivante[0],posSuivante[1],perimetre-1)); //concatene les 2 listes + appel recursif de radar
		}
        Set<Entite> set = new HashSet<Entite>(); //utilisation d'un hashset pour eviter les doublons
        set.addAll(res);
        ArrayList<Entite> listeNettoyee = new ArrayList<Entite>(set) ;
        return res;
	}
}
