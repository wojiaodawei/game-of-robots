package vue;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MissileSprite extends SpriteAbstrait{
	    
	    public MissileSprite(int orientation){
	    	super(orientation);
		   try {                
		      image = ImageIO.read(new File("src/sprites/missile"+orientation+".png"));
		   } catch (IOException e) {

		   }
	    }
}
