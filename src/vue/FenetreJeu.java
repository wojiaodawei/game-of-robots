package vue;

import  javax.swing.*;

import  java.awt.*;
import java.util.ArrayList;

import controleur.Controleur;
import modele.Entite;
import modele.Observeur;
import modele.Robot;

public class FenetreJeu extends JFrame implements Observeur{
	private JPanel contentRightPanel;
	private Controleur c;
	private VuePrincipale v;
	public FenetreJeu(Controleur c,PanneauGrille p,VuePrincipale v){
		this.c=c;
		this.v=v;
		
		this.setTitle("Game of Trobots");
		this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu();
        menu.setText("Fichier");
        JMenuItem nouvellePartie = new JMenuItem(new NouvellePartieAction("Nouvelle partie",this,c));
		menu.add(nouvellePartie);
        JMenuItem quitter = new JMenuItem(new QuitterAction("Quitter"));
		menu.add(quitter);
		mb.add(menu);
        this.setJMenuBar(mb);
        
        Container contentPane = this.getContentPane();
        //contentPane.setBackground(Color.green);
        
		BoxLayout bl=new BoxLayout(contentPane,BoxLayout.Y_AXIS);   //layoutManager
		contentPane.setLayout(bl);                      //attache le layoutManager au panel    
		
        JLabel  lab=new JLabel("Game of Trobots");  //cr�� un label
        Font font = new Font("Georgia",Font.BOLD,20);
        lab.setFont(font);
        contentPane.add(lab);  //l'ajoute au panel  
        lab.setLocation(this.getWidth() / 2 - lab.getWidth() / 2, this.getHeight() / 2 - lab.getHeight() / 2);
        
        //un 2eme panel qui va etre imbriqu� dans le 1er panel !
        JPanel  contentPaneGame=new JPanel();   //2eme panel
        BoxLayout bl2=new BoxLayout(contentPaneGame,BoxLayout.X_AXIS);   //layoutManager
        contentPaneGame.setLayout(bl2);                      //attache le layoutManager au panel   
        
        contentPaneGame.add(p);    
        
        //contentPaneGame.setBackground(Color.yellow);
        contentPaneGame.setBorder(BorderFactory.createMatteBorder(3,0,0,0, Color.BLACK));
        
        JPanel rightPanel = new JPanel();
        contentRightPanel = new JPanel();     
        remplirRightPanel();
        
		//contentRightPanel.setBackground(Color.red);
		
		rightPanel.add(contentRightPanel);
		rightPanel.setBorder(BorderFactory.createMatteBorder(0,3,0,0, Color.BLACK));
		
		//rightPanel.setBackground(Color.blue);
		
		contentPane.add(contentPaneGame);       
		contentPaneGame.add(rightPanel, BorderLayout.LINE_END);
		
		rightPanel.setPreferredSize(new Dimension(rightPanel.getWidth()-900,rightPanel.getHeight()));  
		contentRightPanel.setPreferredSize(new Dimension(200,650)); 

        this.pack();
        this.setVisible(true);
        //this.setResizable(false);
	}
	
	private void remplirRightPanel(){
		BoxLayout bl3=new BoxLayout(contentRightPanel,BoxLayout.Y_AXIS);   //layoutManager
		contentRightPanel.setLayout(bl3);                    //attache le layoutManager au panel
        BoutonPause boutonPause = new BoutonPause(c);
        boutonPause.setPreferredSize(new Dimension(0,40));
        contentRightPanel.add(boutonPause);
        BoutonReprendre boutonReprendre = new BoutonReprendre(c);
        boutonReprendre.setPreferredSize(new Dimension(0,40));
        contentRightPanel.add(boutonReprendre);
        boutonPause.lierAuJBut(boutonReprendre);
        boutonReprendre.lierAuJBut(boutonPause);
		BoutonIA boutonIA = new BoutonIA(v,this);
		boutonIA.setPreferredSize(new Dimension(0,40));
		contentRightPanel.add(boutonIA);
		System.out.println("REMPLIR RIGHT PANEL");
		ArrayList<Robot> listeRobots = c.lireRobots();
		for(int r=0;r<listeRobots.size();++r){
			System.out.println(r);
			Robot rob = listeRobots.get(r);
			if(rob.estVivant()){
				JLabel  labName=new JLabel(rob.lireNom());
				labName.setPreferredSize(new Dimension(0,40));
				contentRightPanel.add(labName);
				ChoixIA choixIA = new ChoixIA(c,rob);
				choixIA.setPreferredSize(new Dimension(0,40));
				contentRightPanel.add(choixIA);
				JProgressBar pbar = new JProgressBar();
				pbar.setPreferredSize(new Dimension(0,40));
			    pbar.setMinimum(0);
			    pbar.setMaximum(rob.lireEnergieMax());
			    pbar.setValue(rob.lireEnergie());
			    pbar.setBackground(Color.white);
			    pbar.setForeground(Color.green);
			    contentRightPanel.add(pbar);
				JLabel  labBouc=new JLabel("Bouclier : "+(rob.lireBouclier()?"Actif":"Inactif"));
				if(rob.lireBouclier()){
					labBouc.setForeground(new Color(0,255,0));
				}
				else{
					labBouc.setForeground(new Color(255,0,0));
				}
				labBouc.setPreferredSize(new Dimension(0,40));
				contentRightPanel.add(labBouc);
			}
		}
	}
	
	public void miseAJour(){
		contentRightPanel.removeAll();
		this.remplirRightPanel();
		contentRightPanel.repaint();
		contentRightPanel.validate();
	}

	@Override
	public void metToiAjour(Entite[][] grille) {
		miseAJour();
	}

	@Override
	public void finDePartie(String gagnant) {}

}
