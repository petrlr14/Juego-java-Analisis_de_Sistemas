/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Pedro Gómez
 */
public class Tile {
        public static Tile[] tiles = new Tile[256];
	public static Tile grassTile1 = new GrassTile1(0);
	public static Tile grassTile2 = new GrassTile2(1);
	public static Tile grassTile3 = new GrassTile3(2);
	public static Tile grassTile4 = new GrassTile4(3);
        public static Tile block1=new Block1(4);
	public static Tile block2=new Block2(5);
        //CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
}
