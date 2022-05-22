package Object;

import java.io.IOException;

import javax.imageio.ImageIO;
// one child object of superclass 
public class Key_obj extends SuperObject{
	
	public Key_obj()
	{
		name = "key";
		// identify it by a image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
