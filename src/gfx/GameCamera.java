/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import entities.Entity;
import launcher.Game;
import launcher.Handler;
import tiles.Tile;

/**
 *
 * @author Pedro Gómez
 */
public class GameCamera {
    
    private float xOffSet, yOffSet;
    private Handler handler;
    public GameCamera(Handler handler, float xOffSet, float yOffSet){
        this.xOffSet=xOffSet;
        this.yOffSet=yOffSet;
        this.handler=handler;
    }

    public void move(float xAmt, float yAmt){
        xOffSet+=xAmt;
        yOffSet+=yAmt;
        checkBlankSpace();
    }
    
    public void checkBlankSpace(){
        if(xOffSet<0){
            xOffSet=0;
        }else if(xOffSet>handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth()){
            xOffSet=handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth();
        }
        if(yOffSet<0){
            yOffSet=0;
        }else if(yOffSet>handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight()){
            yOffSet=handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight();
        }
    }
    
    public void centerOnEntity(Entity e){
        /*
        xOffSet = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffSet = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
        */
        float lerp = 0.1f;
        xOffSet += lerp * (e.getX() - handler.getWidth() / 2 + e.getWidth() / 2 - xOffSet);
        yOffSet += lerp * (e.getY() - handler.getHeight() / 2 + e.getHeight() / 2 - yOffSet);
        checkBlankSpace();
    }
    
    public float getxOffSet() {
        return xOffSet;
    }

    public void setxOffSet(float xOffSet) {
        this.xOffSet = xOffSet;
    }

    public float getyOffSet() {
        return yOffSet;
    }

    public void setyOffSet(float yOffSet) {
        this.yOffSet = yOffSet;
    }
    
}
