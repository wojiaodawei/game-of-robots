package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BoutonIA extends JButton implements ActionListener{
	VuePrincipale v;
	FenetreJeu fj;
	public BoutonIA(VuePrincipale v,FenetreJeu fj){
		super("Editer les IA");
		this.fj=fj;
		this.v=v;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(true);
		v.ouvertureIA(fj);
	}

}
