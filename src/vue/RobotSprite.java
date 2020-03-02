package vue;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RobotSprite extends SpriteAbstrait{
	    
	    public RobotSprite(int orientation){
	    	super(orientation);
		   try {                
		      image = ImageIO.read(new File("src/sprites/robot"+orientation+".png"));
		   } catch (IOException e) {

		   }
	    }
}
