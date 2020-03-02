package vue;
import javax.swing.JFrame;

import controleur.Controleur;
import modele.Entite;
import modele.Observeur;

public class VuePrincipale implements Observeur{
	protected FenetreJeu fj;
	private PanneauGrille p;
	protected Controleur controleur;
	public VuePrincipale(Controleur controleur){
		this.controleur=controleur;
	}

	public void lancerFenetreAccueil(){
		FenetreAccueil fa = new FenetreAccueil(controleur);
		controleur.commencer(fa.lireTaille(),fa.lireNbRobots());
	}
	public void nouveauPlateau(int longueur,int largeur){
		System.out.println("nouveau plateau");
		p=new PanneauGrille(longueur,largeur,controleur);
		fj=new FenetreJeu(controleur,p,this);
		controleur.getOrdonnanceur().ajouterListener(fj);
		controleur.getOrdonnanceur().ajouterListenerDeFin(this);
	}
	
	public void ouvertureIA(FenetreJeu fj){
		FenetreIA fenetreIA = new FenetreIA(controleur,this,fj);
		fenetreIA.setVisible(true);
	}
	
	@Override
	public void finDePartie(String gagnant){
		new FenetreFinPartie(gagnant,fj,controleur);
	}

	@Override
	public void metToiAjour(Entite[][] grille) {}
}
