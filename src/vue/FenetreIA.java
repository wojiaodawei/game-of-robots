package vue;

import ia.StrategieAbstraite;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controleur.Controleur;

public class FenetreIA  extends JFrame{
	protected static int cp=0;
    static Controleur c;
    protected JTextField nomIA;
    protected StrategieAbstraite strategie;
    
    JTree arbre;
    private DefaultMutableTreeNode racine;
    private DefaultMutableTreeNode pereCourant;
	private static int profondeur=0;
	
	public FenetreIA(Controleur c,VuePrincipale v,FenetreJeu fj){
		this.c=c;
		
		this.setTitle("Editeur d'IA");
        this.setPreferredSize(new Dimension(300,200));
        
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu();
        menu.setText("Fichier");
        JMenuItem nouveau = new JMenuItem(new NouveauAction("Nouveau",this,v,fj));
		menu.add(nouveau);
		JMenu ouvrir = new JMenu();
		ouvrir.setText("Ouvrir");
		menu.add(ouvrir);
		HashMap<String,StrategieAbstraite> listeStrats = c.lireListeStrats();
		Iterator i = listeStrats.keySet().iterator();		
		while(i.hasNext())
		{
			String nomStrat = (String) i.next();
			JMenuItem strat = new JMenuItem(new StratAction(nomStrat,listeStrats.get(nomStrat)));
			ouvrir.add(strat);
		}
        JMenuItem quitter = new JMenuItem(new QuitterAction("Quitter",this));
		menu.add(quitter);
		mb.add(menu);
        this.setJMenuBar(mb);
		
        Container panel = this.getContentPane();
        BoxLayout bl=new BoxLayout(panel,BoxLayout.Y_AXIS);   //layoutManager
        panel.setLayout(bl); 
        nomIA = new JTextField("Nom de l'IA");
        panel.add(nomIA);
        
        JPanel sousPanel = new JPanel();
        BoxLayout bl2=new BoxLayout(sousPanel,BoxLayout.X_AXIS);   //layoutManager
        sousPanel.setLayout(bl2);
        BoutonAjoutCondition bac = new  BoutonAjoutCondition(this,c);
        sousPanel.add(bac);
        BoutonAjoutAction baa = new  BoutonAjoutAction(this,c);
        sousPanel.add(baa);
        panel.add(sousPanel);

        BoxLayout bl3=new BoxLayout(sousPanel,BoxLayout.Y_AXIS);   //layoutManager
        sousPanel.setLayout(bl3); 

        
        sousPanel.add(new JScrollPane(arbre));
        
        BoutonSubmit submit = new BoutonSubmit(this,c,fj);
        sousPanel.add(submit,BorderLayout.SOUTH);
        
        this.pack();
		this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	
	//a finir
	protected void ajouterNoeud(String valeur){ //ajoute action/condition au jtree et a l'arbre de decision
		Class classe=null;
		try {
			classe = Class.forName(valeur);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Object o = classe.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		if(profondeur==0){
			this.racine = new DefaultMutableTreeNode(valeur.toString());
			pereCourant=racine;
			DefaultTreeModel arbreModele = new DefaultTreeModel(this.racine);
			this.arbre = new JTree(arbreModele); 
			profondeur++;
		}
		else{
			DefaultMutableTreeNode noeud = new DefaultMutableTreeNode(valeur.toString());
			pereCourant.add(noeud);
		}
		if(pereCourant.getChildCount()==profondeur*2){
			pereCourant=(DefaultMutableTreeNode) pereCourant.getChildAt(0);
		}
	}
}
