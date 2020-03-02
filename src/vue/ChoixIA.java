package vue;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JComboBox;

import controleur.Controleur;
import ia.StrategieAbstraite;
import modele.Robot;

public class ChoixIA extends JComboBox<String> implements ItemListener{
	Controleur c;
	Robot r;
	public ChoixIA(Controleur c,Robot r){
		super();
		this.c=c;
		this.r=r;
		this.addItemListener(this);
		HashMap<String,StrategieAbstraite> listeStrats = c.lireListeStrats();
		Iterator<String> i = listeStrats.keySet().iterator();		
		while(i.hasNext())
		{
		    this.addItem((String) i.next());
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if ((e.getStateChange() == ItemEvent.SELECTED)) {
			c.changerStratRobot(r,this.getSelectedItem().toString());
		}
	}	
}
