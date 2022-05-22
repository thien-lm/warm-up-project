package mechanism;

import Object.Chess_obj;
import Object.Door_obj;
import Object.Key_obj;
//set place of object, instanceate them
public class Asset {
	GamePanel gp;
	
	public Asset(GamePanel gp)
	{
		this.gp = gp;
	}

	public void setObj()
	{
		gp.obj[0] = new Door_obj();
		gp.obj[0].x = gp.tilesets*7;
		gp.obj[0].y = gp.tilesets*7;
		
		gp.obj[2] = new Key_obj();
		gp.obj[2].x = gp.tilesets*8;
		gp.obj[2].y = gp.tilesets*8;
		
		gp.obj[1] = new Chess_obj();
		gp.obj[1].x = gp.tilesets*7;
		gp.obj[1].y = gp.tilesets*4;
		
		gp.obj[4] = new Door_obj();
		gp.obj[4].x = gp.tilesets*1;
		gp.obj[4].y = gp.tilesets*1;
		
	}
	

}
