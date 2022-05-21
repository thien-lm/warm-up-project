package mechanism;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity1.Player;
import Object.SuperObject;
import Tile.TilesManager;

public class GamePanel extends JPanel implements Runnable{
	//screen setting
	public int tileset = 16;
	public int scale = 3;
	public int maxrow = 12;
	public int maxcol = 16;
	public int screenWidth = tileset*maxcol;
	public int screenHeight = tileset*maxrow;
	public int tilesets = tileset * scale;
	//default pos
//	private int playerX = 100;
//	private int playerY = 100;
//	private int speed = 3;
	//fps
	//private int fps = 60;
	//private int timer = 0;
	
	//khoi tao cac doi tuong cua lop khac
	Thread thread;
	KeyHandle keyH = new KeyHandle();
	Player player = new Player(this, keyH);
	TilesManager tilemanager = new TilesManager(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	
	public Asset aset = new Asset(this);
	public SuperObject obj[] = new SuperObject[10];
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth*scale, screenHeight*scale));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		// it should be here
		this.addKeyListener(keyH);

		this.setFocusable(true);
	
	}
	public void SetupGame()
	{
		aset.setObj();
	}
	public void StartGame()
	{
		thread = new Thread(this);
		thread.start();
		//auto call to run method below
	}
//// muc dich cua thread:
//	1, tao mot luong chuong trinh moi
//	2, update lien tuc cac thong so theo thoi gian
//	
	public void run() {
		// TODO Auto-generated method stub
	    // delta strategy
		double inteval = 1000000000/60;
		long lastTime = System.nanoTime();
		long currentTime;
		double delta = 0;
		long timer = 0;
		int drawCount = 0;
		
		while(thread!=null) 
		{
		//	System.out.println("running");
		currentTime = System.nanoTime();
		//number of frame drew in this time
		delta += (currentTime - lastTime)/inteval; 
		timer += currentTime - lastTime;
		lastTime = currentTime;
		//if có then draw a screen
		if(delta >= 1)
		{
		
		
	    //update information etc pos
		
		//re-draw screen
		
		delta--;
		drawCount++;
		update();
		repaint(); //auto call to paint component
		
		}
		if(timer >= 1000000000)
		{
			System.out.println(drawCount);
			timer = 0;
			drawCount = 0;
		}
		}
	}
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tilemanager.draw(g2);
		
		for(int i=0; i<obj.length; i++)
		{
			if(obj[i]!=null)
			obj[i].draw(g2, this);
		}
		//map need to be draw before player
		player.draw(g2);
		g2.dispose();
	}

}
