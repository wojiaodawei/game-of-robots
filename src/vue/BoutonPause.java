package vue;

import controleur.Controleur;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonPause extends JButton implements ActionListener{
	Controleur c;
	JButton butRep;
	public BoutonPause(Controleur c){
		super("Pause");
		this.setEnabled(true);
		this.c=c;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);
		butRep.setEnabled(true);
		c.pause();
	}
	
	protected void lierAuJBut(JButton butRep){
		this.butRep=butRep;
	}
}
