package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controleur.Controleur;

public class BoutonAjoutCondition extends JButton implements ActionListener{
	Controleur c;
	FenetreIA fen;
	public BoutonAjoutCondition(FenetreIA fen,Controleur c){
		super("Ajouter une condition");
		this.c=c;
		this.fen=fen;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(true);
		/*if((FenetreIA.cp & ((FenetreIA.cp)-1)) == 0){ //si le compteur est une puissance de 2
			//on va � la ligne pour afficher la nouvelle profondeur
		}
		//ajout d'un choixCondition*/
		File repertoireAScanner = new File("src/ia/condition");
		File[] fichiers = repertoireAScanner.listFiles();
		String[] conditions = new String[fichiers.length];
		for(int f=0;f<fichiers.length;++f){
			String nom = fichiers[f].getName();
			conditions[f]=nom.substring(0,nom.length()-5);
		}
		JFrame demandeCondition = new JFrame("Demande une condition");
	    String conditionChoisie = (String) JOptionPane.showInputDialog(demandeCondition, 
	        "Choisissez une condition :\n",
	        "Choix de condition",
	        JOptionPane.QUESTION_MESSAGE, 
	        null, 
	        conditions, 
	        conditions[0]);
	    if(conditionChoisie!=null){
	    	fen.ajouterNoeud(conditionChoisie);
	    }
	}
}
