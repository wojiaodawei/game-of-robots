/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Arrays;

public class TestModele 
{
    public static void run(){
        
        System.out.println(" -----------> Debut des tests du modele.");
        
        assert avanceRobotHaut():"Erreur : Avance robot haut";
        assert avanceRobotGauche():"Erreur : Avance robot gauche";
        assert avanceRobotDroite():"Erreur : Avance robot droite";
        assert avanceRobotBas():"Erreur : Avance robot bas";
        
        assert reculeRobotHaut():"Erreur : Recule robot haut";
        assert reculeRobotGauche():"Erreur : Recule robot gauche";
        assert reculeRobotDroite():"Erreur : Recule robot droite";
        assert reculeRobotBas():"Erreur : Recule robot bas";
        
        assert tourneRobotDroite():"Erreur : Tourne robot droite";
        assert tourneRobotGauche():"Erreur : Tourne robot gauche";
        
        assert perdEnergieEnTirantMissile():"Erreur : Perd energie en tirant missile";
        assert perdEnergieEnTirantLaser():"Erreur : Perd energie en tirant laser";
        assert perdEnergieEnActivantBouclier():"Erreur : Perd energie en activant bouclier";
        assert gagneEnergieEnPassantTour():"Erreur : Gagne energie en passant tour";
        
        assert disparitionMissileCollisionFace():"Erreur : Disparition missile collision face";
        assert disparitionMissileCollisionCote():"Erreur : Disparition missile collision cote";       
        assert disparitionMissileCollisionDerriere():"Erreur : Disparition missile collision derriere";
        assert disparitionMissileHaut():"Erreur : Disparition missile cote haut";
        assert disparitionMissileBas():"Erreur : Disparition missile cote bas";
        assert disparitionMissileDroite():"Erreur : Disparition missile cote droite";       
        assert disparitionMissileGauche():"Erreur : Disparition missile cote gauche";
        
        assert robotMeurtSiBouclierInactif():"Erreur : Robot meurt si bouclier inactif";
        assert robotNeMeurtPasSiBouclierActif():"Erreur : Robot ne meurt pas si bouclier actif";
        assert mortDeDeuxRobotsQuandCollision():"Erreur : Mort de deux robots quand collision";
        assert SurvieDuRobotsSurPlaceQuandCollisionAvecBouclier():"Erreur : Survie du robots sur place quand collision avec bouclier";
        assert mortDunRobotQuandDeplacementPuisCollisionAvecLaser():"Erreur : Mort d'un robots quand collision avec un laser apres deplacement du robot";
        
        System.out.println(" -----------> Tous les tests du modele sont OK.");
        System.out.println(" ");
    }
    
    /**
     * Test si un robot ne depasse pas le cote nord de la grille en avancant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean avanceRobotHaut(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("",0,0,0,grille,null);
        rob.avancer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posXEgale0 = rob.lireX() == 0;
        return posXEgale0;
    }
    
    /**
     * Test si un robot ne depasse pas le cote gauche de la grille en avancant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean avanceRobotGauche(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("",3,0,0,grille,null);
        rob.avancer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posYEgale0 = rob.lireY() == 0;
        return posYEgale0;
    }
    
    /**
     * Test si un robot ne depasse pas le cote droit de la grille en avancant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean avanceRobotDroite(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 3, longueur-1, largeur-1, grille, null);
        rob.avancer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posYEgaleLongueur = rob.lireY() == longueur-1;
        return posYEgaleLongueur;
    }
    
    /**
     * Test si un robot ne depasse pas le cote bas de la grille en avancant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean avanceRobotBas(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 2, longueur-1, largeur-1, grille, null);
        rob.avancer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posXEgaleLongueur = rob.lireX() == largeur-1;
        return posXEgaleLongueur;
    }
    
    /**
     * Test si un robot ne depasse pas le cote nord de la grille en reculant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean reculeRobotHaut(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("",0,0,0,grille,null);
        rob.reculer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posXEgale0 = rob.lireX() == 0;
        return posXEgale0;
    }
    
    /**
     * Test si un robot ne depasse pas le cote gauche de la grille en reculant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean reculeRobotGauche(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("",2,0,0,grille,null);
        rob.reculer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posYEgale0 = rob.lireY() == 0;
        return posYEgale0;
    }
    
    /**
     * Test si un robot ne depasse pas le cote droit de la grille en reculant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean reculeRobotDroite(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 3, longueur-1, largeur-1, grille, null);
        rob.reculer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posYEgaleLongueur = rob.lireY() == longueur-1;
        return posYEgaleLongueur;
    }
    
    /**
     * Test si un robot ne depasse pas le cote bas de la grille en reculant.
     * 
     * @return true si le robot n'a pas depasse la grille, sinon false.
     */
    public static boolean reculeRobotBas(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 4, longueur-1, largeur-1, grille, null);
        rob.reculer();

        //On test si apres deplacement du robot il est toujours positionner en haut a gauche.
        boolean posXEgaleLargeur = rob.lireX() == largeur-1;
        return posXEgaleLargeur;
    }
    
    /**
     * Test si un robot tourne correctement du cote droit.
     * 
     * @return true si le robot tourne du cote droit, sinon false.
     */
    public static boolean tourneRobotDroite(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 0, grille, null);
        rob.rotationDroite();
        
        boolean aTourneADroite = rob.lireOrientation() == 1;
        return aTourneADroite;
    }
    
    /**
     * Test si un robot tourne correctement du cote gauche.
     * 
     * @return true si le robot tourne du cote droit, sinon false.
     */
    public static boolean tourneRobotGauche(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 0, grille, null);
        rob.rotationGauche();
        
        boolean aTourneAGauche = rob.lireOrientation() == 3;
        return aTourneAGauche;
    }
    
    /**
     * Teste si un robot perd reellement de l'energie 
     * en tirant un missile.
     * 
     * @return true si le robot perd de l'energie, sinon false.
     */
    public static boolean perdEnergieEnTirantMissile(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        rob.tirerMissile();
        
        boolean energieRestanteApresTire = rob.lireEnergie() == 50;
        return energieRestanteApresTire;
    }
    
    
    
    /**
     * Teste si un robot perd reellement de l'energie 
     * en tirant un laser.
     * 
     * @return true si le robot perd de l'energie, sinon false.
     */
    public static boolean perdEnergieEnTirantLaser(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        rob.tirerLaser();
        
        boolean energieRestanteApresTire = rob.lireEnergie() == 25;
        return energieRestanteApresTire;
    }
    
    /**
     * Teste si un robot perd reellement de l'energie 
     * en activant son bouclier.
     * 
     * @return true si le robot perd de l'energie, sinon false.
     */
    public static boolean perdEnergieEnActivantBouclier(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        rob.activerBouclier();
        
        boolean energieRestanteApresBouclier = rob.lireEnergie() == 75;
        return energieRestanteApresBouclier;
    }
    
    /**
     * Teste si un robot regagne reellement de l'energie 
     * en passant son tour.
     * 
     * @return true si le robot gagne de l'energie, sinon false.
     */
    public static boolean gagneEnergieEnPassantTour(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        //On enleve de l'energie au robot (ici -50).
        rob.tirerMissile();
        
        rob.passerTour();
        
        boolean energieRestaure = rob.lireEnergie() == 75;
        return energieRestaure;
    }
    
    /**
     * Teste si un missile disparait apres 
     * contact de face direct.
     *
     * @return true si les missiles sont disparu, sinon false
     */
   public static boolean disparitionMissileCollisionFace(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile1 = new Missile("", 1, 1, 1, grille, ordo);
        //On ajoute le premier missile regardant vers la droite a l'ordonnanceur.
        ordo.ajouterEntite(missile1);
        
        Missile missile2 = new Missile("", 3, 2, 1, grille, ordo);
        //On ajoute le deuxieme missile regardant vers la gauche a l'ordonnanceur.
        ordo.ajouterEntite(missile2);
        
        //On fait avancer le missile1.
        missile1.tour();
        
        //On test si le lieu de collision est bien egale a null.
        boolean missilesDetruit = grille.contenuCaseEn(2, 1) == null;
        return missilesDetruit;
   }
   
   /**
    * Teste si un missile disparait apres contact 
    * de cote.
    * 
    * @return true si les missiles sont disparu, sinon false
    */
    public static boolean disparitionMissileCollisionCote(){
        //on initialise une grille
        int longeur = 5;
        int largeur = 5;
        Grille grille = new Grille(longeur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile1 = new Missile("", 1, 1, 1, grille, ordo);
        //On ajoute le premier missile regardant vers la droite a l'ordonnanceur.
        ordo.ajouterEntite(missile1);
        
        Missile missile2 = new Missile("", 0, 2, 1, grille, ordo);
        //On ajoute le deuxieme missile regardant vers le haut a l'ordonnanceur.
        ordo.ajouterEntite(missile2);
     
        //On fait avancer le missile1.
        missile1.tour();
        
        //On test si le lieu de collision est bien egale a null.
        boolean missilesDetruit = grille.contenuCaseEn(2, 1) == null;
        return missilesDetruit;
    }
    
    /**
    * Teste si un missile disparait apres contact 
    * de derriere.
    * 
    * @return true si les missiles sont disparu, sinon false
    */
    public static boolean disparitionMissileCollisionDerriere(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 2, 2, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile1 = new Missile("", 0, 1, 1, grille, ordo);
        //On ajoute le premier missile regardant vers le haut a l'ordonnanceur.
        ordo.ajouterEntite(missile1);
        
        Missile missile2 = new Missile("", 0, 1, 0, grille, ordo);
        //On ajoute le deuxieme missile regardant vers le haut a l'ordonnanceur.
        ordo.ajouterEntite(missile2);
        
        //On fait avancer le missile1.
        missile1.tour();
        
        //On test si le lieu de collision est bien egale a null.
        boolean missilesDetruit = grille.contenuCaseEn(1, 0) == null;
        return missilesDetruit;
    }
    
    /**
     * Test si un missile disparait par le cote nord de la grille en avancant.
     * 
     * @return true si le missile disparait de la grille, sinon false.
     */
    public static boolean disparitionMissileHaut(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile = new Missile("", 0, 0, 0, grille, ordo);
        //On ajoute le premier missile regardant vers le haut a l'ordonnanceur.
        ordo.ajouterEntite(missile);
        
        //On fait avancer le missile.
        missile.tour();

        //On test si le lieu de collision est bien egale a null.
        boolean missileDetruit = grille.contenuCaseEn(0, 0) == null;
        return missileDetruit;
    }
    
    /**
     * Test si un missile disparait par le cote sud de la grille en avancant.
     * 
     * @return true si le missile disparait de la grille, sinon false.
     */
    public static boolean disparitionMissileBas(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile = new Missile("", 2, longueur-1, largeur-1, grille, ordo);
        //On ajoute le premier missile regardant vers le bas a l'ordonnanceur.
        ordo.ajouterEntite(missile);
        
        //On fait avancer le missile.
        missile.tour();

        //On test si le lieu de collision est bien egale a null.
        boolean missileDetruit = grille.contenuCaseEn(longueur-1, largeur-1) == null;
        return missileDetruit;
    }
    
    /**
     * Test si un missile disparait par le cote droite de la grille en avancant.
     * 
     * @return true si le missile disparait de la grille, sinon false.
     */
    public static boolean disparitionMissileDroite(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile = new Missile("", 1, longueur-1, largeur-1, grille, ordo);
        //On ajoute le premier missile regardant vers le bas a l'ordonnanceur.
        ordo.ajouterEntite(missile);
        
        //On fait avancer le missile.
        missile.tour();

        //On test si le lieu de collision est bien egale a null.
        boolean missileDetruit = grille.contenuCaseEn(longueur-1, largeur-1) == null;
        return missileDetruit;
    }
    
    /**
     * Test si un missile disparait par le cote gauche de la grille en avancant.
     * 
     * @return true si le missile disparait de la grille, sinon false.
     */
    public static boolean disparitionMissileGauche(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile = new Missile("", 3, 0, 0, grille, ordo);
        //On ajoute le premier missile regardant vers le bas a l'ordonnanceur.
        ordo.ajouterEntite(missile);
        
        //On fait avancer le missile.
        missile.tour();

        //On test si le lieu de collision est bien egale a null.
        boolean missileDetruit = grille.contenuCaseEn(0, 0) == null;
        return missileDetruit;
    }   
    
    /**
     * Test si un robot disparait de la grille si 
     * un missile le touche et qu'il n'a pas son bouclier.
     * 
     * @return true si le robot disparait de la grille, sinon false.
     */
    public static boolean robotMeurtSiBouclierInactif(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile = new Missile("", 2, 0, 0, grille, ordo);
        //On ajoute le premier missile regardant vers le bas a l'ordonnanceur.
        ordo.ajouterEntite(missile);
        
        //On s'assure que le bouclier n'est pas active.
        rob.ecrireBouclier(false);
        //On fait avancer le missile.
        missile.tour();
        
        //On test si le lieu de collision est bien egale a null.
        boolean robotDetruit = grille.contenuCaseEn(0, 1) == null;
        return robotDetruit;
    }
    
    /**
     * Test si un robot ne disparait pas de la grille si 
     * un missile le touche quand il a son bouclier.
     * 
     * @return true si le robot reste sur la grille, sinon false.
     */
    public static boolean robotNeMeurtPasSiBouclierActif(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob);
        
        Missile missile = new Missile("", 2, 0, 0, grille, ordo);
        //On ajoute le premier missile regardant vers le bas a l'ordonnanceur.
        ordo.ajouterEntite(missile);
        
        //On active le bouclier du robot.
        rob.ecrireBouclier(true);
        //On fait avancer le robot 1.
        missile.tour();
        
        //On test si le lieu de collision est bien egale au robot.
        boolean robotNonDetruit = grille.contenuCaseEn(0, 1) == rob;
        return robotNonDetruit;
    }
    
    /**
     * Test si lors d'une collision de deux robots,
     * ceux-ci disparaissent de la grille.
     * 
     * @return true si les deux robot disparaissent de la grille, sinon false.
     */
    public static boolean mortDeDeuxRobotsQuandCollision(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise deux robot sur cette grille.
        Robot rob1 = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot1 a l'ordonnanceur.
        ordo.ajouterEntite(rob1);
        
        Robot rob2 = new Robot("", 0, 0, 0, grille, ordo);
        //On ajoute le robot2 a l'ordonnanceur.
        ordo.ajouterEntite(rob2);

        //On fait avancer le robot1.
        rob1.avancer();
        
        //On test si le lieu de collision est bien egale au robot.
        boolean DeuxRobotsDetruit = grille.contenuCaseEn(0, 0) == null;
        return DeuxRobotsDetruit;
    }
    
    /**
     * Test si lors d'une collision de deux robots avec bouclier,
     * ceux-ci reste sur la grille.
     * 
     * @return true si les deux robot disparaissent de la grille, sinon false.
     */
    public static boolean SurvieDuRobotsSurPlaceQuandCollisionAvecBouclier(){
        //on initialise une grille
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);

        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise deux robot sur cette grille.
        Robot rob1 = new Robot("", 0, 0, 1, grille, ordo);
        //On ajoute le robot1 a l'ordonnanceur.
        ordo.ajouterEntite(rob1);
        
        Robot rob2 = new Robot("", 0, 0, 0, grille, ordo);
        //On ajoute le robot2 a l'ordonnanceur.
        ordo.ajouterEntite(rob2);

        //On active le bouclier pour les deux robots.
        rob1.ecrireBouclier(true);
        rob2.ecrireBouclier(true);

        //On fait avancer le robot 1.
        rob1.avancer();

        //On test si le lieu de collision est bien egale au robot 2.
        boolean Robot1Detruit = grille.contenuCaseEn(0, 0) == rob2;
        return Robot1Detruit;
    }
    
    public static boolean mortDunRobotQuandDeplacementPuisCollisionAvecLaser(){
        //On initialise d'abors une grille.
        int longueur = 5;
        int largeur = 5;
        Grille grille = new Grille(longueur, largeur);
        
        //On initialise un ordonnanceur sur cette grille.
        Ordonnanceur ordo = new Ordonnanceur(grille);
        
        //On initialise un robot sur cette grille.
        Robot rob1 = new Robot("", 1, 1, 2, grille, ordo);
        
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob1);
        
        //On initialise un robot sur cette grille.
        Robot rob2 = new Robot("", 2, 2, 1, grille, ordo);
        
        //On ajoute le robot a l'ordonnanceur.
        ordo.ajouterEntite(rob2);
        //On fait tirer un laser au robot 1
        rob1.tirerLaser();
        //On fait avancer le robot 2 sur une partie du laser
        rob2.avancer();
        //Methode de ordonnanceur, qui prouve qu'il n'y a plus
        //qu'un robots sur la grille.
        boolean mortDuRobot2EtDuLaser = ordo.fin();
        return mortDuRobot2EtDuLaser && grille.contenuCaseEn(2, 2) == null && grille.contenuCaseEn(3, 2) == null;
    }
}

