package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import mechanism.GamePanel;
// super class of objects
//1 create object
//2 place them
//3 draw
public class SuperObject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int x,y;
	//draw them on the screen
	public void draw(Graphics2D g2, GamePanel gp)
	{
		int screenx = x ;
		int screeny = y ;
		g2.drawImage(image, screenx, screeny, gp.tilesets, gp.tilesets, null);
	}
	//rectangle of superobject
	public Rectangle rec = new Rectangle(0,0,48,48);
	public int solidDefaultX = 0;
	public int solidDefaultY = 0;

}
