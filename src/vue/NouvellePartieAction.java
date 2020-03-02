package vue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import controleur.Controleur;

public class NouvellePartieAction extends AbstractAction{
		private Controleur c;
		private JFrame fen;
		public NouvellePartieAction(String texte,JFrame fen,Controleur c){
			super(texte);
			this.fen=fen;
			this.c=c;
		}
	 
		public void actionPerformed(ActionEvent e) { 
			
			fen.dispose();
			c.recommencer();
		} 
	
}
