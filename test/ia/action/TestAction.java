/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.action;

import modele.Grille;
import modele.Ordonnanceur;
import modele.Robot;

/**
 *
 * @author marwan
 */
public class TestAction {
    public static void run(){
        
        System.out.println(" -----------> Debut des tests des actions.");
        
        assert testActiverBouclier():"Erreur : Test activer bouclier";
        assert testAvancer():"Erreur : Test avancer";
        assert testPasser():"Errreur : Test passer";
        assert testRotationDroite():"Errreur : Test rotation droite";
        assert testRotationGauche():"Errreur : Test rotation gauche";
        assert testTirerLaser():"Erreur : Test tirer laser";
        assert testTirerMissile():"Erreur : Test tirer missile";
        
        System.out.println(" -----------> Tous les tests des actions sont OK.");
        System.out.println(" ");
    }
    /**
     * Test si le robot peut activer son bouclier.
     * 
     * @return true si le robot peut activer son bouclier,
     * sinon false
     */
    public static boolean testActiverBouclier(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 2, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On instancie une nouvelle action
        ActiverBouclier activerBouclier = new ActiverBouclier();
        //On execute l'action associe
        activerBouclier.execute(rob);
        
        return rob.lireBouclier() == true;
    }
    
    /**
     * Test si un robot avance.
     * 
     * @return true si le robot avance,
     * sinon false
     */
    public static boolean testAvancer(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 2, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On instancie une nouvelle action
        Avancer avancer = new Avancer();

        //On execute l'action associe
        avancer.execute(rob);

        boolean robot_a_avancer = grille.contenuCaseEn(0, 1) == rob;
        return robot_a_avancer;
    }
    
    /**
     * Test si un robot passe.
     * 
     * @return true si le robot passe,
     * sinon false
     */
    public static boolean testPasser(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 2, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On instancie une nouvelle action
        Passer passer = new Passer();

        //On execute l'action associe
        passer.execute(rob);

        boolean robotAPasser = grille.contenuCaseEn(0, 0) == rob;
        return robotAPasser;
    }
    
    /** 
     * Test si un robot effectue une rotation a droite.
     * 
     * @return true si le robot effectue une rotation a droite,
     * sinon false
     */
    public static boolean testRotationDroite(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On instancie une nouvelle action
        RotationDroite rotationDroite = new RotationDroite();

        //On execute l'action associe
        rotationDroite.execute(rob);

        boolean robotARotationeDroite = rob.lireOrientation() == 1;
        return robotARotationeDroite;
    }
    
    /** 
     * Test si un robot effectue une rotation a gauche.
     * 
     * @return true si le robot effectue une rotation a gauche,
     * sinon false
     */
    public static boolean testRotationGauche(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On instancie une nouvelle action
        RotationGauche rotationGauche = new RotationGauche();

        //On execute l'action associe
        rotationGauche.execute(rob);

        boolean robotARotationeGauche = rob.lireOrientation() == 3;
        return robotARotationeGauche;
    }
    
    /** 
     * Test si un robot tire un laser.
     * 
     * @return true si le robot tire un laser, sinon false
     */
    public static boolean testTirerLaser(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On instancie une nouvelle action
        TirerLaser tirerLaser = new TirerLaser();

        //On execute l'action associe
        tirerLaser.execute(rob);

        boolean robotATirerLaser = grille.contenuCaseEn(2, 1) != null;
        return robotATirerLaser;
    }
    
    /** 
     * Test si un robot tire un missile.
     * 
     * @return true si le robot tire un missile, sinon false
     */
    public static boolean testTirerMissile(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On instancie une nouvelle action
        TirerMissile tirerMissile = new TirerMissile();

        //On execute l'action associe
        tirerMissile.execute(rob);

        boolean robotATirerMissile = grille.contenuCaseEn(2, 1) != null;
        return robotATirerMissile;
    }
}
