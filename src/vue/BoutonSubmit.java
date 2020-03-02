package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controleur.Controleur;

public class BoutonSubmit extends JButton implements ActionListener{
	FenetreIA fen;
	Controleur c;
	FenetreJeu fj;
	public BoutonSubmit(FenetreIA fen,Controleur c,FenetreJeu fj){
		super("Valider");
		this.fen=fen;
		this.fj=fj;
		this.c=c;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fen.dispose();
		c.ajouterStrat(fen.nomIA.getText(),fen.strategie);
		fj.miseAJour();
	}
}
