package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.Controleur;

public class BoutonReprendre extends JButton implements ActionListener{
	Controleur c;
	JButton butPau;
	public BoutonReprendre(Controleur c){
		super("Reprendre");
		this.setEnabled(false);
		this.c=c;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);
		butPau.setEnabled(true);
		c.reprendre();
	}
	
	protected void lierAuJBut(JButton butPau){
		this.butPau=butPau;
	}
}
