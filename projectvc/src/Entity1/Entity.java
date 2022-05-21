package Entity1;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
// a super class of object etc player and npc or ...
public class Entity {
	public int x,y;
	public int speed;
	
	public BufferedImage up, down, left, right;
	public String direction;
	//part of tile that's solid
	public Rectangle solidArea;
	
	public boolean collisonOn = false;

}
