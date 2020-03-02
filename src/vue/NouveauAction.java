package vue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class NouveauAction extends AbstractAction{
	private JFrame fen;
	private VuePrincipale v;
	FenetreJeu fj;
	public NouveauAction(String texte,JFrame fen,VuePrincipale v,FenetreJeu fj){
		super(texte);
		this.fen=fen;
		this.fj=fj;
		this.v=v;
	}
 
	public void actionPerformed(ActionEvent e) { 
		fen.dispose();
		v.ouvertureIA(fj);
	} 
}
