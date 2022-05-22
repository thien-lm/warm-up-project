package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door_obj extends SuperObject{
	public Door_obj()
	{
		name = "door";
		// identify it by a image
		collision = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

}
}
