package mechanism;

import Entity1.Entity;

public class CollisionChecker {
	GamePanel gp;
	
	public  CollisionChecker(GamePanel gp)
	{
		this.gp = gp;
	}
	
	public void checkTile(Entity entity)
	{
		//pos of entity on the map
		int leftpos = entity.x + entity.solidArea.x;
		int rightpos = entity.x + entity.solidArea.x + entity.solidArea.width;
		int toppos = entity.y + entity.solidArea.y;
		int botpos = entity.y + entity.solidArea.y + entity.solidArea.height;
		//pos with index row-col
		int leftcol = (leftpos )/gp.tilesets;
		int rightcol = (rightpos ) / gp.tilesets;
		int toprow = (toppos ) / gp.tilesets;
		int botrow = (botpos) / gp.tilesets;
		//number store pos
		int tile1, tile2;
		//check collision each type ( up down left right)
		switch(entity.direction) {
		case("up"): 
		toprow = (toppos - entity.speed) / gp.tilesets;
		tile1 = gp.tilemanager.map[leftcol][toprow];
		tile2 = gp.tilemanager.map[rightcol][toprow];
		//System.out.println(tile1);
		if(gp.tilemanager.tile[tile1].collision == true || gp.tilemanager.tile[tile2].collision == true) 
		{
			
			entity.collisonOn = true;
		} break;
		case("down"):
		 
			botrow =( botpos + entity.speed) / gp.tilesets;
			tile1 = gp.tilemanager.map[leftcol][botrow];
			tile2 = gp.tilemanager.map[rightcol][botrow];
			//System.out.println(tile1);
			if(gp.tilemanager.tile[tile1].collision == true || gp.tilemanager.tile[tile2].collision == true) 
			{
				
				entity.collisonOn = true;
			} break;
		
		case("left"):
	    leftcol = (leftpos - entity.speed) / gp.tilesets;
		tile1 = gp.tilemanager.map[leftcol][toprow];
		tile2 = gp.tilemanager.map[leftcol][botrow];
		//System.out.println(tile1);
		if(gp.tilemanager.tile[tile1].collision == true || gp.tilemanager.tile[tile2].collision == true) 
		{
			
			entity.collisonOn = true;
		} break;
			
		case("right"):
		rightcol = (rightpos + entity.speed) / gp.tilesets;
		tile1 = gp.tilemanager.map[rightcol][toprow];
		tile2 = gp.tilemanager.map[rightcol][botrow];
		//System.out.println(tile1);
		if(gp.tilemanager.tile[tile1].collision == true || gp.tilemanager.tile[tile2].collision == true) 
		{
			
			entity.collisonOn = true;
		} break;
		}
	}

}
