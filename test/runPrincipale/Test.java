/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runPrincipale;

import ia.condition.TestCondition;
import ia.action.TestAction;
import modele.TestModele;

/**
 * Class permettant de lancer tous les test du projet.
 *
 * @author marwan
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("================> Debut des tests... ");
        System.out.println(" ");

        TestModele.run();
        TestCondition.run();
        TestAction.run();

        System.out.println("================> Tous les tests sont OK. ");
    }
}
