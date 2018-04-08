/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worlds;

import entities.EntityManager;
import entities.cratures.Enemigo;
import entities.cratures.Enemigo1;
import entities.cratures.Player;
import entities.statics.Tree;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import launcher.Game;
import launcher.Handler;
import tiles.Tile;
import utils.Utils;

/**
 *
 * @author Pedro Gómez
 */
public class World {
    
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private EntityManager entityManager;
	
    public World(Handler handler, String path){
	this.handler=handler;
        entityManager=new EntityManager(handler, new Player(handler,100, 100));
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        entityManager.addEntity(new Tree(handler, 200,200));
    }
	
    public void update(){
        entityManager.update();
        
    }
	
    public void render(Graphics g){
        int xStarT=(int)Math.max(0, handler.getGameCamera().getxOffSet()/Tile.TILEWIDTH);
        int xEnd=(int)Math.min(width, (handler.getGameCamera().getxOffSet()+handler.getWidth())/Tile.TILEWIDTH+1) ;
        int yStart=(int)Math.max(0, handler.getGameCamera().getyOffSet()/Tile.TILEHEIGHT);
        int yEnd=(int)Math.min(height, (handler.getGameCamera().getyOffSet()+handler.getHeight())/Tile.TILEHEIGHT+1); 
        for(int y = yStart;y < yEnd;y++){
            for(int x = xStarT;x < xEnd;x++){
                getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH-handler.getGameCamera().getxOffSet()), (int)(y * Tile.TILEHEIGHT-handler.getGameCamera().getyOffSet() ));
            }
        }
        entityManager.render(g);
    }
	
    public Tile getTile(int x, int y){
	if(x<0 || y<0 || x>=width || y>=height){
            return Tile.grassTile2;
        }
        Tile t = Tile.tiles[tiles[x][y]];
	if(t == null)
            return Tile.grassTile2;
	return t;
    }
	
    private void loadWorld(String path) {
                      System.out.println(path);
	String file = Utils.loadFileAsString(path);
	String[] tokens = file.split("\\s+");
	width = Utils.parseInt(tokens[0]);
	height = Utils.parseInt(tokens[1]);
	spawnX = Utils.parseInt(tokens[2]);
	spawnY = Utils.parseInt(tokens[3]);
	tiles = new int[width][height];
	for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
		tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }
    
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public EntityManager getEntityManager(){
        return entityManager; 
    }
}
