package Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import mechanism.GamePanel;

public class TilesManager {
	//add in gp
	GamePanel gp;
	//number of type tile
	public Tiles[] tile;
	//store the id of tile
	public int[][] map;
	//copy paste cho nhAnh
	
	public TilesManager(GamePanel gp)
	{
		this.gp = gp;
		tile = new Tiles[10];
		getTileImage();
		//map here because gp need to be generate first
		map = new int[gp.maxcol][gp.maxrow];
		loadMap("/maps/map.txt");
	}
	public void getTileImage()
	{
		try
		{
			tile[0] = new Tiles();
			tile[0].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[0].collision = true;
			
			tile[1] = new Tiles();
			tile[1].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[2] = new Tiles();
			tile[2].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String path)
	{
		try {
			InputStream is = getClass().getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int row = 0;
			int col = 0;
			
			while(col < gp.maxcol && row < gp.maxrow)
			{
				String line = br.readLine();
				while(col < gp.maxcol) {
					String number[] = line.split(" ");
					int num = Integer.parseInt(number[col]);
					map[col][row] = num;
					col++;
				}
				if(col == gp.maxcol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}
		catch(Exception e) {
	}
	}
	
	public void draw(Graphics2D g2)
	{
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxcol && row < gp.maxrow) {
			int num = map[col][row];
			g2.drawImage(tile[num].Image, x, y, gp.scale*gp.tileset, gp.scale*gp.tileset, null);
			col++;
			x+= gp.scale*gp.tileset;
			if(col == gp.maxcol) {
				col = 0;
				x = 0; 
				row++;
				y+= gp.scale*gp.tileset;
			}
		}
		
	}

}
