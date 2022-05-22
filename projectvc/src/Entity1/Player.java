package Entity1;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import mechanism.GamePanel;
import mechanism.KeyHandle;

public class Player extends Entity {
	GamePanel gp  ;
	KeyHandle keyH ;
//	private Image image;
	
	int hasKey = 0;
	 
	public Player( GamePanel gp, KeyHandle kh)
	{
		this.gp = gp;
		this.keyH = kh;
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		//store solid area because we'll change it later
		solidDefaultX = solidArea.x;
		solidDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		setDefault();
		getPlayerImage();
	}
	
	public void setDefault()
	{
		x = 100;
		y = 100;
		speed = 3;
		direction = "right";
	}
	
	public void getPlayerImage()
	{
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		if(keyH.up == true) 
		{
			direction = "up";
		//y -= speed;
		}
	else if(keyH.down == true) 
		{
		direction = "down";
		//y += speed;
		}
	else if(keyH.left == true)
		{
		direction = "left";
	//	x -= speed;
		}
		
	else if(keyH.right == true)
		{
		direction = "right";
	//	x += speed;
		}
		//check tile collision
		collisonOn = false;
		gp.cChecker.checkTile(this);
		//if collision = false player can move
		//ditme phan nay sai lam vc
		//-1h30p to fix bug
		
		//CHECK OBJECT COLLISION
		int objindex = gp.cChecker.CheckObject(this, true);
		System.out.println(objindex);
		selectobj(objindex);
		
		
		if(collisonOn == false)
		{
//			switch(direction)
//			{
//			case("up"): y -= speed; break;
//			case("down"): y += speed; break;
//			case("left"): x -= speed; break;
//			case("right"): x += speed; break;
//			}
			if(keyH.up == true) 
			{
				direction = "up";
			y -= speed;
			}
		else if(keyH.down == true) 
			{
			direction = "down";
			y += speed;
			}
		else if(keyH.left == true)
			{
			direction = "left";
			x -= speed;
			}
			
		else if(keyH.right == true)
			{
			direction = "right";
			x += speed;
			}
	
		}
	}
	public void selectobj(int i)
	{
		if(i != 999)
		{
			String name = gp.obj[i].name;
			if(name == "key") 
			{
				hasKey ++;
				gp.obj[i] = null;
			}
			
			if(name == "door")
			{
				if(hasKey > 0)
				{
				gp.obj[i] = null;
				hasKey--;
				}
			}
				
		}
	}
	
	public void draw(Graphics2D g2) 
	{
//		g2.setColor(Color.WHITE);
//		g2.fillRect(x, y, gp.tileset*gp.scale , gp.tileset*gp.scale);
//		ImageIcon ii = new ImageIcon("res/player/boy_down_1.png");
//        image = ii.getImage();
		g2.drawImage(up, x , y, gp.tileset*gp.scale, gp.tileset*gp.scale, null);
		
	}

}
