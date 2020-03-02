package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controleur.Controleur;

public class BoutonAjoutAction extends JButton implements ActionListener{
	Controleur c;
	FenetreIA fen;
	public BoutonAjoutAction(FenetreIA fen,Controleur c){
		super("Ajouter une action");
		this.c=c;
		this.fen=fen;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(true);
		/*if((FenetreIA.cp & ((FenetreIA.cp)-1)) == 0){ //si le compteur est une puissance de 2
			//on va à la ligne pour afficher la nouvelle profondeur
		}
		//ajout d'un choixAction*/
		File repertoireAScanner = new File("src/ia/action");
		File[] fichiers = repertoireAScanner.listFiles();
		String[] actions = new String[fichiers.length];
		for(int f=0;f<fichiers.length;++f){
			String nom = fichiers[f].getName();
			actions[f]=nom.substring(0,nom.length()-5);
		}
		JFrame demandeAction = new JFrame("Demande une action");
		String actionChoisie = (String) JOptionPane.showInputDialog(demandeAction, 
	        "Choisissez une action :\n",
	        "Choix d'action",
	        JOptionPane.QUESTION_MESSAGE, 
	        null, 
	        actions, 
	        actions[0]);
	    if(actionChoisie!=null){
	    	fen.ajouterNoeud(actionChoisie);
	    }
	}
}
