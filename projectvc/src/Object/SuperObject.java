package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import mechanism.GamePanel;

public class SuperObject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int x,y;
	
	public void draw(Graphics2D g2, GamePanel gp)
	{
		int screenx = x ;
		int screeny = y ;
		g2.drawImage(image, screenx, screeny, gp.tilesets, gp.tilesets, null);
	}

}
