package vue;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

abstract class SpriteAbstrait extends JPanel{
	protected BufferedImage image;

	SpriteAbstrait(int orientation){};
    
    protected BufferedImage lireImage(){
    	return image;
    }
}
