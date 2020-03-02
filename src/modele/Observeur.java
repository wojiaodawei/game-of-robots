package modele;

/**
 * interface representant un observeur
 * @author 21306226
 */
public interface Observeur {
	/**
	 * met a jour l'observeur en fonction de :
	 * @param grille : la grille de jeu
	 */
	public void metToiAjour(Entite[][] grille);
	
	/**
	 * previent l'observeur que c'est la fin de la partie
	 * @param gagnant : nom du robot gagnant
	 */
	public void finDePartie(String gagnant);
}
