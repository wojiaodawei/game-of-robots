/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.condition;

import modele.Grille;
import modele.Ordonnanceur;
import modele.Robot;

/**
 *
 * @author marwan
 */
public class TestCondition 
{
    public static void run(){
        
        System.out.println(" -----------> Debut des tests des conditions.");
        
        assert testAssezEnergiePourBouclier():"Erreur : Test assez energie pour bouclier";
        assert testAssezEnergiePourDeplacement():"Erreur : Test assez energie pour bouclier";
        assert testAssezEnergiePourLaser():"Erreur : Test assez energie pour laser";
        assert testAssezEnergiePourMissile():"Erreur : Test assez energie pour missile";
        assert testAssezEnergiePourRotation():"Erreur : Test assez energie pour rotation";
        assert testEnnemiAPorteeDeLaser():"Erreur : Test ennemi a portee de laser";
        assert testEnnemiNonAPorteeDeLaser():"Erreur : Test ennemi non a portee de laser";      
        assert testEnnemiDevantMoi():"Erreur : Test ennemi devant moi";
        assert testNegationEnnemiDevantMoi():"Erreur : Test negation ennemi devant moi";
        assert testPeutAvancer():"Erreur : Test peut avancer";
        assert testNePeutAvancer():"Erreur : Test ne peut pas avancer";
        assert testPeutReculer():"Erreur : Test peut reculer";
        assert testNePeutReculer():"Erreur : Test ne peut pas reculer";
        assert testPeutTirer():"Erreur : Test peut tirer";
        assert testNePeutTirer():"Erreur : Test ne peut pas tirer";
        
        System.out.println(" -----------> Tous les tests des conditions sont OK.");
        System.out.println(" ");
    }
    
    /**
     * Test si le robot a assez d'energie pour activer
     * son bouclier
     * 
     * @return true si apres lui avoir retirer de l'energie
     * il ne peut pas utiliser son bouclier, sinon false.
     */
    public static boolean testAssezEnergiePourBouclier(){
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
        
        //On enleve toute l'energie au robot.
        rob.diminuerEnergie(100);
        
        //On initalise une nouvelle condition.
        EnergiePourDeplacement energiePourBouclier = new EnergiePourDeplacement();
        
        //On test savoir si le robot a assez d'energie.
        boolean robotAssezEnergie = energiePourBouclier.test(grille, rob);
        return (!robotAssezEnergie && rob.lireBouclier() == false);
    }
    
    /**
     * Test si le robot a assez d'energie pour se
     * deplacer
     * 
     * @return true si apres lui avoir retirer de l'energie
     * il ne peut pas se deplacer, sinon false.
     */
    public static boolean testAssezEnergiePourDeplacement(){
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
        
        //On enleve toute l'energie au robot.
        rob.diminuerEnergie(100);
        
        //On initalise une nouvelle condition.
        EnergiePourDeplacement energiePourDeplacement = new EnergiePourDeplacement();
        
        //On test savoir si le robot a assez d'energie.
        boolean robotAssezEnergie = energiePourDeplacement.test(grille, rob);
        return (!robotAssezEnergie && grille.contenuCaseEn(0, 0) == rob);
    }
    
    /**
     * Test si le robot a assez d'energie pour
     * tirer un laser
     * 
     * @return true si apres lui avoir retirer de l'energie
     * il ne peut pas tirer de laser, sinon false.
     */
    public static boolean testAssezEnergiePourLaser(){
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
        
        //On enleve toute l'energie au robot.
        rob.diminuerEnergie(100);
        
        rob.tirerLaser();
        
        //On initalise une nouvelle condition.
        EnergiePourLaser energiePourLaser = new EnergiePourLaser();
        
        //On test savoir si le robot a assez d'energie.
        boolean robotAssezEnergie = energiePourLaser.test(grille, rob);
        return (!robotAssezEnergie && grille.contenuCaseEn(0, 1) == null);
    }
    
    /**
     * Test si le robot a assez d'energie pour
     * tirer un missile
     * 
     * @return true si apres lui avoir retirer de l'energie
     * il ne peut pas tirer de missile, sinon false.
     */
    public static boolean testAssezEnergiePourMissile(){
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
        
        //On enleve toute l'energie au robot.
        rob.diminuerEnergie(100);
        
        rob.tirerMissile();
        
        //On initalise une nouvelle condition.
        EnergiePourMissile energiePourMissile = new EnergiePourMissile();
        
        //On test savoir si le robot a assez d'energie.
        boolean robotAssezEnergie = energiePourMissile.test(grille, rob);
        return (!robotAssezEnergie && grille.contenuCaseEn(0, 1) == null);
    }
    
    /**
     * Test si le robot a assez d'energie pour
     * effectuer une rotation
     * 
     * @return true si apres lui avoir retirer de l'energie
     * il ne peut pas effectuer une rotation, sinon false.
     */
    public static boolean testAssezEnergiePourRotation(){
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
        
        //On enleve toute l'energie au robot.
        //Comme il passe son tour avant la rotation
        //il regagne 25 d'energie
        //donc on lui retire plus que son maximum.
        rob.diminuerEnergie(125);
        //On essaye de lui faire faire une rotation
        rob.rotationDroite();
        
        //On initalise une nouvelle condition.
        EnergiePourRotation energiePourRotation = new EnergiePourRotation();
        
        //On test savoir si le robot a assez d'energie.
        boolean robotAssezEnergie = energiePourRotation.test(grille, rob);
        return (!robotAssezEnergie && rob.lireOrientation() == 2);
    }
    
    /**
     * Test si le robot a un ennemi a porte de tire de laser
     * 
     * @return true si le robot 1 a ennemi a porte
     * de tire de laser, sinon false.
     */
    public static boolean testEnnemiAPorteeDeLaser(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob1 = new Robot("", 2, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob1);
        
        //On initialise un deuxieme robot sur cette grille.
        //A porte de laser du robot 1
        Robot rob2 = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob2);
        
        //On initalise une nouvelle condition.
        EnnemiAPorteeDeLaser ennemiAPorteeDeLaser = new EnnemiAPorteeDeLaser();
        
        //On test savoir si le robot a assez d'energie.
        boolean RobotAEnnemiAPorteeDeLaser = ennemiAPorteeDeLaser.test(grille, rob1);
        return RobotAEnnemiAPorteeDeLaser;
    }
    
    /**
     * Test si le robot n'a pas un ennemi a porte de tire de laser
     * 
     * @return true si le robot 1 n'a pas d'ennemi a porte
     * de tire de laser, sinon false.
     */
    public static boolean testEnnemiNonAPorteeDeLaser(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob1 = new Robot("", 2, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob1);
        
        //On initialise un deuxieme robot sur cette grille.
        //pas a porte de laser du robot 1
        Robot rob2 = new Robot("", 0, 0, 4, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob2);
        
        //On initalise une nouvelle condition.
        EnnemiAPorteeDeLaser ennemiNonAPorteeDeLaser = new EnnemiAPorteeDeLaser();
        
        //On test savoir si le robot a assez d'energie.
        boolean RobotAEnnemiAPorteeDeLaser = ennemiNonAPorteeDeLaser.test(grille, rob1);
        return (!RobotAEnnemiAPorteeDeLaser);
    }
    
    /**
     * Test si le robot a un ennemi devant lui.
     * 
     * @return true si le robot 1 a un ennemi devant lui, 
     * sinon false.
     */
    public static boolean testEnnemiDevantMoi(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob1 = new Robot("", 2, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob1);
        
        //On initialise un deuxieme robot sur cette grille.
        //sur la meme ligne d'orientation du robot 1
        Robot rob2 = new Robot("", 0, 0, 4, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob2);
        
        //On initalise une nouvelle condition.
        EnnemiDevantMoi ennemiDevantMoi = new EnnemiDevantMoi();
        //On test savoir si le robot 2 est enface du robot 1.
        boolean RobotEnnemiDevantMoi = ennemiDevantMoi.test(grille, rob1);
        return RobotEnnemiDevantMoi;
    }
    
    /**
     * Test si le robot n'a pas un ennemi devant lui a l'aide
     * de la classe Negation.
     * 
     * @return true si le robot 1 n'a pas un ennemi devant lui, 
     * sinon false.
     */
    public static boolean testNegationEnnemiDevantMoi(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob1 = new Robot("", 2, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob1);
        
        //On initialise un deuxieme robot sur cette grille.
        //sur la meme ligne d'orientation du robot 1
        Robot rob2 = new Robot("", 0, 0, 4, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob2);
        
        //On initalise une nouvelle condition.
        Negation negationEnnemiDevantMoi = new Negation(new EnnemiDevantMoi());
        
        //On test savoir si le robot 2 est enface du robot 1.
        boolean RobotEnnemiDevantMoi = negationEnnemiDevantMoi.test(grille, rob1);
        return (!RobotEnnemiDevantMoi);
    }
    
    /**
     * Test si le robot peut avancer
     *
     * @return true si le robot peut avancer devant lui, 
     * sinon false.
     */
    public static boolean testPeutAvancer(){
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
        
        //On initalise une nouvelle condition.
        PeutAvancer peutAvancer = new PeutAvancer();
        
        //On test savoir si le robot peut avancer.
        boolean RobotPeutAvancer = peutAvancer.test(grille, rob);
        return RobotPeutAvancer;
    }
    
    /**
     * Test si le robot ne peut pas avancer
     *
     * @return true si le robot ne peut pas avancer devant lui, 
     * sinon false.
     */
    public static boolean testNePeutAvancer(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On initalise une nouvelle condition.
        PeutAvancer peutAvancer = new PeutAvancer();
        
        //On test savoir si le robot peut avancer.
        boolean RobotPeutAvancer = peutAvancer.test(grille, rob);
        return (!RobotPeutAvancer);
    }
    
    /**
     * Test si le robot peut reculer
     *
     * @return true si le robot peut reculer, 
     * sinon false.
     */
    public static boolean testPeutReculer(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On initalise une nouvelle condition.
        PeutReculer peutReculer = new PeutReculer();
        
        //On test savoir si le robot 2 est enface du robot 1.
        boolean RobotPeutReculer = peutReculer.test(grille, rob);
        return RobotPeutReculer;
    }
    
    /**
     * Test si le robot ne peut pas reculer
     *
     * @return true si le robot ne peut pas reculer, 
     * sinon false.
     */
    public static boolean testNePeutReculer(){
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
        
        //On initalise une nouvelle condition.
        PeutReculer peutReculer = new PeutReculer();
        
        //On test savoir si le robot 2 est enface du robot 1.
        boolean RobotPeutReculer = peutReculer.test(grille, rob);
        return (!RobotPeutReculer);
    }
    
    /**
     * Test si le robot peut tirer
     *
     * @return true si le robot peut tirer, 
     * sinon false.
     */
    public static boolean testPeutTirer(){
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
        
        //On initalise une nouvelle condition.
        PeutTirer peutTirer = new PeutTirer();
        
        //On test savoir si le robot peut tirer.
        boolean RobotPeutTirer = peutTirer.test(grille, rob);
        return RobotPeutTirer;
    }
    
    /**
     * Test si le robot ne peut pas tirer
     *
     * @return true si le robot ne peut pas tirer, 
     * sinon false.
     */
    public static boolean testNePeutTirer(){
        //On initialise d'abors une grille.
        int largeur = 5;
        int longueur = 5;
        
        Grille grille = new Grille(largeur, longueur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 0, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On initalise une nouvelle condition.
        PeutTirer peutTirer = new PeutTirer();
        
        //On test savoir si le robot 2 est enface du robot 1.
        boolean RobotPeutTirer = peutTirer.test(grille, rob);
        return (!RobotPeutTirer);
    }
}
