/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import launcher.Game;
import launcher.Handler;

/**
 *
 * @author Pedro Gómez
 */
public abstract class Entity {

    
    protected int width, height;
    protected float x, y;
    protected Handler handler;
    protected Rectangle bounds;
    
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds=new Rectangle(0,0,width, height);
    }
    
    public boolean checkCollision(float xOffSet, float yOffSet){
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffSet, yOffSet))){
                return true;
            }
        }
        return false;
    }
    
    public Rectangle getCollisionBounds(float xOffSet, float yOffSet){
        return new Rectangle((int)(x+bounds.x+xOffSet), (int)(y+bounds.y+yOffSet), bounds.width, bounds.height);
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
    public abstract void update();
    public abstract void render(Graphics g);
}
