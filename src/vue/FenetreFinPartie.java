package vue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controleur.Controleur;

public class FenetreFinPartie extends JOptionPane{
	protected FenetreFinPartie(String gagnant,JFrame fen,Controleur c){
		String[] options = {"Nouvelle Partie","Quitter"};
		int rep =JOptionPane.showOptionDialog(this,"Le "+gagnant+" a gagne !","Fin de partie",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(rep==JOptionPane.YES_OPTION){
			fen.dispose();
			c.recommencer();
		}
		else if(rep == JOptionPane.CLOSED_OPTION || rep==JOptionPane.NO_OPTION){
			System.exit(0);
		}
	}
}
