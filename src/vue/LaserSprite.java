package vue;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LaserSprite extends SpriteAbstrait{
	  public LaserSprite(int orientation){
	    	super(orientation);
		   try {                
		      image = ImageIO.read(new File("src/sprites/laser"+orientation+".png"));
		   } catch (IOException e) {

		   }
	    }
}
