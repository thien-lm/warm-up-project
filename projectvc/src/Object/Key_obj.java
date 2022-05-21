package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Key_obj extends SuperObject{
	
	public Key_obj()
	{
		name = "key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
