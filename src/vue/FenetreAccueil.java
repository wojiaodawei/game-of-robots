package vue;

import javax.swing.JOptionPane;
import controleur.Controleur;

public class FenetreAccueil extends JOptionPane{
	private int taille=0;
	private int nbRobots=0;
	public FenetreAccueil(Controleur c){
		int rep1 = JOptionPane.showConfirmDialog(null,"Bienvenue dans le jeu Game of Trobots\n\nVoulez-vous commencer ?", "Menu principal", JOptionPane.YES_NO_OPTION);
		if(rep1 == JOptionPane.CLOSED_OPTION || rep1==JOptionPane.NO_OPTION){
			System.exit(0);
		}
		while(taille<10){
			String repTaille=showInputDialog(this, "Taille de la grille : ");
			if(repTaille==null){
				System.exit(0);
			}
			try{
				taille=Integer.parseInt(repTaille);
				if(taille<10){
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException e){
				System.err.println("ERREUR la taille doit etre superieure ou egale a 10 !");
				showMessageDialog(this,"ERREUR la taille doit etre superieure ou egale a 10 !");
			}
		}
		while(nbRobots<2){
			String repNbRobots=showInputDialog(this, "Nombre de robots : ");
			if(repNbRobots==null){
				System.exit(0);
			}
			try{
				nbRobots=Integer.parseInt(repNbRobots);
				if(nbRobots<2){
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException e){
				System.err.println("ERREUR le nombre de robots doit etre superieur ou egal a 2 !");
				showMessageDialog(this,"ERREUR le nombre de robots doit etre superieur ou egal a 2 !");
			}
		}
		
	}
	
	public int lireTaille(){
		return taille;
	}
	public int lireNbRobots(){
		return nbRobots;
	}
}
