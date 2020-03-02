package vue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class QuitterAction extends AbstractAction {
	JFrame f;
	public QuitterAction(String texte){
		super(texte);
	}
	
	public QuitterAction(String texte,JFrame f){
		super(texte);
		this.f=f;
	}
 
	public void actionPerformed(ActionEvent e) { 
		if(f==null){
			System.exit(0);
		}
		f.dispose();
	} 
}
