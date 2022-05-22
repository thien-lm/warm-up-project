package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Chess_obj extends SuperObject {
	public Chess_obj()
	{
		name = "door";
		// identify it by a image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

}
}