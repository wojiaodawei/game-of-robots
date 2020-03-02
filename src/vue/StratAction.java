package vue;

import ia.StrategieAbstraite;

import java.awt.Composite;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class StratAction extends AbstractAction{
	StrategieAbstraite strat;
	public StratAction(String texte,StrategieAbstraite strat){
		super(texte);
		this.strat = strat;
	}
 
	public void actionPerformed(ActionEvent e) { 
		Composite racine = (Composite) strat.lireRacine();
	} 
}