package mechanism;

import Object.Key_obj;

public class Asset {
	GamePanel gp;
	
	public Asset(GamePanel gp)
	{
		this.gp = gp;
	}

	public void setObj()
	{
		gp.obj[0] = new Key_obj();
		gp.obj[0].x = gp.tilesets*7;
		gp.obj[0].y = gp.tilesets*7;
		
		
	}
	

}
